package org.tiankafei.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.exception.DaoException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.db.entity.TableEntity;
import org.tiankafei.db.mapper.TableMapper;
import org.tiankafei.db.param.TableNameListParam;
import org.tiankafei.db.param.TableNamePageParam;
import org.tiankafei.db.param.TableNameParam;
import org.tiankafei.db.service.TableService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.service.impl.QueryDbNameService;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TableServiceImpl extends BaseServiceImpl<TableMapper, TableEntity> implements TableService {

    @Autowired
    private QueryDbNameService queryDbNameService;

    @Override
    public TableEntity getTableEntity(TableNameParam tableNameParam) throws Exception {
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TableEntity::getTableName, tableNameParam.getTableName());
        String tableSchema = tableNameParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
        }
        lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        try {
            TableEntity tableEntity = super.getOne(lambdaQueryWrapper);
            return tableEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("获取数据库表对象发生异常！");
        }
    }

    @Override
    public Paging<TableEntity> getTableEntityPageList(TableNamePageParam tableNamePageParam) throws Exception {
        Page page = setPageParam(tableNamePageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String tableName = tableNamePageParam.getTableName();
        if (StringUtils.isNotBlank(tableName)) {
            lambdaQueryWrapper.eq(TableEntity::getTableName, tableName);
        }
        String tableSchema = tableNamePageParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
            lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        }

        IPage<TableEntity> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<TableEntity> getTableEntityList(TableNameListParam tableNameListParam) throws Exception {
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String tableName = tableNameListParam.getTableName();
        if (StringUtils.isNotBlank(tableName)) {
            lambdaQueryWrapper.eq(TableEntity::getTableName, tableName);
        }
        String tableSchema = tableNameListParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
        }
        lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        List<TableEntity> tableEntityList = super.list(lambdaQueryWrapper);
        return tableEntityList;
    }

}
