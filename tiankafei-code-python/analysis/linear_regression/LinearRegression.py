# 线性回归分析算法

# scipy.stats.linregress(一元线性回归)
# sklearn.linear_model.LinearRegression（多元线性回归）
# statsmodels.（新的多元线性回归）

import pandas as pd
import statsmodels.api as sm
from typing import Optional
from pydantic import BaseModel, Field

method_view_name = '线性回归分析算法'
example_index_name = '工业总产值-本期'


class IndexParamDTO(BaseModel):
    index_name: str = Field(title='指标名称', example=example_index_name)
    value_list: list[int] = Field(title='指标的数据集合',
                                  description='指标的数据集合：如果是数值类型，就是这个指标的所有值组成的数组；如果是单选或者多选，就把选项按照数值的顺序（1234）拼装成一个数组',
                                  example=[1, 2, 3, 4, 5])

    class Config:
        title = '【' + method_view_name + '】指标数组参数'


class LinearParamDTO(BaseModel):
    cause_index_data: IndexParamDTO = Field(title='因变量的指标数据')
    other_index_data: list[IndexParamDTO] = Field(title='指标的数据集合')

    class Config:
        title = '【' + method_view_name + '】整体参数'


class IndexResultDTO(BaseModel):
    name: Optional[str] = Field(title='指标名称')
    b: Optional[float] = Field(title='线性回归分析:非标准化系数:B的值')
    sem: Optional[float] = Field(title='线性回归分析:非标准化系数:标准误')
    t: Optional[float] = Field(title='线性回归分析:t的值')
    p: Optional[float] = Field(title='线性回归分析:p的值')

    class Config:
        title = '【' + method_view_name + '】指标的结果'


class LinearResultDTO(BaseModel):
    const: Optional[IndexResultDTO] = Field(title='常数值')
    index_list: Optional[list[IndexResultDTO]] = Field(title='指标的值')
    r: Optional[float] = Field(title='线性回归分析:r的值')
    tzr: Optional[float] = Field(title='线性回归分析:调整r的值')
    ff: Optional[float] = Field(title='线性回归分析:ff的值')
    fp: Optional[float] = Field(title='线性回归分析:fp的值')


def execute_analysis(linear_param: LinearParamDTO):
    cause_index_data = linear_param.cause_index_data
    cause = cause_index_data.value_list

    other = pd.DataFrame([], index=None)
    other_index_data = linear_param.other_index_data
    for index_data in other_index_data:
        value_list = index_data.value_list
        other[index_data.index_name] = value_list

    return execute_analysis_(cause, other)


def execute_analysis_(cause, other):
    # 若模型中有截距，必须有这一步
    other = sm.add_constant(other)
    model = sm.OLS(cause, other).fit()

    s = model.summary()

    result = LinearResultDTO()
    const = IndexResultDTO()
    index_list = list[IndexResultDTO]()

    tables = list(s.tables)
    table_index = 0
    for table in tables:
        array = table.data
        row_index = 0
        for row in array:
            if table_index == 0 and row_index == 0:
                result.r = float(row[3].strip())
            elif table_index == 0 and row_index == 1:
                result.tzr = float(row[3].strip())
            elif table_index == 0 and row_index == 2:
                result.ff = float(row[3].strip())
            elif table_index == 0 and row_index == 3:
                result.fp = float(row[3].strip())

            if table_index == 1 and row_index == 1:
                const.name = '常数'
                const.b = float(row[1].strip())
                const.sem = float(row[2].strip())
                const.t = float(row[3].strip())
                const.p = float(row[4].strip())
                result.const = const
            elif table_index == 1 and row_index > 1:
                index = IndexResultDTO()
                index.name = row[0].strip()
                index.b = float(row[1].strip())
                index.sem = float(row[2].strip())
                index.t = float(row[3].strip())
                index.p = float(row[4].strip())
                index_list.append(index)
            row_index += 1
        table_index += 1

        result.index_list = index_list
    return result


if __name__ == '__main__':
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

    print(execute_analysis_(a, b))
