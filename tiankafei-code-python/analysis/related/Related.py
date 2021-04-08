# 相关性分析算法

# scipy.stats.spearmanr
# scipy.stats.pearsonr
# scipy.stats.kendalltau

import pandas as pd
import scipy.stats as st

datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
names = list(datas.columns)

a1 = datas[names[0]].to_list()
a2 = datas[names[1]].to_list()

res1 = st.spearmanr(a1, a2)
r11 = round(res1.correlation, 3)
r12 = round(res1.pvalue, 3)
print(r11)
print(r12)

res2 = st.pearsonr(a1, a2)
r21 = round(res2[0], 3)
r22 = round(res2[1], 3)
print(r21)
print(r22)

res3 = st.kendalltau(a1, a2, method='asymptotic', nan_policy='omit')
r31 = round(res3.correlation, 3)
r32 = round(res3.pvalue, 3)
print(r31)
print(r32)
