# -- coding: utf-8 -
# 分类汇总分析算法

import pandas as pd
from typing import Optional
import numpy as np
import scipy.stats as st
from pydantic import BaseModel, Field

method_view_name = '分类汇总分析算法'
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
    count: Optional[int] = Field(title='总个数')
    avg: Optional[float] = Field(title='平均值')
    sum: Optional[float] = Field(title='总和')
    cen: Optional[float] = Field(title='中位数')
    max: Optional[float] = Field(title='最大值')
    min: Optional[float] = Field(title='最小值')
    std: Optional[float] = Field(title='标准差')
    v25: Optional[float] = Field(title='25分位数')
    v75: Optional[float] = Field(title='75分位数')
    v90: Optional[float] = Field(title='90分位数')
    v95: Optional[float] = Field(title='95分位数')
    v99: Optional[float] = Field(title='99分位数')
    sem: Optional[float] = Field(title='标准误')
    avg95ll: Optional[float] = Field(title='均值95%CI(LL)')
    avg95ul: Optional[float] = Field(title='均值95%CI(UL)')
    jc: Optional[float] = Field(title='极差')
    fc: Optional[float] = Field(title='方差')
    fd: Optional[float] = Field(title='峰度')
    pd: Optional[float] = Field(title='偏度')

    class Config:
        title = '【' + method_view_name + '】返回选项结果'


class IndexResultDTO(BaseModel):
    index_name: Optional[str] = Field(title='指标名称', example=example_index_name)
    item_list: Optional[list[ItemResultDTO]] = Field(title='满足选项条件的指标数据集合')

    class Config:
        title = '【' + method_view_name + '】返回指标结果'


def execute_analysis_index_list(index_param_list: list[IndexParamDTO]):
    index_result_list = list[IndexResultDTO]()
    for index_param in index_param_list:
        index_result = execute_analysis_index(index_param)
        index_result_list.append(index_result)
    return index_result_list


def execute_analysis_index(index_param: IndexParamDTO):
    index_result = IndexResultDTO()
    item_list = list[IndexResultDTO]()

    item_param_list = index_param.item_list
    for item_param in item_param_list:
        item_result = execute_analysis_item(item_param)
        item_list.append(item_result)

    index_result.index_name = index_param.index_name
    index_result.item_list = item_list
    return index_result


def execute_analysis_item(item_param: ItemParamDTO):
    data = item_param.value_list
    count_v = len(data)
    avg_v = np.average(data)
    sum_v = np.sum(data)
    cen_v = np.median(data)
    max_v = np.max(data)
    min_v = np.min(data)
    std_v = np.std(data, ddof=1)
    v25 = st.scoreatpercentile(data, 25, interpolation_method='lower')
    v75 = st.scoreatpercentile(data, 75, interpolation_method='lower')
    v90 = st.scoreatpercentile(data, 90, interpolation_method='lower')
    v95 = st.scoreatpercentile(data, 95, interpolation_method='lower')
    v99 = st.scoreatpercentile(data, 99, interpolation_method='lower')
    sem_v = st.sem(data, ddof=1, nan_policy='omit')
    avg95 = mean_confidence_interval(data, confidence=0.95)
    fc_v = np.var(data, ddof=1)
    fd_v = st.kurtosis(data, bias=False, nan_policy='omit')
    pd_v = st.skew(data, bias=False, nan_policy='omit')

    item_result = ItemResultDTO()
    item_result.count = count_v
    item_result.avg = avg_v
    item_result.sum = sum_v
    item_result.cen = cen_v
    item_result.max = max_v
    item_result.min = min_v
    item_result.std = std_v
    item_result.v25 = v25
    item_result.v75 = v75
    item_result.v90 = v90
    item_result.v95 = v95
    item_result.v99 = v99
    item_result.sem = sem_v
    item_result.avg95ll = avg95[0]
    item_result.avg95ul = avg95[1]
    item_result.jc = max_v - min_v
    item_result.fc = fc_v
    item_result.fd = fd_v
    item_result.pd = pd_v
    item_result.item_name = item_param.item_name
    return item_result


def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), st.sem(a)
    h = se * st.t.ppf((1 + confidence) / 2., n - 1)
    return m - h, m + h


if __name__ == '__main__':
    # 读取 excel 数据，引号里面是 excel 文件的位置
    datas = pd.read_excel(r'D:\python\data.xls')
    names = list(datas.columns)

    a1 = datas['分析项1_定类'].to_list()
    a2 = datas['分析项2_定量'].to_list()

    lst = []
    v1 = []
    v2 = []
    for s1, s2 in zip(a1, a2):
        if s1 == 1:
            v1.append(s2)
        elif s1 == 2:
            v2.append(s2)
    lst.append(v1)
    lst.append(v2)

    for data in lst:
        n = len(data)
        ave = np.average(data)
        sum = np.sum(data)
        cen = np.median(data)
        max = np.max(data)
        min = np.min(data)
        std = np.std(data, ddof=1)
        v25 = st.scoreatpercentile(data, 25, interpolation_method='lower')
        v75 = st.scoreatpercentile(data, 75, interpolation_method='lower')
        v90 = st.scoreatpercentile(data, 90, interpolation_method='lower')
        v95 = st.scoreatpercentile(data, 95, interpolation_method='lower')
        v99 = st.scoreatpercentile(data, 99, interpolation_method='lower')
        sem = st.sem(data, ddof=1, nan_policy='omit')
        avg95 = mean_confidence_interval(data, confidence=0.95)
        variation = np.var(data, ddof=1)
        fd = st.kurtosis(data, bias=False, nan_policy='omit')
        pd = st.skew(data, bias=False, nan_policy='omit')

        print('总数:', n, ';平均值', ave, ';求和', sum, ';中位数', cen, ';最大值', max, ';最小值', min, ';标准差', std, ';25分位数',
              v25, ';75分位数', v75, ';90分位数', v90, ';95分位数', v95, ';99分位数', v99, ';标准误', sem, ';均值95%CI(LL)',
              avg95[0], ';均值95%CI(UL)', avg95[1], ';极差', max - min, ';方差', variation, ';峰度', fd, ';偏度', pd)
