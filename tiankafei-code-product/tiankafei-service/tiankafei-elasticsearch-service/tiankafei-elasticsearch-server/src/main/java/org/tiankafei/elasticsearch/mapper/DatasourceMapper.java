package org.tiankafei.elasticsearch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.tiankafei.elasticsearch.entity.DatasourceEntity;

import java.util.List;

/**
 * @author 甜咖啡
 */
@Repository
public interface DatasourceMapper extends BaseMapper<DatasourceEntity> {

    /**
     * 获取数据
     * @return
     */
    public List<DatasourceEntity> getData();

}
