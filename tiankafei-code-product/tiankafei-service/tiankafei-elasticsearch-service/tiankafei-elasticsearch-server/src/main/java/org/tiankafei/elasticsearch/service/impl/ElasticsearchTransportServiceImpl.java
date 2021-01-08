package org.tiankafei.elasticsearch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;
import org.tiankafei.elasticsearch.service.IElasticsearchService;

/**
 * @author 甜咖啡
 */
@Service
public class ElasticsearchTransportServiceImpl implements IElasticsearchService {

    @Autowired
    private IElasticsearchRepository elasticsearchTransportRepositoryImpl;

    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {
        return elasticsearchTransportRepositoryImpl.checkIndexNameExists(indexName);
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        return elasticsearchTransportRepositoryImpl.createIndex(indexParam);
    }

    @Override
    public Boolean deleteIndex(String indexName) throws Exception {
        return elasticsearchTransportRepositoryImpl.deleteIndex(indexName);
    }
}
