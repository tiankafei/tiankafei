# 作者：甜咖啡
# 新建时间：2021/4/8 21:13
import uvicorn
from fastapi import FastAPI, Request
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse
from pydantic import BaseModel
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


class ClassifyCollectionParamDTO(BaseModel):
    name: str = None
    valueList: list[int] = None


@app.post(path='/classifyCollection', summary='分类汇总分析算法', description='分类汇总分析算法', tags={'分析算法'})
async def read_item(request_data_list: list[ClassifyCollectionParamDTO]):
    lst = ClassifyCollection.execute_analysis_all(request_data_list)
    return {'res': str(lst)}


if __name__ == '__main__':
    uvicorn.run(app, host="0.0.0.0", port=9000)
