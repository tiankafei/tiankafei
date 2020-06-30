package org.tiankafei.dbmysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.dbmysql.entity.FieldEntity;
import org.tiankafei.dbmysql.mapper.FieldMapper;
import org.tiankafei.dbmysql.param.FieldNameEntityQueryParam;
import org.tiankafei.dbmysql.param.FieldNameListQueryParam;
import org.tiankafei.dbmysql.service.FieldService;
import org.tiankafei.dbmysql.utils.DbUtil;
import org.tiankafei.dbmysql.param.FieldNamePageListQueryParam;
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
public class FieldServiceImpl extends BaseServiceImpl<FieldMapper, FieldEntity> implements FieldService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FieldEntity getFieldEntity(FieldNameEntityQueryParam fieldNameEntityQueryParam) throws Exception {
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNameEntityQueryParam.getTableName());
        lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldNameEntityQueryParam.getFieldName());
        String tableSchema = fieldNameEntityQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
        }
        lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        try {
            FieldEntity fieldEntity = super.getOne(lambdaQueryWrapper);
            return fieldEntity;
        }catch (Exception e){
            e.printStackTrace();
            throw new DaoException("获取数据库表对象发生异常！");
        }
    }

    @Override
    public Paging<FieldEntity> getFieldEntityPageList(FieldNamePageListQueryParam fieldNamePageListQueryParam) throws Exception {
        Page page = setPageParam(fieldNamePageListQueryParam, OrderItem.desc("ORDINAL_POSITION"));
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNamePageListQueryParam.getTableName());
        String fieldName = fieldNamePageListQueryParam.getFieldName();
        if(StringUtils.isNotBlank(fieldName)){
            lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldName);
        }
        String tableSchema = fieldNamePageListQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
            lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        }
        IPage<FieldEntity> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<FieldEntity> getFieldEntityList(FieldNameListQueryParam fieldNameListQueryParam) throws Exception {
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNameListQueryParam.getTableName());
        String fieldName = fieldNameListQueryParam.getFieldName();
        if(StringUtils.isNotBlank(fieldName)){
            lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldName);
        }
        String tableSchema = fieldNameListQueryParam.getTableSchema();
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = DbUtil.getTableSchema(jdbcTemplate);
            lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        }
        List<FieldEntity> fieldEntityList = super.list(lambdaQueryWrapper);
        return fieldEntityList;
    }
}
