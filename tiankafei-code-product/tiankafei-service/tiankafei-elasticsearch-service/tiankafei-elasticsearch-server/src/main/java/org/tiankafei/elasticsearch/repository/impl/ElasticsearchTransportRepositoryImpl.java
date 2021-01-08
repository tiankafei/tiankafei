package org.tiankafei.elasticsearch.repository.impl;

import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;

/**
 * @author 甜咖啡
 */
@Repository
public class ElasticsearchTransportRepositoryImpl implements IElasticsearchRepository {

    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {
        return null;
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteIndex(String indexName) throws Exception {
        return null;
    }

}
