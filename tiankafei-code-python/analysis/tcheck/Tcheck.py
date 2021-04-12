# t校验分析算法

# scipy.stats.ttest_ind（t检验）
# scipy.stats.ttest_1samp（单样本t检验）
# scipy.stats.ttest_rel（paired-t检验）

import pandas as pd
import scipy.stats as st
import numpy as np
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = 't检验分析算法'
example_index_name = '工业总产值-本期'
example_item_name = '轻工业'


class TcheckParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    value_list_1: list[int] = Field(title='满足选项条件的指标数值集合')
    value_list_2: list[int] = Field(title='满足选项条件的指标数值集合')

    class Config:
        title = '【' + method_view_name + '】t检验:满足选项条件的指标参数'


class ResultDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    statistic: Optional[float] = Field(title='')
    pvalue: Optional[float] = Field(title='')
    avg_1: Optional[float] = Field(title='平均值1')
    std_1: Optional[float] = Field(title='标准差1')
    avg_2: Optional[float] = Field(title='平均值2')
    std_2: Optional[float] = Field(title='标准差2')

    class Config:
        title = '【' + method_view_name + '】指标结果'


class SingleSampleParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    standard_value: float = Field(title='标准值')
    value_list: list[int] = Field(title='指标数值集合')

    class Config:
        title = '【' + method_view_name + '】单样本t检验:指标数值集合参数'


class PairedTcheckPerParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    value_list: list[int] = Field(title='指标数值集合')

    class Config:
        title = '【' + method_view_name + '】paired-t检验:指标数值集合参数'


class PairedTcheckParamDTO(BaseModel):
    data_list_1: Optional[list[PairedTcheckPerParamDTO]] = Field(title='paired-t检验:第一个指标数值集合参数')
    data_list_2: Optional[list[PairedTcheckPerParamDTO]] = Field(title='paired-t检验:第二个指标数值集合参数')

    class Config:
        title = '【' + method_view_name + '】paired-t检验:指标数值集合参数'


def execute_analysis_ttest_ind(tcheck_param_list: list[TcheckParamDTO]):
    result_list = list[ResultDTO]()
    for tcheck_param in tcheck_param_list:
        index_name = tcheck_param.index_name
        value_list_1 = tcheck_param.value_list_1
        value_list_2 = tcheck_param.value_list_2

        # t检验
        res = st.ttest_ind(value_list_1, value_list_2, equal_var=False, nan_policy='omit')

        result = ResultDTO()
        result.index_name = index_name
        result.statistic = res.statistic
        result.pvalue = res.pvalue

        avg_1 = np.average(value_list_1)
        std_1 = np.std(value_list_1, ddof=1)

        avg_2 = np.average(value_list_2)
        std_2 = np.std(value_list_2, ddof=1)
        result.avg_1 = avg_1
        result.std_1 = std_1
        result.avg_2 = avg_2
        result.std_2 = std_2

        result_list.append(result)
    return result_list


def execute_analysis_ttest_1samp(single_sample_param_list: list[SingleSampleParamDTO]):
    result_list = list[ResultDTO]()
    for single_sample_param in single_sample_param_list:
        index_name = single_sample_param.index_name
        value_list = single_sample_param.value_list
        standard_value = single_sample_param.standard_value

        # 单样本t检验
        res = st.ttest_1samp(value_list, standard_value, nan_policy='omit')

        avg_1 = np.average(value_list)
        std_1 = np.std(value_list, ddof=1)

        result = ResultDTO()
        result.index_name = index_name
        result.statistic = res.statistic
        result.pvalue = res.pvalue

        result.avg_1 = avg_1
        result.std_1 = std_1

        result_list.append(result)
    return result_list


def execute_analysis_ttest_rel(paired_tcheck_param: PairedTcheckParamDTO):
    data_list_1 = paired_tcheck_param.data_list_1
    data_list_2 = paired_tcheck_param.data_list_2

    result_list = list[ResultDTO]()
    for list_1 in data_list_1:
        for list_2 in data_list_2:
            # paired-t检验（没填就按0计算）
            value_list_2 = list_2.value_list
            value_list_1 = list_1.value_list
            res = st.ttest_rel(value_list_2, value_list_1)

            result = ResultDTO()
            result.index_name = list_1.index_name + ' @@@ ' + list_2.index_name
            result.statistic = res.statistic
            result.pvalue = res.pvalue

            avg_2 = np.average(value_list_2)
            std_2 = np.std(value_list_2, ddof=1)

            avg_1 = np.average(value_list_1)
            std_1 = np.std(value_list_1, ddof=1)

            result.avg_1 = avg_1
            result.std_1 = std_1
            result.avg_2 = avg_2
            result.std_2 = std_2

            result_list.append(result)

    return result_list


if __name__ == '__main__':
    datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
    names = list(datas.columns)

    a1 = datas['分析项1_定类'].to_list()
    a2 = datas['分析项2_定量'].to_list()

    v1 = []
    v2 = []
    for s1, s2 in zip(a1, a2):
        if s1 == 1:
            v1.append(s2)
        elif s1 == 2:
            v2.append(s2)

    print(v1)
    print(v2)

    # t检验
    res1 = st.ttest_ind(v1, v2, equal_var=False, nan_policy='omit')
    print(res1.statistic)
    print(res1.pvalue)

    # 单样本t检验
    res2 = st.ttest_1samp(a2, 100, nan_policy='omit')
    print(res2.statistic)
    print(res2.pvalue)

    # paired-t检验（没填就按0计算）
    res3 = st.ttest_rel(a2, a1)
    print(res3.statistic)
    print(res3.pvalue)
