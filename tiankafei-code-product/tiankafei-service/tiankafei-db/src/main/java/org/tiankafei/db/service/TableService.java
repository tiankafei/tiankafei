package org.tiankafei.db.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.util.List;
import org.tiankafei.db.entity.TableEntity;
import org.tiankafei.db.param.TableNameListParam;
import org.tiankafei.db.param.TableNamePageParam;
import org.tiankafei.db.param.TableNameParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 数据库表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface TableService extends BaseService<TableEntity> {

    /**
     * 获取 数据库表
     *
     * @param tableNameParam
     * @return
     * @throws Exception
     */
    TableEntity getTableEntity(TableNameParam tableNameParam) throws Exception;

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param tableNamePageParam
     * @return
     * @throws Exception
     */
    Paging<TableEntity> getTableEntityPageList(TableNamePageParam tableNamePageParam) throws Exception;

    /**
     * 获取 数据库表 对象列表
     *
     * @param tableNameListParam
     * @return
     * @throws Exception
     */
    List<TableEntity> getTableEntityList(TableNameListParam tableNameListParam) throws Exception;

}
