# 分类汇总分析算法

import pandas as pd
import numpy as np
import scipy.stats as st

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

print(lst)

def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), st.sem(a)
    h = se * st.t.ppf((1 + confidence) / 2., n-1)
    return m-h, m+h


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
    # variation = st.variation(data, nan_policy='omit')
    variation = np.var(data, ddof=1)
    fd = st.kurtosis(data, bias=False, nan_policy='omit')
    pd = st.skew(data, bias=False, nan_policy='omit')

    print('总数:', n, ';平均值', ave, ';求和', sum, ';中位数', cen, ';最大值', max, ';最小值', min, ';标准差', std, ';25分位数',
          v25, ';75分位数', v75, ';90分位数', v90, ';95分位数', v95, ';99分位数', v99, ';标准误', sem, ';均值95%CI(LL)',
          avg95[0], ';均值95%CI(UL)', avg95[1], ';极差', max - min, ';方差', variation, ';峰度', fd, ';偏度', pd)


