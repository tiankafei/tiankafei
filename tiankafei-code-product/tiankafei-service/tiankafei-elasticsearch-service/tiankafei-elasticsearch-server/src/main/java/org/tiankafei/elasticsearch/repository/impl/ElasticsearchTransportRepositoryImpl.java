package org.tiankafei.elasticsearch.repository.impl;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;

/**
 * @author 甜咖啡
 */
@Repository
public class ElasticsearchTransportRepositoryImpl implements IElasticsearchRepository {

    @Autowired
    private TransportClient transportClient;

    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {
        IndicesExistsRequest indices = new IndicesExistsRequest().indices(indexName);
        IndicesExistsResponse indicesExistsResponse = transportClient.admin().indices().exists(indices).actionGet();
        return indicesExistsResponse.isExists();
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexParam.getIndexName());
        CreateIndexResponse createIndexResponse = transportClient.admin().indices().create(createIndexRequest).actionGet();
        return createIndexResponse.isAcknowledged();
    }

    @Override
    public Boolean deleteIndex(String indexName) throws Exception {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        AcknowledgedResponse acknowledgedResponse = transportClient.admin().indices().delete(deleteIndexRequest).actionGet();
        return acknowledgedResponse.isAcknowledged();
    }

}
