# 正态性校验分析算法

# scipy.stats.kstest（K-S检验）
# scipy.stats.shapiro（S-W检验）

import pandas as pd
import scipy.stats as st

datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
names = list(datas.columns)

a2 = datas[names[1]].to_list()

# K-S检验 TODO 数据不对
res1 = st.kstest(a2, a2)
print(res1.statistic)
print(res1.pvalue)


# S-W检验
res2 = st.shapiro(a2)
print(res2.statistic)
print(res2.pvalue)
