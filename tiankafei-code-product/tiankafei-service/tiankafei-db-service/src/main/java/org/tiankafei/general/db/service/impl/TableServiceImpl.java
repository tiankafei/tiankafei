package org.tiankafei.general.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.general.db.entity.TableEntity;
import org.tiankafei.general.db.mapper.TableMapper;
import org.tiankafei.general.db.param.TableNameEntityQueryParam;
import org.tiankafei.general.db.param.TableNameListQueryParam;
import org.tiankafei.general.db.param.TableNamePageListQueryParam;
import org.tiankafei.general.db.service.TableService;
import org.tiankafei.general.db.utils.DbUtil;
import org.tiankafei.web.common.exception.DaoException;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TableServiceImpl extends BaseServiceImpl<TableMapper, TableEntity> implements TableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public TableEntity getTableEntity(TableNameEntityQueryParam tableNameEntityQueryParam) throws Exception {
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TableEntity::getTableName, tableNameEntityQueryParam.getTableName());
        String tableSchema = tableNameEntityQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
        }
        lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        try {
            TableEntity tableEntity = super.getOne(lambdaQueryWrapper);
            return tableEntity;
        }catch (Exception e){
            e.printStackTrace();
            throw new DaoException("获取数据库表对象发生异常！");
        }
    }

    @Override
    public Paging<TableEntity> getTableEntityPageList(TableNamePageListQueryParam tableNamePageListQueryParam) throws Exception {
        Page page = setPageParam(tableNamePageListQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String tableName = tableNamePageListQueryParam.getTableName();
        if(StringUtils.isNotBlank(tableName)){
            lambdaQueryWrapper.eq(TableEntity::getTableName, tableName);
        }
        String tableSchema = tableNamePageListQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
            lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        }

        IPage<TableEntity> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<TableEntity> getTableEntityList(TableNameListQueryParam tableNameListQueryParam) throws Exception {
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String tableName = tableNameListQueryParam.getTableName();
        if(StringUtils.isNotBlank(tableName)){
            lambdaQueryWrapper.eq(TableEntity::getTableName, tableName);
        }
        String tableSchema = tableNameListQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
            lambdaQueryWrapper.eq(TableEntity::getTableSchema, tableSchema);
        }
        List<TableEntity> tableEntityList = super.list(lambdaQueryWrapper);
        return tableEntityList;
    }

}
