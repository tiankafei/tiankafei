# 分类汇总分析算法

import pandas as pd
import numpy as np
import scipy.stats as st
import json


def execute_analysis_all(string):
    json_list = json.loads(string)
    result = []
    for data in json_list:
        name = data['name']
        value_list = data['valueList']

        res = execute_analysis(name, value_list)
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

    res = dict()
    res['count'] = count_v
    res['avg'] = avg_v
    res['sum'] = sum_v
    res['cen'] = cen_v
    res['max'] = max_v
    res['min'] = min_v
    res['std'] = std_v
    res['v25'] = v25
    res['v75'] = v75
    res['v90'] = v90
    res['v95'] = v95
    res['v99'] = v99
    res['sem'] = sem_v
    res['avg95ll'] = avg95[0]
    res['avg95ul'] = avg95[1]
    res['jc'] = max_v - min_v
    res['fc'] = fc_v
    res['fd'] = fd_v
    res['pd'] = pd_v
    res['name'] = name
    return res


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



