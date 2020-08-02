package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.mapper.DictTableMapper;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.utils.DynamicTableNameUtil;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统数据字典的数据表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DictTableServiceImpl extends BaseServiceImpl<DictTableMapper, DictTableEntity> implements DictTableService {

    @Autowired
    private DictTableMapper dictTableMapper;

    @Override
    public boolean checkSysDictTableExists(DictTableListParam dictTableListParam) throws Exception {
        setDynamicTableName(dictTableListParam.getDataTable());
        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysDictTable(DictTableVo dictTableVo) throws Exception {
        setDynamicTableName(dictTableVo.getDataTable());

        DictTableEntity dictTableEntity = new DictTableEntity();
        BeanUtils.copyProperties(dictTableVo, dictTableEntity);
        super.save(dictTableEntity);
        return dictTableEntity.getId();
    }

    @Override
    public boolean addSysDictTableList(String dataTable, List<DictTableVo> dictTableVoList) throws Exception {
        setDynamicTableName(dataTable);

        if (dictTableVoList != null && !dictTableVoList.isEmpty()) {
            List<DictTableEntity> sysDictTableList = new ArrayList<>();
            for (DictTableVo dictTableVo : dictTableVoList) {
                DictTableEntity dictTableEntity = new DictTableEntity();
                BeanUtils.copyProperties(dictTableVo, dictTableEntity);
                sysDictTableList.add(dictTableEntity);
            }
            super.saveBatch(sysDictTableList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDictTable(DictTableVo dictTableVo) throws Exception {
        setDynamicTableName(dictTableVo.getDataTable());

        DictTableEntity dictTableEntity = new DictTableEntity();
        BeanUtils.copyProperties(dictTableVo, dictTableEntity);
        return super.updateById(dictTableEntity);
    }

    @Override
    public boolean deleteSysDictTable(String dataTable, String ids) throws Exception {
        setDynamicTableName(dataTable);

        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysDictTable(DictTableListParam dictTableListParam) throws Exception {
        setDynamicTableName(dictTableListParam.getDataTable());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public DictTableVo getSysDictTableById(String dataTable, Serializable id) throws Exception {
        //SysDictTableQueryVo sysDictTableQueryVo = sysDictTableMapper.getSysDictTableById(id);

        DictTableEntity dictTableEntity = super.getById(id);
        DictTableVo dictTableVo = new DictTableVo();
        BeanUtils.copyProperties(dictTableEntity, dictTableVo);
        return dictTableVo;
    }

    @Override
    public Paging<DictTableVo> getSysDictTablePageList(DictTablePageParam dictTablePageParam) throws Exception {
        //IPage<SysDictTableQueryVo> iPage = sysDictTableMapper.getSysDictTablePageList(page, sysDictTablePageQueryParam);

        Page page = setPageParam(dictTablePageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<DictTableVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<DictTableVo> getSysDictTableList(DictTableListParam dictTableListParam) throws Exception {
        setDynamicTableName(dictTableListParam.getDataTable());

        List<DictTableVo> dictTableVoList = dictTableMapper.getSysDictTableList(dictTableListParam);
        return dictTableVoList;
    }

    @Override
    public int countSysDictTable(DictTableListParam dictTableListParam) throws Exception {
        setDynamicTableName(dictTableListParam.getDataTable());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

    /**
     * 设置动态表名
     *
     * @param dataTable
     */
    private void setDynamicTableName(String dataTable) {
        DynamicTableNameUtil.setDynamicTableName(dataTable);
    }

}