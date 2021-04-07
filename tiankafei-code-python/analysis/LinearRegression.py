# 线性回归分析算法

# scipy.stats.linregress(一元线性回归)
# sklearn.linear_model.LinearRegression（多元线性回归）
# statsmodels.（新的多元线性回归）

# TODO 有待测试拿结果

import pandas as pd
import statsmodels.formula.api as sm

datas = pd.read_excel(r'D:\python\linear_regression.xlsx') # 读取 excel 数据，引号里面是 excel 文件的位置

model = sm.ols('测试数据1~测试数据2', datas).fit() # 构建最小二乘模型并拟合，
                               #此时不用单独输入 x，y了，而是将自变量与因变量用统计语言公式表示，将全部数据导入

s = model.summary()

print(s) # 输出回归结果