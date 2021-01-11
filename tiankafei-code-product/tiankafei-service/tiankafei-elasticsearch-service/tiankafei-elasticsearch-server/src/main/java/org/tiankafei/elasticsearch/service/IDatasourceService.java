package org.tiankafei.elasticsearch.service;

import org.tiankafei.elasticsearch.entity.DatasourceEntity;
import org.tiankafei.web.common.service.BaseService;

import java.util.List;

/**
 * @author 甜咖啡
 */
public interface IDatasourceService extends BaseService<DatasourceEntity> {

    /**
     * 获取数据
     * @return
     */
    public List<DatasourceEntity> getData();

}
