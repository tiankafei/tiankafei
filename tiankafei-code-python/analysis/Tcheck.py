# t校验分析算法

# scipy.stats.ttest_ind（t检验）
# scipy.stats.ttest_1samp（单样本t检验）
# scipy.stats.ttest_rel（paired-t检验）

import pandas as pd
import scipy.stats as st

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

# 没填就按0计算
res3 = st.ttest_rel(a2, a1)
print(res3.statistic)
print(res3.pvalue)
