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
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.mapper.FieldMapper;
import org.tiankafei.db.param.FieldNameParam;
import org.tiankafei.db.param.FieldNameListParam;
import org.tiankafei.db.param.FieldNamePageParam;
import org.tiankafei.db.service.FieldService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.service.impl.QueryDbNameService;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class FieldServiceImpl extends BaseServiceImpl<FieldMapper, FieldEntity> implements FieldService {

    @Autowired
    private QueryDbNameService queryDbNameService;

    @Override
    public FieldEntity getFieldEntity(FieldNameParam fieldNameParam) throws Exception {
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNameParam.getTableName());
        lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldNameParam.getFieldName());
        String tableSchema = fieldNameParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
        }
        lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        try {
            FieldEntity fieldEntity = super.getOne(lambdaQueryWrapper);
            return fieldEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("获取数据库表对象发生异常！");
        }
    }

    @Override
    public Paging<FieldEntity> getFieldEntityPageList(FieldNamePageParam fieldNamePageParam) throws Exception {
        Page page = setPageParam(fieldNamePageParam, OrderItem.desc("ORDINAL_POSITION"));
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNamePageParam.getTableName());
        String fieldName = fieldNamePageParam.getFieldName();
        if (StringUtils.isNotBlank(fieldName)) {
            lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldName);
        }
        String tableSchema = fieldNamePageParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
            lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        }
        IPage<FieldEntity> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<FieldEntity> getFieldEntityList(FieldNameListParam fieldNameListParam) throws Exception {
        LambdaQueryWrapper<FieldEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FieldEntity::getTableName, fieldNameListParam.getTableName());
        String fieldName = fieldNameListParam.getFieldName();
        if (StringUtils.isNotBlank(fieldName)) {
            lambdaQueryWrapper.eq(FieldEntity::getFieldName, fieldName);
        }
        String tableSchema = fieldNameListParam.getTableSchema();
        if (StringUtils.isBlank(tableSchema)) {
            tableSchema = queryDbNameService.getDbName();
            lambdaQueryWrapper.eq(FieldEntity::getTableSchema, tableSchema);
        }
        List<FieldEntity> fieldEntityList = super.list(lambdaQueryWrapper);
        return fieldEntityList;
    }
}
