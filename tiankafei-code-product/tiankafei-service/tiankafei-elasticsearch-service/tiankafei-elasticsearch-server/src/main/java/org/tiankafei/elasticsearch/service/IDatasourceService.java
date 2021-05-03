package org.tiankafei.elasticsearch.service;

import com.ruoyi.common.core.web.service.BaseService;
import org.tiankafei.elasticsearch.entity.DatasourceEntity;

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
