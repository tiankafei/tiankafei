# 正态性校验分析算法

# scipy.stats.kstest（K-S检验）
# scipy.stats.shapiro（S-W检验）

import pandas as pd
import scipy.stats as st
import numpy as np
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = 't检验分析算法'
example_index_name = '工业总产值-本期'
example_item_name = '轻工业'


class IndexParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    value_list: list[int] = Field(title='指标的数据集合',
                                  description='指标的数据集合：如果是数值类型，就是这个指标的所有值组成的数组；如果是单选或者多选，就把选项按照数值的顺序（1234）拼装成一个数组',
                                  example=[1, 2, 3, 4, 5])

    class Config:
        title = '【' + method_view_name + '】指标数组参数'


class ResultDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    ks_statistic: Optional[float] = Field(title='ks的F值')
    ks_pvalue: Optional[float] = Field(title='ks的P值')
    sw_statistic: Optional[float] = Field(title='sw的F值')
    sw_pvalue: Optional[float] = Field(title='sw的P值')
    count: Optional[float] = Field(title='样本量')
    avg: Optional[float] = Field(title='平均值')
    std: Optional[float] = Field(title='标准差')
    fd: Optional[float] = Field(title='峰度')
    pd: Optional[float] = Field(title='偏度')

    class Config:
        title = '【' + method_view_name + '】指标结果'


def execute_analysis_normal_check(index_param: IndexParamDTO):
    index_name = index_param.index_name
    value_list = index_param.value_list

    # K-S检验 TODO 数据不对
    # res1 = st.kstest(a2, 'norm')
    ks_res = st.ks_1samp(value_list, st.norm.cdf, mode='asymp')

    result = ResultDTO()
    result.ks_statistic = ks_res.statistic
    result.ks_pvalue = ks_res.pvalue

    # S-W检验
    sw_res = st.shapiro(value_list)
    result.sw_statistic = sw_res.statistic
    result.sw_pvalue = sw_res.pvalue

    avg = np.average(value_list)
    std = np.std(value_list, ddof=1)
    fd_v = st.kurtosis(value_list, bias=False, nan_policy='omit')
    pd_v = st.skew(value_list, bias=False, nan_policy='omit')

    result.avg = avg
    result.std = std
    result.pd = pd_v
    result.fd = fd_v
    result.count = len(value_list)
    result.index_name = index_name
    return result


def execute_analysis_normal_check_list(index_param_list: list[IndexParamDTO]):
    result_list = list[ResultDTO]()
    for index_param in index_param_list:
        result = execute_analysis_normal_check(index_param)
        result_list.append(result)
    return result_list


if __name__ == '__main__':
    datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
    names = list(datas.columns)

    a2 = datas[names[1]].to_list()

    # K-S检验 TODO 数据不对
    # res1 = st.kstest(a2, 'norm')
    res1 = st.ks_1samp(a2, st.norm.cdf, mode='asymp')
    print(res1.statistic)
    print(res1.pvalue)

    # S-W检验
    res2 = st.shapiro(a2)
    print(res2.statistic)
    print(res2.pvalue)
