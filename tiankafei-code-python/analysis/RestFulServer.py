# -- coding: utf-8 -
# 作者：甜咖啡
# 新建时间：2021/4/8 21:13
import uvicorn
from fastapi import FastAPI, Request
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse
import ClassifyCollection

app = FastAPI(title="数据分析算法接口", description="用于获取数据分析算法接口", version="0.0.1", openapi_url="/fastapi/data_manger.json",
              docs_url="/fastapi/docs", redoc_url="/fastapi/redoc")


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


if __name__ == '__main__':
    uvicorn.run(app, host="0.0.0.0", port=9000)
