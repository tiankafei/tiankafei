# -- coding: utf-8 -
# 作者：甜咖啡
# 新建时间：2021/4/8 21:13
import uvicorn
from fastapi import FastAPI, Request
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse
import classify_collection.ClassifyCollection as ClassifyCollection
import linear_regression.LinearRegression as LinearRegression
import related.Related as Related
import tcheck.Tcheck as Tcheck
import variance.Variance as Variance
import sys

'''
如果参数个数大于1，第一个参数任意一个字符或数字，非0即为开启文档，0则关闭文档
'''
enabled = 1
if len(sys.argv) > 1:
    try:
        enabled = int(sys.argv[1])
    except ValueError:
        pass

app = FastAPI(title="数据分析算法接口", description="用于获取数据分析算法接口", version="0.0.1", openapi_url="/fastapi/data_manger.json",
              docs_url="/fastapi/docs" if enabled == 1 else None, redoc_url="/fastapi/redoc")


@app.get(path='/', summary='根路径', tags={'默认'})
async def home():
    return {"message": "Hello World"}


@app.exception_handler(RequestValidationError)
async def request_validation_exception_handler(request: Request, exc: RequestValidationError):
    print(f"参数不对{request.method} {request.url}")
    return JSONResponse({"code": "400", "message": exc.errors()})


@app.post(path='/classify_collection_index_list', response_model=list[ClassifyCollection.IndexResultDTO],
          summary='分类汇总分析算法【按照指标集合计算】', description='分类汇总分析算法', tags={'分析算法'})
async def classify_collection_index_list(index_param_list: list[ClassifyCollection.IndexParamDTO]):
    index_result_list = ClassifyCollection.execute_analysis_index_list(index_param_list)
    return index_result_list


@app.post(path='/classify_collection_index', response_model=ClassifyCollection.IndexResultDTO,
          summary='分类汇总分析算法【按照指标计算】', description='分类汇总分析算法', tags={'分析算法'})
async def classify_collection_index(index_param: ClassifyCollection.IndexParamDTO):
    index_result = ClassifyCollection.execute_analysis_index(index_param)
    return index_result


@app.post(path='/classify_collection_item', response_model=ClassifyCollection.ItemResultDTO,
          summary='分类汇总分析算法【按照选项计算】', description='分类汇总分析算法', tags={'分析算法'})
async def classify_collection_item(item_param: ClassifyCollection.ItemParamDTO):
    item_result = ClassifyCollection.execute_analysis_item(item_param)
    return item_result


@app.post(path='/linear_regression', response_model=LinearRegression.LinearResultDTO,
          summary='线性回归分析算法', description='线性回归分析算法', tags={'分析算法'})
async def linear_regression(linear_param: LinearRegression.LinearParamDTO):
    linear_result = LinearRegression.execute_analysis(linear_param)
    return linear_result


@app.post(path='/related_pearsonr', response_model=list[Related.RelatedResultDTO](),
          summary='相关性分析算法【pearsonr】', description='相关性分析算法', tags={'分析算法'})
async def related_pearsonr(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result = list[Related.RelatedResultDTO]()
    for one in one_list:
        for two in two_list:
            index_result = Related.execute_analysis_pearsonr(one, two)
            result.append(index_result)
    return result


@app.post(path='/related_spearmanr', response_model=list[Related.RelatedResultDTO](),
          summary='相关性分析算法【spearmanr】', description='相关性分析算法', tags={'分析算法'})
async def related_spearmanr(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result = list[Related.RelatedResultDTO]()
    for one in one_list:
        for two in two_list:
            index_result = Related.execute_analysis_spearmanr(one, two)
            result.append(index_result)
    return result


@app.post(path='/related_kendalltau', response_model=list[Related.RelatedResultDTO](),
          summary='相关性分析算法【kendalltau】', description='相关性分析算法', tags={'分析算法'})
async def related_kendalltau(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result = list[Related.RelatedResultDTO]()
    for one in one_list:
        for two in two_list:
            index_result = Related.execute_analysis_kendalltau(one, two)
            result.append(index_result)
    return result


@app.post(path='/tcheck_ttest_ind', response_model=list[Tcheck.ResultDTO](),
          summary='t校验分析算法【t检验】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_ind(tcheck_param: list[Tcheck.TcheckParamDTO]):
    result_list = Tcheck.execute_analysis_ttest_ind(tcheck_param)
    return result_list


@app.post(path='/tcheck_ttest_1samp', response_model=list[Tcheck.ResultDTO](),
          summary='t校验分析算法【单样本t检验】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_1samp(single_sample_param_list: list[Tcheck.SingleSampleParamDTO]):
    result_list = Tcheck.execute_analysis_ttest_1samp(single_sample_param_list)
    return result_list


@app.post(path='/tcheck_ttest_rel', response_model=list[Tcheck.ResultDTO](),
          summary='t校验分析算法【paired-t检验】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_rel(paired_tcheck_param: Tcheck.PairedTcheckParamDTO):
    result_list = Tcheck.execute_analysis_ttest_rel(paired_tcheck_param)
    return result_list


@app.post(path='/variance', response_model=list[Variance.ResultDTO](),
          summary='方差分析算法', description='方差分析算法', tags={'分析算法'})
async def variance(variance_param: Variance.VarianceParamDTO):
    result_list = Variance.execute_analysis_variance(variance_param)
    return result_list


if __name__ == '__main__':
    uvicorn.run(app, host="0.0.0.0", port=25535)
