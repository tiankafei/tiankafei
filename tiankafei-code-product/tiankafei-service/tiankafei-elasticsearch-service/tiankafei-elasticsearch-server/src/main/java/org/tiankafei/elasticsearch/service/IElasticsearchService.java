package org.tiankafei.elasticsearch.service;

import org.tiankafei.elasticsearch.param.IndexParam;

/**
 * @author 甜咖啡
 */
public interface IElasticsearchService {

    /**
     * 校验 索引 是否已经存在
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    public Boolean checkIndexNameExists(String indexName) throws Exception;

    /**
     * 创建索引
     *
     * @param indexParam
     * @return
     * @throws Exception
     */
    public Boolean createIndex(IndexParam indexParam) throws Exception;

}
