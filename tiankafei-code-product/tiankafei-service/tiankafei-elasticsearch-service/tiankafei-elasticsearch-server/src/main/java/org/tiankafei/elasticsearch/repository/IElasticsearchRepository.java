package org.tiankafei.elasticsearch.repository;

import org.tiankafei.elasticsearch.param.IndexParam;

/**
 * @author 甜咖啡
 */
public interface IElasticsearchRepository {

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
