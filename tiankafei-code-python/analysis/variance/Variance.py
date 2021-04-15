# -- coding: utf-8 -
# 方差分析算法

# scipy.stats.f_oneway

import pandas as pd
import scipy.stats as st
import numpy as np
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = 't检验分析算法'
example_index_name = '工业总产值-本期'
example_item_name = '轻工业'


class ItemParamDTO(BaseModel):
    item_name: str = Field(title='选项名称', example=example_item_name)
    value_list: list[int] = Field(title='满足选项条件的数值集合', example=[1, 2, 3, 4, 5])

    class Config:
        title = '【' + method_view_name + '】选项参数'


class IndexParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    item_list: list[ItemParamDTO] = Field(title='满足选项条件的指标数值集合')

    class Config:
        title = '【' + method_view_name + '】指标参数'


class ItemResultDTO(BaseModel):
    item_name: Optional[str] = Field(title='选项名称', example=example_item_name)
    avg: Optional[float] = Field(title='平均值')
    std: Optional[float] = Field(title='标准差')


class ResultDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    statistic: Optional[float] = Field(title='F值')
    pvalue: Optional[float] = Field(title='P值')
    item_result_list: Optional[list[ItemResultDTO]] = Field(title='每一个选项的属性对象')

    class Config:
        title = '【' + method_view_name + '】指标结果'


def execute_analysis_variance(index_param: IndexParamDTO):
    item_list = index_param.item_list

    data_list = []
    item_result_list = list[ItemResultDTO]()
    for item in item_list:
        item_name = item.item_name
        value_list = item.value_list
        data_list.append(value_list)

        avg = np.average(value_list)
        std = np.std(value_list, ddof=1)

        item_result = ItemResultDTO()
        item_result.item_name = item_name
        item_result.avg = avg
        item_result.std = std
        item_result_list.append(item_result)

    res = st.f_oneway(*data_list)

    result = ResultDTO()
    result.index_name = index_param.index_name
    result.statistic = 0.0 if res.statistic else res.statistic
    result.pvalue = 0.0 if res.pvalue else res.pvalue
    result.item_result_list = item_result_list
    return result


def execute_analysis_variance_list(index_param_list: list[IndexParamDTO]):
    result_list = list[ResultDTO]()
    for index_param in index_param_list:
        result = execute_analysis_variance(index_param)
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
