#!/usr/bin/python
# -*- coding: utf-8 -*-
from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler
from socketserver import ThreadingMixIn
import sys

# 定义服务的ip和端口
serverIp = "0.0.0.0"  # 自动获取不是机器的ip地址
serverPart = 23666

# <1>文档相似模块
sys.path.append("pythonInvoke")

from docAlike import docAlike_predict
from docAlike import docAlike_tfidf_trian
from getTarget import getTarget_indicator
from word2vector import predict as word2vector_predict
from word2vector import word2vect_train
from textclassification import predict as textclassification_predict
# from textclassification import run_cnn as textclassification_train
# from KG_textclassification import predict as textclassification_predict
from TopicModel import TopicModel_predict
from TopicModel import TopicModel_train
from tables_structured import tables_structured
from getAreaOrTime import getregion
from getAreaOrTime import getTime
from getAreaOrTime import getName
# from hanlp_process import extraction
from synonym_recognition import same_entity
from entropy_method import entropy_method
from exceltable_alg import exceltable_parse
from ABsimilarity import top_k
from pagerank import pr
# from extraction_relation import eval
from DeepLearning_NER import train
from DeepLearning_NER import predict
from update_dict import update_dict
from gisDealError import _tools as gisTool
from gisDealError import _get_trip_stop as getTripStop
from space_cluster import space_cluster_alg as spaceClusterAlg
from named_entity_recognition import entity_recognition as entityRecognition
from featureimport import featureimport as featureimport
# from data_feature_import_final_1017_1 import run as featurefun
from related_cases_fre import tourRuleConfig as tourruleconfig
from data_feature_label import compute_cof as computecof


# #<2>从文本中获取到指标目标值模块
# from  import getTarget_indicator
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2')


class ThreadXMLRPCServer(ThreadingMixIn, SimpleXMLRPCServer):
    pass


# 所有算法服务启动类，从这里开始，也就是我们的服务发布启动类了。
if __name__ == "__main__":
    # 【*】启动一个服务监听
    server = ThreadXMLRPCServer(
        (serverIp, serverPart)
        , requestHandler=RequestHandler
        # ,requestHandler, logRequests,allow_none,encoding,bind_and_activate,use_builtin_types    #其他配置项
        , logRequests=True
        , allow_none=True
    )
    # #注册单个服务
    # #<1>文档相似模块
    # server.register_function(docAlike_tfidf_trian.trainmodel, "docAlike_trainmodel");   #训练
    # server.register_function(docAlike_predict.predict, "docAlike_predict");           #获取
    #
    # #<2>从文本中获取到指标目标值模块
    # server.register_function(getTarget_indicator.getTarget, "getTarget_indicator");

    # 应用整个模块
    # cnn_model =    predict.CnnModel()
    # server.register_instance(cnn_model);
    # def getopt(a):
    #     return a

    # 文本相似度预测
    server.register_function(docAlike_predict.predict, "docAlike_predict")
    # 文本相似度训练
    server.register_function(docAlike_tfidf_trian.trainmodel, "docAlike_trainmodel")

    # 目标寻找
    server.register_function(getTarget_indicator.getTarget, "getTarget_indicator")

    # 词向量训练
    server.register_function(word2vect_train.word2vect_train, "word2vect_train")
    # 词向量预测
    server.register_function(word2vector_predict.predict, "word2vect_predict")

    # 文本分类训练
    server.register_function(textclassification_predict.predict, "textclassification_predict")
    # 文本分类预测
    # server.register_function(textclassification_train.train,"textclassification_train")

    # 主题模型训练
    server.register_function(TopicModel_predict.ladpredict, "topicModel_predict")
    # 主题模型预测
    server.register_function(TopicModel_train.trainLDAmodel, "topicModel_train")

    # html表格数据结构化
    server.register_function(tables_structured.structured_htmltable, "structured_htmltable")

    # 获取地区数据
    server.register_function(getregion.get_region, "getregion")
    # 获取时间数据
    server.register_function(getTime.get_time, "gettime")
    # 获取人名
    server.register_function(getName.get_name, "getname")
    # 解析自然语言
    # server.register_function(extraction.final_dict,"finaldict")
    # 同义词识别
    server.register_function(same_entity.get_same_entity, "sysnonymRecog")
    # 商权法计算权重
    server.register_function(entropy_method.get_final_weight, "getFinalWeight")
    # excel复杂解析
    server.register_function(exceltable_parse.get_and_remove, "getAndRemove")
    # 商品货物风险值计算
    server.register_function(top_k.DataSimilarity().data_similarity, "dataSimilarity")
    # 风险评分计算
    server.register_function(pr.pagerank, "pagerank")
    # 机器学习
    # server.register_function(eval.eval,"macEvalStudy")
    # 人工学习模型
    server.register_function(train.ner_trian, "nerTrian")
    server.register_function(predict.nercode_predict, "nercodePredict")
    # 更新字典方法
    server.register_function(update_dict.dict_add, "dictAdd")
    # gis地图相关方法
    # 计算给定经纬度的距离
    server.register_function(gisTool.haversine, "haversine")
    # 计算轨迹中的短点
    server.register_function(getTripStop.get_breakpoint, "getBreakpoint")
    # 计算轨迹中的停留点以及停留时长
    server.register_function(getTripStop.get_stop_point, "getStopPoint")
    # 空间聚类算法
    server.register_function(spaceClusterAlg.get_cluster_result, "getClusterResult")
    # 命名实体识别
    server.register_function(entityRecognition.get_name_entity, "getNameEntity")
    # 特征值重要性
    server.register_function(featureimport.featurerank, "featurerank")
    # 特征值重要性1
    # server.register_function(featurefun.run,"featurefun")
    # 旅检规则配置
    server.register_function(tourruleconfig.get_attr_fre, "getAttrFre")
    # 特征值标签计算
    server.register_function(computecof.judge_and_com, "judgeAndCom")

    # 【*】启动长连接监听
    server.serve_forever()

