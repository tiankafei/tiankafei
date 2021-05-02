package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.mapper.DictTableMapper;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.utils.DynamicTableNameUtil;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统数据字典的数据表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictTableServiceImpl extends BaseServiceImpl<DictTableMapper, DictTableEntity> implements DictTableService {

    @Autowired
    private DictTableMapper dictTableMapper;


    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkDictTableServiceExists(DictTableCheckParam dictTableCheckParam) throws Exception {
        setDynamicTableName(dictTableCheckParam.getDataTable());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictTableCheckParam != null) {

        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addDictTableService(DictTableVo dictTableVo) throws Exception {
        setDynamicTableName(dictTableVo.getDataTable());

        DictTableEntity dictTableEntity = new DictTableEntity();
        BeanUtils.copyProperties(dictTableVo, dictTableEntity);
        super.save(dictTableEntity);
        return dictTableEntity.getId();
    }

    /**
     * 保存 系统数据字典的数据表 集合
     *
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddDictTableService(List<DictTableVo> dictTableVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(dictTableVoList)) {
            List<DictTableEntity> dictTableEntityList = Lists.newArrayList();
            setDynamicTableName(dictTableVoList.get(0).getDataTable());

            for (DictTableVo dictTableVo : dictTableVoList) {
                DictTableEntity dictTableEntity = new DictTableEntity();
                BeanUtils.copyProperties(dictTableVo, dictTableEntity);
                dictTableEntityList.add(dictTableEntity);
            }
            super.saveBatch(dictTableEntityList);

            return dictTableEntityList.stream().map(dictTableEntity -> dictTableEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统数据字典的数据表
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteDictTableService(String dataTable, String id) throws Exception {
        setDynamicTableName(dataTable);

        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统数据字典的数据表
     *
     * @param dataTable
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDictTableService(String dataTable, String ids) throws Exception {
        setDynamicTableName(dataTable);

        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param dictTableDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteDictTableService(DictTableDeleteParam dictTableDeleteParam) throws Exception {
        setDynamicTableName(dictTableDeleteParam.getDataTable());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictTableDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateDictTableService(DictTableVo dictTableVo) throws Exception {
        setDynamicTableName(dictTableVo.getDataTable());

        DictTableEntity dictTableEntity = new DictTableEntity();
        BeanUtils.copyProperties(dictTableVo, dictTableEntity);
        return super.updateById(dictTableEntity);
    }

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DictTableVo getDictTableServiceById(String dataTable, Serializable id) throws Exception {
        setDynamicTableName(dataTable);

        DictTableEntity dictTableEntity = super.getById(id);
        if (dictTableEntity == null) {
            return null;
        }
        DictTableVo dictTableVo = new DictTableVo();
        BeanUtils.copyProperties(dictTableEntity, dictTableVo);
        return dictTableVo;
    }

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<DictTableVo> getDictTableServiceList(DictTableListParam dictTableListParam) throws Exception {
        setDynamicTableName(dictTableListParam.getDataTable());

        return dictTableMapper.getDictTableServiceList(dictTableListParam);
    }

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<DictTableVo> getDictTableServicePageList(DictTablePageParam dictTablePageParam) throws Exception {
        String dataTable = dictTablePageParam.getDataTable();
        setDynamicTableName(dataTable);

        Page page = setPageParam(dictTablePageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<DictTableVo> iPage = dictTableMapper.getDictTableServicePageList(page, dictTablePageParam);
        List<Long> idList = iPage.getRecords().stream().map(dictTableVo -> dictTableVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<DictTableVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            DictTableListParam dictTableListParam = new DictTableListParam();
            dictTableListParam.setIdList(idList);
            dictTableListParam.setDataTable(dataTable);
            List<DictTableVo> dictTableVoList = this.getDictTableServiceList(dictTableListParam);
            paging.setRecords(dictTableVoList);
        }
        return paging;
    }

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countDictTableService(DictTableCountParam dictTableCountParam) throws Exception {
        setDynamicTableName(dictTableCountParam.getDataTable());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictTableCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
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
