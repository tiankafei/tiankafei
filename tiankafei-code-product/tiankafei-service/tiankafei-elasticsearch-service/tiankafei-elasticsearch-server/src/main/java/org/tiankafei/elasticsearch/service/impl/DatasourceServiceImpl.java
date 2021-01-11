package org.tiankafei.elasticsearch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.elasticsearch.entity.DatasourceEntity;
import org.tiankafei.elasticsearch.mapper.DatasourceMapper;
import org.tiankafei.elasticsearch.service.IDatasourceService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * @author 甜咖啡
 */
@Service
public class DatasourceServiceImpl extends BaseServiceImpl<DatasourceMapper, DatasourceEntity> implements IDatasourceService {

    @Autowired
    private DatasourceMapper datasourceMapper;

    @Override
    public List<DatasourceEntity> getData() {
        return datasourceMapper.getData();
    }
}
