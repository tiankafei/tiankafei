# 线性回归分析算法

# scipy.stats.linregress(一元线性回归)
# sklearn.linear_model.LinearRegression（多元线性回归）
# statsmodels.（新的多元线性回归）

import pandas as pd
import statsmodels.api as sm

datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
names = list(datas.columns)
#
a = datas[names[0]].to_list()
b1 = datas[names[1]].to_list()
b2 = datas[names[2]].to_list()

da = pd.DataFrame([], index=None)
da['b1'] = b1
da['b2'] = b2
b = da

# 若模型中有截距，必须有这一步
b = sm.add_constant(b)
model = sm.OLS(a, b).fit()

s = model.summary()
print(s)
print("==============================================================================")
tables = list(s.tables)
for table in tables:
    twoDimension = table.data
    for row in twoDimension:
        print(len(row), row)
