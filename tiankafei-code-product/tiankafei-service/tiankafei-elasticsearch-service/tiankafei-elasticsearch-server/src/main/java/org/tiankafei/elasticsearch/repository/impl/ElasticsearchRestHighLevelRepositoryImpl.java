package org.tiankafei.elasticsearch.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;

/**
 * @author 甜咖啡
 */
@Repository
public class ElasticsearchRestHighLevelRepositoryImpl implements IElasticsearchRepository {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 校验 索引 是否已经存在
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {
        return true;
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        return elasticsearchRestTemplate.createIndex(indexParam.getIndexName());
    }

}
