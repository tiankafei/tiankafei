package org.tiankafei.general.db.service;

import org.tiankafei.general.db.entity.TableEntity;
import org.tiankafei.general.db.param.TableNameEntityQueryParam;
import org.tiankafei.general.db.param.TableNameListQueryParam;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.util.List;

/**
 * <pre>
 * 数据库表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
public interface TableService extends BaseService<TableEntity> {

    /**
     * 获取 数据库表
     * @param tableNameEntityQueryParam
     * @return
     * @throws Exception
     */
    TableEntity getTableEntity(TableNameEntityQueryParam tableNameEntityQueryParam) throws Exception ;

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param tableNameListQueryParam
     * @return
     * @throws Exception
     */
    Paging<TableEntity> getTkfUserLoginPageList(TableNameListQueryParam tableNameListQueryParam) throws Exception;

    /**
     * 获取 数据库表 对象列表
     *
     * @param tableNameListQueryParam
     * @return
     * @throws Exception
     */
    List<TableEntity> getTkfUserLoginList(TableNameListQueryParam tableNameListQueryParam) throws Exception;

}
