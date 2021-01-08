package org.tiankafei.elasticsearch.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 甜咖啡
 */
@Repository
public class ElasticsearchRestHighLevelRepositoryImpl implements IElasticsearchRepository {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {
        IndexCoordinates of = IndexCoordinates.of(indexName);
        return elasticsearchRestTemplate.indexOps(of).exists();
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("index.number_of_shards", 2);
        map.put("index.number_of_replicas", 1);
        Document document = Document.from(map);
        return elasticsearchRestTemplate.indexOps(IndexCoordinates.of(indexParam.getIndexName())).create(document);
    }

    @Override
    public Boolean deleteIndex(String indexName) throws Exception {
        IndexCoordinates of = IndexCoordinates.of(indexName);
        return elasticsearchRestTemplate.indexOps(of).delete();
    }

}
