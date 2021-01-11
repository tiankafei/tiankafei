package org.tiankafei.elasticsearch.repository;

import org.tiankafei.elasticsearch.interfaces.IElasticsearch;

/**
 * @author 甜咖啡
 */
public interface IElasticsearchRepository extends IElasticsearch {

    /**
     * 插入数据
     * @throws Exception
     */
    @Override
    default Boolean insertData(String indexName) throws Exception {
        return Boolean.TRUE;
    }
}
