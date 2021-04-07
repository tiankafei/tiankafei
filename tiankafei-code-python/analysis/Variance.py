# 方差分析算法

# scipy.stats.f_oneway
# TODO

import pandas as pd
import scipy.stats as st

# 1.先联调方法
# 2.包装，接收外部参数，返回结果

datas = pd.read_excel(r'D:\python\data.xls') # 读取 excel 数据，引号里面是 excel 文件的位置
names = list(datas.columns)

lst = []
for clumnName in names:
    a = datas[clumnName].to_list()
    lst.append(a)
print(lst)

res = st.f_oneway(*lst)

print(res.statistic)
print(res.pvalue)
