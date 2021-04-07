# 方差分析算法

# scipy.stats.f_oneway

import scipy.stats as st

a = [1, 2, 3, 4, 5, 6, 7]
b = [1, 2, 3, 4, 5, 6, 7]
c = [1, 2, 3, 4, 5, 6, 7]

res = st.f_oneway(a, b, c)

print(res.statistic)
print(res.pvalue)
