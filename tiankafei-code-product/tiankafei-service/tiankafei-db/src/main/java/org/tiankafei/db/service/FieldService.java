package org.tiankafei.db.service;

import java.util.List;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameEntityQueryParam;
import org.tiankafei.db.param.FieldNameListQueryParam;
import org.tiankafei.db.param.FieldNamePageListQueryParam;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 */
public interface FieldService extends BaseService<FieldEntity> {

    /**
     * 获取 数据库表的字段
     *
     * @param fieldNameEntityQueryParam
     * @return
     * @throws Exception
     */
    FieldEntity getFieldEntity(FieldNameEntityQueryParam fieldNameEntityQueryParam) throws Exception;

    /**
     * 获取 数据库表的字段 分页对象列表
     *
     * @param fieldNamePageListQueryParam
     * @return
     * @throws Exception
     */
    Paging<FieldEntity> getFieldEntityPageList(FieldNamePageListQueryParam fieldNamePageListQueryParam) throws Exception;

    /**
     * 获取 数据库表的字段 对象列表
     *
     * @param fieldNameListQueryParam
     * @return
     * @throws Exception
     */
    List<FieldEntity> getFieldEntityList(FieldNameListQueryParam fieldNameListQueryParam) throws Exception;

}
