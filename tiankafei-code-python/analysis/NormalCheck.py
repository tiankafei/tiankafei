# 正态性校验分析算法

# scipy.stats.kstest（K-S检验）
# scipy.stats.shapiro（S-W检验）

import pandas as pd
import scipy.stats as st

datas = pd.read_excel(r'D:\python\data.xls')  # 读取 excel 数据，引号里面是 excel 文件的位置
names = list(datas.columns)

a1 = datas['分析项1_定类'].to_list()
a2 = datas['分析项2_定量'].to_list()


st.kstest()


st.shapiro()