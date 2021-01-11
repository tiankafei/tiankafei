package org.tiankafei.elasticsearch.interfaces;

import org.tiankafei.elasticsearch.param.IndexParam;

/**
 * @author 甜咖啡
 */
public interface IElasticsearch {

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


    /**
     * 删除索引
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    public Boolean deleteIndex(String indexName) throws Exception;

    /**
     * 插入数据
     * @throws Exception
     */
    public Boolean insertData(String indexName) throws Exception;

}
