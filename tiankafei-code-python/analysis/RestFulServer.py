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
import normal_check.NormalCheck as NormalCheck
import sys
import nacos
import threading
import time
import configparser
import os


# naocs心跳保持
def send_heartbeat(nacos_client, ip, port, interval):
    while True:
        nacos_client.send_heartbeat(service_name='analysis-algorithm', ip=ip, port=port,
                                    cluster_name='DEFAULT')
        time.sleep(interval)


# 注册nacos
def register_nacos(ip, port, interval, server_addresses, namespace):
    client = nacos.NacosClient(server_addresses=server_addresses, namespace=namespace)
    client.add_naming_instance(service_name='analysis-algorithm', ip=ip, port=port,
                               cluster_name='DEFAULT')
    t1 = threading.Thread(target=send_heartbeat, args=(client, ip, port, interval))
    t1.start()


'''
如果参数个数大于1，第一个参数任意一个字符或数字，非0即为开启文档，0则关闭文档
'''
enabled = 1


def check_config(config_path):
    config = configparser.ConfigParser()
    config.read(config_path, 'UTF-8')

    ip = ''
    port = 25535
    doc_enable = False
    namespace = ''
    server_addresses = ''
    interval = 10

    # ip配置是否存在
    ip_flag = config.has_option('config', 'ip')
    if ip_flag:
        ip = config.get("config", "ip")
    else:
        print('ip配置不能为空')
        return False
    # 端口配置是否存在
    port_flag = config.has_option('config', 'port')
    if port_flag:
        try:
            port = int(config.get("config", "port"))
        except:
            print('端口必须是数值')
            return False

    # doc文档配置是否存在
    doc_enable_flag = config.has_option('config', 'doc_enable')
    if doc_enable_flag:
        global enabled
        enabled = int(config.get("config", "doc_enable"))

    # nacos注册中心地址是否存在
    server_addresses_flag = config.has_option('config', 'server_addresses')
    if server_addresses_flag:
        server_addresses = config.get("config", "server_addresses")
    else:
        print('nacos注册地址不能为空')
        return False

    # nacos命名空间配置是否存在
    namespace_flag = config.has_option('config', 'namespace')
    if namespace_flag:
        namespace = config.get("config", "namespace")

    # nacos心跳间隔配置是否存在
    interval_flag = config.has_option('config', 'interval')
    if interval_flag:
        try:
            interval = int(config.get("config", "interval"))
            if interval > 10:
                interval = 10
        except:
            print('nacos心跳间隔，必须是数值')
            return False

    register_nacos(ip, port, interval, server_addresses, namespace)
    return True


if len(sys.argv) > 1:
    config_path = sys.argv[1]
    exists = os.path.exists(os.path.join(os.getcwd(), config_path))
    # 如果传入的参数是配置文件，则通过读取配置，拿到必要的属性
    if exists:
        # 读取配置并进行校验
        flag = check_config(config_path)
        if flag:
            pass
        else:
            sys.exit()
    else:
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


@app.post(path='/related_pearsonr', response_model=list[Related.IndexResultDTO],
          summary='相关性分析算法【pearsonr】', description='相关性分析算法', tags={'分析算法'})
async def related_pearsonr(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result_list = list[Related.IndexResultDTO]()
    for one in one_list:
        for two in two_list:
            result = Related.execute_analysis_pearsonr(one, two)
            result_list.append(result)
    return result_list


@app.post(path='/related_spearmanr', response_model=list[Related.IndexResultDTO],
          summary='相关性分析算法【spearmanr】', description='相关性分析算法', tags={'分析算法'})
async def related_spearmanr(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result = list[Related.IndexResultDTO]()
    for one in one_list:
        for two in two_list:
            index_result = Related.execute_analysis_spearmanr(one, two)
            result.append(index_result)
    return result


@app.post(path='/related_kendalltau', response_model=list[Related.IndexResultDTO],
          summary='相关性分析算法【kendalltau】', description='相关性分析算法', tags={'分析算法'})
async def related_kendalltau(related_param: Related.RelatedParamDTO):
    one_list = related_param.one_list
    two_list = related_param.two_list

    result = list[Related.IndexResultDTO]()
    for one in one_list:
        for two in two_list:
            index_result = Related.execute_analysis_kendalltau(one, two)
            result.append(index_result)
    return result


@app.post(path='/tcheck_ttest_ind', response_model=Tcheck.ResultDTO,
          summary='t校验分析算法【t检验单个】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_ind(tcheck_param: Tcheck.TcheckParamDTO):
    result = Tcheck.execute_analysis_ttest_ind(tcheck_param)
    return result


@app.post(path='/tcheck_ttest_ind_list', response_model=list[Tcheck.ResultDTO],
          summary='t校验分析算法【t检验批量】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_ind_list(tcheck_param_list: list[Tcheck.TcheckParamDTO]):
    result_list = Tcheck.execute_analysis_ttest_ind_list(tcheck_param_list)
    return result_list


@app.post(path='/tcheck_ttest_1samp', response_model=Tcheck.ResultDTO,
          summary='t校验分析算法【单样本t检验单个】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_1samp(single_sample_param: Tcheck.SingleSampleParamDTO):
    result = Tcheck.execute_analysis_ttest_1samp(single_sample_param)
    return result


@app.post(path='/tcheck_ttest_1samp_list', response_model=list[Tcheck.ResultDTO],
          summary='t校验分析算法【单样本t检验批量】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_1samp_list(single_sample_param_list: list[Tcheck.SingleSampleParamDTO]):
    result_list = Tcheck.execute_analysis_ttest_1samp_list(single_sample_param_list)
    return result_list


@app.post(path='/tcheck_ttest_rel', response_model=list[Tcheck.ResultDTO],
          summary='t校验分析算法【paired-t检验】', description='t校验分析算法', tags={'分析算法'})
async def tcheck_ttest_rel(paired_tcheck_param: Tcheck.PairedTcheckParamDTO):
    result_list = Tcheck.execute_analysis_ttest_rel(paired_tcheck_param)
    return result_list


@app.post(path='/variance', response_model=Variance.ResultDTO,
          summary='方差分析算法【单个】', description='方差分析算法', tags={'分析算法'})
async def variance(index_param: Variance.IndexParamDTO):
    result_list = Variance.execute_analysis_variance(index_param)
    return result_list


@app.post(path='/variance_list', response_model=list[Variance.ResultDTO],
          summary='方差分析算法【批量】', description='方差分析算法', tags={'分析算法'})
async def variance(index_param_list: list[Variance.IndexParamDTO]):
    result_list = Variance.execute_analysis_variance_list(index_param_list)
    return result_list


@app.post(path='/normal_check', response_model=NormalCheck.ResultDTO,
          summary='正态性校验分析算法【单个】', description='正态性校验分析算法', tags={'分析算法'})
async def normal_check(index_param: NormalCheck.IndexParamDTO):
    result = NormalCheck.execute_analysis_normal_check(index_param)
    return result


@app.post(path='/normal_check_list', response_model=list[NormalCheck.ResultDTO],
          summary='正态性校验分析算法【批量】', description='正态性校验分析算法', tags={'分析算法'})
async def normal_check_list(index_param_list: list[NormalCheck.IndexParamDTO]):
    result_list = NormalCheck.execute_analysis_normal_check_list(index_param_list)
    return result_list


if __name__ == '__main__':
    uvicorn.run(app, host="0.0.0.0", port=25535)
