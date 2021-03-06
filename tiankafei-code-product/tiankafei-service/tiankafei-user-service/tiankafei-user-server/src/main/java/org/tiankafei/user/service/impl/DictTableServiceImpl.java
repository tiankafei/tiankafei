package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ruoyi.common.core.utils.DynamicTableNameUtil;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import com.ruoyi.common.core.web.service.impl.QueryDbNameService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameListParam;
import org.tiankafei.db.service.FieldService;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.mapper.DictTableMapper;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictTableVo;
import com.ruoyi.common.core.web.page.Paging;

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

    @Autowired
    private DictInfoService dictInfoService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private QueryDbNameService queryDbNameService;

    /**
     * 获取系统字典的数据表
     *
     * @param dictId
     * @return
     */
    private String getDictDataTable(Long dictId) throws Exception {
        DictInfoEntity dictInfoEntity = dictInfoService.getById(dictId);
        return dictInfoEntity.getDataTable();
    }


    @Override
    public Map<String, FieldEntity> getDictTableFixedColumnNameMap() throws Exception {
        // 获取物理表的字段，看属性代码是否已经存在了
        FieldNameListParam fieldNameListParam = new FieldNameListParam();
        fieldNameListParam.setTableSchema(queryDbNameService.getDbName());
        fieldNameListParam.setTableName("sys_dict_table");
        List<FieldEntity> fieldEntityList = fieldService.getFieldEntityList(fieldNameListParam);

        Map<String, FieldEntity> fixedColumnNameMap = fieldEntityList.stream().collect(Collectors.toMap(FieldEntity::getFieldName, (fieldEntity) -> fieldEntity));
        return fixedColumnNameMap;
    }

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkDictTableServiceExists(DictTableCheckParam dictTableCheckParam) throws Exception {
        setDynamicTableName(dictTableCheckParam.getDictId());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictTableCheckParam != null) {
            lambdaQueryWrapper.eq(DictTableEntity::getCode, dictTableCheckParam.getCode());
            if (dictTableCheckParam.getId() != null) {
                lambdaQueryWrapper.ne(DictTableEntity::getId, dictTableCheckParam.getId());
            }
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
        setDynamicTableName(dictTableVo.getDictId());

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
            setDynamicTableName(dictTableVoList.get(0).getDictId(), false);

            for (DictTableVo dictTableVo : dictTableVoList) {
                DictTableEntity dictTableEntity = new DictTableEntity();
                BeanUtils.copyProperties(dictTableVo, dictTableEntity);
                dictTableEntityList.add(dictTableEntity);
            }
            super.saveBatch(dictTableEntityList);

            DynamicTableNameUtil.remove();
            return dictTableEntityList.stream().map(dictTableEntity -> dictTableEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统数据字典的数据表
     *
     * @param dictId
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteDictTableService(Long dictId, Long id) throws Exception {
        setDynamicTableName(dictId, false);
        // 查询所有下级的id集合
        List<Long> childrenList = Lists.newArrayList();
        childrenList.add(id);
        getChildrenIdList(childrenList, childrenList);
        // 删除的时候，把所有下级都删了
        boolean flag = super.removeByIds(childrenList);
        // 因为动态表名不是一次性使用，则需要手动remove
        DynamicTableNameUtil.remove();
        return flag;
    }

    /**
     * 查询所有下级的id集合
     *
     * @param idList
     * @return
     */
    private void getChildrenIdList(List<Long> idList, List<Long> childrenList) {
        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(DictTableEntity::getId);
        lambdaQueryWrapper.in(DictTableEntity::getParentId, idList);

        List<Long> tmpIdList = super.list(lambdaQueryWrapper).stream().map(dictTableEntity -> dictTableEntity.getId()).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(tmpIdList)) {
            childrenList.addAll(tmpIdList);

            getChildrenIdList(tmpIdList, childrenList);
        }
    }

    /**
     * 批量删除 系统数据字典的数据表
     *
     * @param dictId
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDictTableService(Long dictId, String ids) throws Exception {
        setDynamicTableName(dictId, false);

        // 遍历得到每一个要删除的id以及所有子id
        List<Long> childrenList = Lists.newArrayList();
        List<Long> idList = Stream.of(ids.split(",")).map(s -> Long.valueOf(s)).collect(Collectors.toList());
        childrenList.addAll(idList);
        getChildrenIdList(idList, childrenList);
        // 执行删除
        boolean flag = super.removeByIds(childrenList);
        // 因为动态表名不是一次性使用，则需要手动remove
        DynamicTableNameUtil.remove();
        return flag;
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
        setDynamicTableName(dictTableDeleteParam.getDictId());

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
        setDynamicTableName(dictTableVo.getDictId());

        DictTableEntity dictTableEntity = new DictTableEntity();
        BeanUtils.copyProperties(dictTableVo, dictTableEntity);
        return super.updateById(dictTableEntity);
    }

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dictId
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DictTableVo getDictTableServiceById(Long dictId, Serializable id) throws Exception {
        setDynamicTableName(dictId);

        DictTableEntity dictTableEntity = super.getById(id);
        if (dictTableEntity == null) {
            return null;
        }
        DictTableVo dictTableVo = new DictTableVo();
        BeanUtils.copyProperties(dictTableEntity, dictTableVo);
        return dictTableVo;
    }

    @Override
    public Map<Long, String> getDictTableNamesService(Long dictId, String ids) throws Exception {
        setDynamicTableName(dictId);

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(DictTableEntity::getName, DictTableEntity::getId);
        lambdaQueryWrapper.in(DictTableEntity::getId, Arrays.asList(ids.split(",")));

        return super.list(lambdaQueryWrapper).stream().collect(Collectors.toMap(DictTableEntity::getId, DictTableEntity::getName));
    }

    @Override
    public Map<String, String> getDictTableNamesFromCodesService(Long dictId, String codes) throws Exception {
        setDynamicTableName(dictId);

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(DictTableEntity::getName, DictTableEntity::getCode);
        lambdaQueryWrapper.in(DictTableEntity::getCode, Arrays.asList(codes.split(",")));
        // 当code不是唯一索引时，相同的代码可能会存在多个名称
        Map<String, List<DictTableEntity>> dataListMap = super.list(lambdaQueryWrapper).stream().collect(Collectors.groupingBy(DictTableEntity::getCode));

        // 简单粗暴返回第一个
        Map<String, String> dataMap = Maps.newHashMap();
        Set<Map.Entry<String, List<DictTableEntity>>> entries = dataListMap.entrySet();
        for (Map.Entry<String, List<DictTableEntity>> entry : entries) {
            String key = entry.getKey();
            List<DictTableEntity> value = entry.getValue();
            dataMap.put(key, value.get(0).getName());
        }
        return dataMap;
    }

    @Override
    public DictTableVo getDictTableThisAndNextLevelService(Long dictId, Serializable id) throws Exception {
        // 获取下一级
        DictTablePageParam dictTablePageParam = new DictTablePageParam();
        dictTablePageParam.setDictId(dictId);
        dictTablePageParam.setParentId(Long.parseLong(String.valueOf(id)));
        List<DictTableVo> childrenList = getDictTableChildrenService(dictTablePageParam);
        // 查询本级
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        dictTableVo.setChildren(childrenList);
        return dictTableVo;
    }

    @Override
    public DictTableVo getDictTableThisAndAllNextLevelService(Long dictId, Serializable id) throws Exception {
        setDynamicTableName(dictId, false);
        // 查询所有下级的id集合
        List<Long> childrenList = Lists.newArrayList();
        getChildrenIdList(Arrays.asList(Long.parseLong(String.valueOf(id))), childrenList);
        // 查询所有下级的对象集合
        DictTableListParam dictTableListParam = new DictTableListParam();
        dictTableListParam.setIdList(childrenList);
        List<DictTableVo> dictTableVoList = dictTableMapper.getDictTableServiceList(dictTableListParam);
        // 按照父id进行分组
        Map<Long, List<DictTableVo>> listMap = dictTableVoList.stream().collect(Collectors.groupingBy(DictTableVo::getParentId));
        List<DictTableVo> result = dictTableVoList.stream().map(dictTableVo -> {
            Long idKey = dictTableVo.getId();
            if (listMap.containsKey(idKey)) {
                dictTableVo.setChildren(listMap.get(idKey));
            }
            return dictTableVo;
        }).filter(dictTableVo -> dictTableVo.getParentId().equals(id)).collect(Collectors.toList());
        // 查询本级
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        dictTableVo.setChildren(result);
        // 因为动态表名不是一次性使用，则需要手动remove
        DynamicTableNameUtil.remove();
        return dictTableVo;
    }

    @Override
    public DictTableVo getDictTableParentService(Long dictId, Serializable id) throws Exception {
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        Long parentId = dictTableVo.getParentId();
        if (parentId != null) {
            return getDictTableServiceById(dictId, parentId);
        }
        return null;
    }

    @Override
    public DictTableVo getDictTableAllParentService(Long dictId, Serializable id) throws Exception {
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        String allParentId = dictTableVo.getAllParentId();
        if (StringUtils.isNotBlank(allParentId)) {
            return getPrevDictTableVo(dictId, allParentId);
        }
        return dictTableVo;
    }

    private DictTableVo getPrevDictTableVo(Long dictId, String ids) throws Exception {
        // 所有父id拼成一个集合
        String[] split = ids.split(",");
        List<Long> idList = Arrays.asList(split).stream().map(key -> Long.valueOf(key)).collect(Collectors.toList());
        // 查询所有上级
        DictTableListParam dictTableListParam = new DictTableListParam();
        dictTableListParam.setDictId(dictId);
        dictTableListParam.setIdList(idList);
        List<DictTableVo> dictTableList = getDictTableServiceList(dictTableListParam);
        // 组装成id -> 对象的map集合
        Map<Long, DictTableVo> dictTableVoMap = dictTableList.stream().collect(Collectors.toMap(DictTableVo::getId, dictTableVo1 -> dictTableVo1));

        // 找到跟对象
        Long rootId = idList.get(0);
        DictTableVo rootDictTableVo = dictTableVoMap.get(rootId);
        DictTableVo curDictTableVo = rootDictTableVo;
        for (int index = 1, length = idList.size(); index < length; index++) {
            Long tempId = idList.get(index);
            DictTableVo tempDictTableVo = dictTableVoMap.get(tempId);
            curDictTableVo.setChildren(Arrays.asList(tempDictTableVo));
            curDictTableVo = tempDictTableVo;
        }
        return rootDictTableVo;
    }

    @Override
    public DictTableVo getDictTableThisAndParentService(Long dictId, Serializable id) throws Exception {
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        Long parentId = dictTableVo.getParentId();
        if (parentId != null) {
            DictTableVo parentDictTableVo = getDictTableServiceById(dictId, parentId);
            parentDictTableVo.setChildren(Arrays.asList(dictTableVo));
            return parentDictTableVo;
        }
        return dictTableVo;
    }

    @Override
    public DictTableVo getDictTableThisAndAllParentService(Long dictId, Serializable id) throws Exception {
        DictTableVo dictTableVo = getDictTableServiceById(dictId, id);
        String allParentId = dictTableVo.getAllParentId();
        if (StringUtils.isNotBlank(allParentId)) {
            return getPrevDictTableVo(dictId, allParentId + "," + id);
        }
        return dictTableVo;
    }

    @Override
    public List<DictTableVo> getDictTableChildrenService(DictTablePageParam dictTablePageParam) throws Exception {
        setDynamicTableName(dictTablePageParam.getDictId());

        List<DictTableVo> dictTableVoList = dictTableMapper.getDictTableChildrenService(dictTablePageParam.getParentId());
        return dictTableVoList;
    }

    @Override
    public List<DictTableVo> getDictTableAllChildrenService(Long dictId, Serializable id) throws Exception {
        setDynamicTableName(dictId, false);
        // 查询所有下级的id集合
        List<Long> childrenList = Lists.newArrayList();
        getChildrenIdList(Arrays.asList(Long.parseLong(String.valueOf(id))), childrenList);
        // 查询所有下级的对象集合
        DictTableListParam dictTableListParam = new DictTableListParam();
        dictTableListParam.setIdList(childrenList);
        List<DictTableVo> dictTableVoList = dictTableMapper.getDictTableServiceList(dictTableListParam);
        // 按照父id进行分组
        Map<Long, List<DictTableVo>> listMap = dictTableVoList.stream().collect(Collectors.groupingBy(DictTableVo::getParentId));
        List<DictTableVo> result = dictTableVoList.stream().map(dictTableVo -> {
            Long idKey = dictTableVo.getId();
            if (listMap.containsKey(idKey)) {
                dictTableVo.setChildren(listMap.get(idKey));
            }
            return dictTableVo;
        }).filter(dictTableVo -> dictTableVo.getParentId().equals(id)).collect(Collectors.toList());
        // 因为动态表名不是一次性使用，则需要手动remove
        DynamicTableNameUtil.remove();
        return result;
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
        setDynamicTableName(dictTableListParam.getDictId());

        return dictTableMapper.getDictTableServiceList(dictTableListParam);
    }

    @Override
    public List<DictTableVo> getDictTableServiceTreeList(DictTableListParam dictTableListParam) throws Exception {
        List<DictTableVo> dictTableVoList = getDictTableServiceList(dictTableListParam);
        // list转树结构
        return processListToTree(dictTableVoList);
    }

    private List<DictTableVo> processListToTree(List<DictTableVo> dictTableVoList) {
        Map<Long, List<DictTableVo>> dictTableMap = dictTableVoList.stream().filter(dictTableVo -> dictTableVo.getParentId() != null).collect(Collectors.groupingBy(DictTableVo::getParentId));
        List<DictTableVo> resultList = dictTableVoList.stream().map(dictTableVo -> {
            Long id = dictTableVo.getId();
            if (dictTableMap.containsKey(id)) {
                dictTableVo.setChildren(dictTableMap.get(id));
            }
            return dictTableVo;
        }).filter(dictTableVo -> dictTableVo.getParentId() == null).collect(Collectors.toList());
        return resultList;
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
        setDynamicTableName(dictTablePageParam.getDictId());

        Page page = setPageParam(dictTablePageParam);
        // 分页查询先查询主键id
        IPage<DictTableVo> iPage = dictTableMapper.getDictTableServicePageList(page, dictTablePageParam);
        List<Long> idList = iPage.getRecords().stream().map(dictTableVo -> dictTableVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<DictTableVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            DictTableListParam dictTableListParam = new DictTableListParam();
            dictTableListParam.setIdList(idList);
            dictTableListParam.setDictId(dictTablePageParam.getDictId());
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
        setDynamicTableName(dictTableCountParam.getDictId());

        LambdaQueryWrapper<DictTableEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictTableCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }

    /**
     * 设置动态表名
     *
     * @param dictId
     */
    private void setDynamicTableName(Long dictId) throws Exception {
        String dataTable = getDictDataTable(dictId);
        DynamicTableNameUtil.setDynamicTableName(dataTable);
    }

    /**
     * 设置动态表名
     *
     * @param dictId
     */
    private void setDynamicTableName(Long dictId, boolean once) throws Exception {
        String dataTable = getDictDataTable(dictId);
        DynamicTableNameUtil.setDynamicTableName(dataTable, once);
    }

}
