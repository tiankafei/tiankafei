package org.tiankafei.db.service;

import java.util.List;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameParam;
import org.tiankafei.db.param.FieldNameListParam;
import org.tiankafei.db.param.FieldNamePageParam;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 */
public interface FieldService extends BaseService<FieldEntity> {

    /**
     * 获取 数据库表的字段
     *
     * @param fieldNameParam
     * @return
     * @throws Exception
     */
    FieldEntity getFieldEntity(FieldNameParam fieldNameParam) throws Exception;

    /**
     * 获取 数据库表的字段 分页对象列表
     *
     * @param fieldNamePageParam
     * @return
     * @throws Exception
     */
    Paging<FieldEntity> getFieldEntityPageList(FieldNamePageParam fieldNamePageParam) throws Exception;

    /**
     * 获取 数据库表的字段 对象列表
     *
     * @param fieldNameListParam
     * @return
     * @throws Exception
     */
    List<FieldEntity> getFieldEntityList(FieldNameListParam fieldNameListParam) throws Exception;

}
