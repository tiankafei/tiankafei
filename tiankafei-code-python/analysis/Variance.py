# 方差分析算法

# scipy.stats.f_oneway

import pandas as pd
import scipy.stats as st

# 1.先联调方法
# 2.包装，接收外部参数，返回结果

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
