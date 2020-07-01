package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.config.MybatisPlusConfig;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysDictTableEntity;
import org.tiankafei.user.mapper.SysDictTableMapper;
import org.tiankafei.user.service.SysDictTableService;
import org.tiankafei.user.param.SysDictTableQueryParam;
import org.tiankafei.user.param.SysDictTablePageQueryParam;
import org.tiankafei.user.vo.SysDictTableQueryVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.utils.DynamicTableNameUtil;
import org.tiankafei.web.common.vo.Paging;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;

/**
 * <pre>
 * 系统数据字典的数据表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDictTableServiceImpl extends BaseServiceImpl<SysDictTableMapper, SysDictTableEntity> implements SysDictTableService {

    @Autowired
    private SysDictTableMapper sysDictTableMapper;

    @Override
    public boolean checkSysDictTableExists(SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        setDynamicTableName(sysDictTableQueryParam.getDataTable());
        LambdaQueryWrapper<SysDictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysDictTable(SysDictTableQueryVo sysDictTableQueryVo) throws Exception {
        setDynamicTableName(sysDictTableQueryVo.getDataTable());

        SysDictTableEntity sysDictTableEntity = new SysDictTableEntity();
        BeanUtils.copyProperties(sysDictTableQueryVo, sysDictTableEntity);
        super.save(sysDictTableEntity);
        return sysDictTableEntity.getId();
    }
        
    @Override
    public boolean addSysDictTableList(String dataTable, List<SysDictTableQueryVo> sysDictTableQueryVoList) throws Exception {
        setDynamicTableName(dataTable);

        if(sysDictTableQueryVoList != null && !sysDictTableQueryVoList.isEmpty()){
            List<SysDictTableEntity> sysDictTableList = new ArrayList<>();
            for ( SysDictTableQueryVo sysDictTableQueryVo : sysDictTableQueryVoList) {
                SysDictTableEntity sysDictTableEntity = new SysDictTableEntity();
                BeanUtils.copyProperties(sysDictTableQueryVo, sysDictTableEntity);
                sysDictTableList.add(sysDictTableEntity);
            }
            super.saveBatch(sysDictTableList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDictTable(SysDictTableQueryVo sysDictTableQueryVo) throws Exception {
        setDynamicTableName(sysDictTableQueryVo.getDataTable());

        SysDictTableEntity sysDictTableEntity = new SysDictTableEntity();
        BeanUtils.copyProperties(sysDictTableQueryVo, sysDictTableEntity);
        return super.updateById(sysDictTableEntity);
    }

    @Override
    public boolean deleteSysDictTable(String dataTable, String ids) throws Exception {
        setDynamicTableName(dataTable);

        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysDictTable(SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        setDynamicTableName(sysDictTableQueryParam.getDataTable());

        LambdaQueryWrapper <SysDictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysDictTableQueryVo getSysDictTableById(String dataTable, Serializable id) throws Exception {
        setDynamicTableName(dataTable);

         SysDictTableEntity sysDictTableEntity = super.getById(id);
         SysDictTableQueryVo sysDictTableQueryVo = new SysDictTableQueryVo();
         BeanUtils.copyProperties(sysDictTableEntity, sysDictTableQueryVo);
        return sysDictTableQueryVo;
    }

    @Override
    public Paging<SysDictTableQueryVo> getSysDictTablePageList(SysDictTablePageQueryParam sysDictTablePageQueryParam) throws Exception {
        setDynamicTableName(sysDictTablePageQueryParam.getDataTable());

        Page page = setPageParam(sysDictTablePageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysDictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysDictTableQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysDictTableQueryVo> getSysDictTableList(SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        setDynamicTableName(sysDictTableQueryParam.getDataTable());

        List<SysDictTableQueryVo> sysDictTableQueryVoList = sysDictTableMapper.getSysDictTableList(sysDictTableQueryParam);
        return sysDictTableQueryVoList;
    }
    
    @Override
    public int countSysDictTable(SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        setDynamicTableName(sysDictTableQueryParam.getDataTable());

        LambdaQueryWrapper <SysDictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

    /**
     * 设置动态表名
     * @param dataTable
     */
    private void setDynamicTableName(String dataTable){
        DynamicTableNameUtil.setDynamicTableName(dataTable);
    }

}