package org.tiankafei.elasticsearch.repository.impl;

import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.repository.IElasticsearchRepository;

/**
 * @author 甜咖啡
 */
@Repository
public class ElasticsearchTransportRepositoryImpl implements IElasticsearchRepository {


    /**
     * 校验 索引 是否已经存在
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    @Override
    public Boolean checkIndexNameExists(String indexName) throws Exception {


        return null;
    }

    @Override
    public Boolean createIndex(IndexParam indexParam) throws Exception {
        return null;
    }

}
