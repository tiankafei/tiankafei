# 方差分析算法

# scipy.stats.f_oneway

import pandas as pd
import scipy.stats as st
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = 't检验分析算法'
example_index_name = '工业总产值-本期'


class VariancePerParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    value_list: list[int] = Field(title='满足选项条件的数值集合')

    class Config:
        title = '【' + method_view_name + '】paired-t检验:指标数值集合参数'


class VarianceParamDTO(BaseModel):
    data_list_1: Optional[list[VariancePerParamDTO]] = Field(title='paired-t检验:第一个指标数值集合参数')
    data_list_2: Optional[list[VariancePerParamDTO]] = Field(title='paired-t检验:第二个指标数值集合参数')

    class Config:
        title = '【' + method_view_name + '】paired-t检验:指标数值集合参数'


class ResultDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    statistic: Optional[float] = Field(title='')
    pvalue: Optional[float] = Field(title='')

    class Config:
        title = '【' + method_view_name + '】指标结果'


def execute_analysis_variance(variance_param: VarianceParamDTO):
    data_list_1 = variance_param.data_list_1
    data_list_2 = variance_param.data_list_2

    result_list = list[ResultDTO]()
    for list_1 in data_list_1:
        for list_2 in data_list_2:
            res = st.f_oneway(list_1.value_list, list_2.value_list)

            result = ResultDTO()
            result.index_name = list_1.index_name + ' @@@ ' + list_2.index_name
            result.statistic = res.statistic
            result.pvalue = res.pvalue
            result_list.append(result)
    return result_list


if __name__ == '__main__':
    datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
    names = list(datas.columns)

    a1 = datas[names[0]].to_list()
    a2 = datas[names[1]].to_list()

    v1 = []
    v2 = []
    for s1, s2 in zip(a1, a2):
        if s1 == 1:
            v1.append(s2)
        elif s1 == 2:
            v2.append(s2)

    res = st.f_oneway(v1, v2)

    print(res.statistic)
    print(res.pvalue)
