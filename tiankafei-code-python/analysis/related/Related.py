# 相关性分析算法

# scipy.stats.spearmanr
# scipy.stats.pearsonr
# scipy.stats.kendalltau

import pandas as pd
import scipy.stats as st
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = '相关性分析算法'
example_index_name = '工业总产值-本期'


class IndexParamDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    value_list: Optional[list[int]] = Field(title='指标的数据集合',
                                            description='指标的数据集合：如果是数值类型，就是这个指标的所有值组成的数组；如果是单选或者多选，就把选项按照数值的顺序（1234）拼装成一个数组',
                                            example=[1, 2, 3, 4, 5])

    class Config:
        title = '【' + method_view_name + '】指标数组参数'


class RelatedParamDTO(BaseModel):
    one_list: Optional[list[IndexParamDTO]] = Field(title='')
    two_list: Optional[list[IndexParamDTO]] = Field(title='')

    class Config:
        title = '【' + method_view_name + '】参数'


class IndexResultDTO(BaseModel):
    one_index_name: Optional[str] = Field(title='前面的指标名称', example=example_index_name)
    two_index_name: Optional[str] = Field(title='后面的指标名称', example=example_index_name)
    correlation: Optional[float] = Field(title='相关系数')
    pvalue: Optional[float] = Field(title='p值')

    class Config:
        title = '【' + method_view_name + '】指标返回结果'


def execute_analysis_pearsonr(one: IndexParamDTO, two: IndexParamDTO):
    res = st.pearsonr(one.value_list, two.value_list)

    index_result = IndexResultDTO()
    index_result.correlation = res[0]
    index_result.pvalue = res[1]
    index_result.one_index_name = one.index_name
    index_result.two_index_name = two.index_name
    return index_result


def execute_analysis_spearmanr(one: IndexParamDTO, two: IndexParamDTO):
    res = st.spearmanr(one.value_list, two.value_list)

    index_result = IndexResultDTO()
    index_result.correlation = res.correlation
    index_result.pvalue = res.pvalue
    index_result.one_index_name = one.index_name
    index_result.two_index_name = two.index_name
    return index_result


def execute_analysis_kendalltau(one: IndexParamDTO, two: IndexParamDTO):
    res = st.kendalltau(one.value_list, two.value_list, method='asymptotic', nan_policy='omit')

    index_result = IndexResultDTO()
    index_result.correlation = res.correlation
    index_result.pvalue = res.pvalue
    index_result.one_index_name = one.index_name
    index_result.two_index_name = two.index_name
    return index_result


if __name__ == '__main__':
    datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
    names = list(datas.columns)

    a1 = datas[names[0]].to_list()
    a2 = datas[names[1]].to_list()

    one = IndexParamDTO(index_name='测试1', value_list=a1)
    two = IndexParamDTO(index_name='测试2', value_list=a2)

    print(execute_analysis_pearsonr(one, two))
    print(execute_analysis_spearmanr(one, two))
    print(execute_analysis_kendalltau(one, two))
