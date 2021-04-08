# -- coding: utf-8 -
# 分类汇总分析算法

import pandas as pd
import numpy as np
import scipy.stats as st
from pydantic import BaseModel, Field


class ClassifyCollectionResultDTO(BaseModel):
    name: str = Field(title='名称')
    count: int = Field(title='总个数')
    avg: float = Field(title='平均值')
    sum: float = Field(title='总和')
    cen: float = Field(title='中位数')
    max: float = Field(title='最大值')
    min: float = Field(title='最小值')
    std: float = Field(title='标准差')
    v25: float = Field(title='25分位数')
    v75: float = Field(title='75分位数')
    v90: float = Field(title='90分位数')
    v95: float = Field(title='95分位数')
    v99: float = Field(title='99分位数')
    sem: float = Field(title='标准误')
    avg95ll: float = Field(title='均值95%CI(LL)')
    avg95ul: float = Field(title='均值95%CI(UL)')
    jc: float = Field(title='极差')
    fc: float = Field(title='方差')
    fd: float = Field(title='峰度')
    pd: float = Field(title='偏度')


def execute_analysis_all(request_data_list):
    result = []
    for request_data in request_data_list:
        res = execute_analysis(request_data.name, request_data.valueList)
        result.append(res)
    return result


def execute_analysis(name, data):
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

    result = ClassifyCollectionResultDTO()
    result.count = count_v
    result.avg = avg_v
    result.sum = sum_v
    result.cen = cen_v
    result.max = max_v
    result.min = min_v
    result.std = std_v
    result.v25 = v25
    result.v75 = v75
    result.v90 = v90
    result.v95 = v95
    result.v99 = v99
    result.sem = sem_v
    result.avg95ll = avg95[0]
    result.avg95ul = avg95[1]
    result.jc = max_v - min_v
    result.fc = fc_v
    result.fd = fd_v
    result.pd = pd_v
    result.name = name
    return result


def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), st.sem(a)
    h = se * st.t.ppf((1 + confidence) / 2., n - 1)
    return m - h, m + h


if __name__ == '__main__':
    datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
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

    res1 = execute_analysis('', v1)
    print(res1)
    res2 = execute_analysis('', v2)
    print(res2)

    res3 = execute_analysis_all('[{"name":"测试1","valueList":[1,2,3,4,5,6,7,8,9]}]')
    print(res3)
