package org.tiankafei.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.ruoyi.business.api.RemoteAttributesService;
import com.ruoyi.business.api.RemoteFeaturesService;
import com.ruoyi.business.api.constants.FeaturesConstants;
import com.ruoyi.business.api.domain.SysAttributes;
import com.ruoyi.business.api.domain.SysFeatures;
import com.ruoyi.common.core.enums.ApiStatusEnum;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import com.ruoyi.common.core.web.service.impl.QueryDbNameService;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameListParam;
import org.tiankafei.db.param.FieldParam;
import org.tiankafei.db.service.DbService;
import org.tiankafei.db.service.FieldService;
import org.tiankafei.user.constants.UserConstants;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.mapper.DictInfoMapper;
import org.tiankafei.user.model.CatalogDto;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.exception.UserException;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统数据字典表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DictInfoServiceImpl extends BaseServiceImpl<DictInfoMapper, DictInfoEntity> implements DictInfoService {

    @Autowired
    private DictInfoMapper dictInfoMapper;

    @Autowired
    private DbService dbService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private QueryDbNameService queryDbNameService;

    @Autowired
    private DefaultIdentifierGenerator defaultIdentifierGenerator;

    @Autowired
    private RemoteFeaturesService remoteFeaturesService;

    @Autowired
    private RemoteAttributesService remoteAttributesService;

    @Autowired
    private DictTableService dictTableService;

    @Override
    public boolean initDictInfoServiceExists() throws Exception {
        String directory = "D:\\data\\catalogs";
        File file = new File(directory);
        File[] files = file.listFiles();
        for (File f : files) {
            String name = f.getName();
            String filePath = f.getPath() + File.separator + name + ".json";
            String str = FileUtils.readFileToString(new File(filePath), "utf-8");

            DictInfoVo dictInfoVo = new DictInfoVo();
            dictInfoVo.setDictCode(name.split("-")[0]);
            dictInfoVo.setDictName(name.split("-")[1]);
            dictInfoVo.setStatus(Boolean.TRUE);
            dictInfoVo.setDescription(dictInfoVo.getDictName());
            dictInfoVo.setRemarks(dictInfoVo.getDictName());
            dictInfoVo.setUseType("1");
            dictInfoVo.setVersion(20210520);
            addDictInfoService(dictInfoVo);

            List<CatalogDto> catalogDtos = JSONArray.parseArray(str, CatalogDto.class);
            processCatalogTree(catalogDtos, 0, null, null);

            List<DictTableVo> dataList = Lists.newArrayList();
            catalogTreeToList(catalogDtos, dataList, dictInfoVo);
            dictTableService.batchAddDictTableService(dataList);
            log.info("字典代码：{},字典名称{},数据表：{},版本：{}", dictInfoVo.getDictCode(), dictInfoVo.getDictName(), dictInfoVo.getDataTable(), dictInfoVo.getVersion());

            break;
        }
        return true;
    }

    private Long getId() {
        return defaultIdentifierGenerator.nextId(null);
    }

    /**
     * 处理树结构
     *
     * @param catalogDtos
     * @param level
     * @param parentId
     * @param allParentId
     */
    private void processCatalogTree(List<CatalogDto> catalogDtos, Integer level, Long parentId, String allParentId) {
        if (CollectionUtils.isNotEmpty(catalogDtos)) {
            for (int index = 0, length = catalogDtos.size(); index < length; index++) {
                Long id = getId();
                CatalogDto catalogDto = catalogDtos.get(index);
                catalogDto.setSerialNumber(index + 1);
                catalogDto.setLevel(level);
                catalogDto.setId(id);
                catalogDto.setParentId(parentId);

                catalogDto.setAllParentId(allParentId);

                String str = allParentId == null ? id + "" : catalogDto.getAllParentId() + "," + id;

                processCatalogTree(catalogDto.getSub(), level + 1, id, str);
            }
        }
    }

    private void catalogTreeToList(List<CatalogDto> catalogDtos, List<DictTableVo> dataList, DictInfoVo dictInfoVo) {
        if (CollectionUtils.isNotEmpty(catalogDtos)) {
            for (CatalogDto catalogDto : catalogDtos) {
                List<CatalogDto> sub = catalogDto.getSub();

                DictTableVo dictTableVo = new DictTableVo();
                BeanUtils.copyProperties(catalogDto, dictTableVo);
                dictTableVo.setDictId(dictInfoVo.getId());
                dictTableVo.setVersion(dictInfoVo.getVersion());
                dataList.add(dictTableVo);

                catalogTreeToList(sub, dataList, dictInfoVo);
            }
        }
    }

    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param dictInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkDictInfoServiceExists(DictInfoCheckParam dictInfoCheckParam) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictInfoCheckParam != null) {
            String dictCode = dictInfoCheckParam.getDictCode();
            if (StringUtils.isNotBlank(dictCode)) {
                lambdaQueryWrapper.eq(DictInfoEntity::getDictCode, dictCode);
            }
            Long id = dictInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(DictInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public boolean checkDictInfoServiceDataTableExists(String dataTable, String id) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(dataTable)) {
            lambdaQueryWrapper.eq(DictInfoEntity::getDataTable, dataTable);
        }
        if (StringUtils.isNotBlank(id)) {
            lambdaQueryWrapper.ne(DictInfoEntity::getId, id);
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addDictInfoService(DictInfoVo dictInfoVo) throws Exception {
        String dictCode = dictInfoVo.getDictCode();
        if (checkDictInfoServiceExists(new DictInfoCheckParam().setDictCode(dictCode))) {
            throw new UserException("字典代码：" + dictCode + " 已经存在！");
        }
        // 生成序列号
        Long id = defaultIdentifierGenerator.nextId(null);
        DictInfoEntity dictInfoEntity = new DictInfoEntity();
        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
        dictInfoEntity.setId(id);

        String dataTable = dictInfoVo.getDataTable();
        if (StringUtils.isNotBlank(dataTable)) {
            boolean tableExists = dbService.checkTableExists(dataTable);
            if (tableExists) {
                throw new UserException("代码数据表：" + dataTable + " 已经存在！");
            }
        } else {
            dictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + id);
            dictInfoVo.setDataTable(dictInfoEntity.getDataTable());
        }

        SysFeatures sysFeatures = new SysFeatures();
        sysFeatures.setCode(dictInfoVo.getDictCode());
        sysFeatures.setName(dictInfoVo.getDictName());
        sysFeatures.setStatus(false);
        sysFeatures.setSerialNumber(0L);
        sysFeatures.setUseType(FeaturesConstants.FEATURES_USE_TYPE_SYS);

        ApiResult<Long> result = remoteFeaturesService.add(sysFeatures);
        if (ApiStatusEnum.OK.getStatus().equals(result.getCode())) {
            dictInfoEntity.setFeaturesId(result.getData());

            super.save(dictInfoEntity);

            Boolean status = dictInfoVo.getStatus();
            if (status) {
                // 启用时：创建字段数据表
                dbService.createTable("sys_dict_table", dictInfoEntity.getDataTable(), dictInfoEntity.getDictName() + "字典数据表");
            }
            dictInfoVo.setId(dictInfoEntity.getId());
            return dictInfoEntity.getId();
        }
        throw new UserException("新增代码表失败");
    }

    /**
     * 保存 系统数据字典表 集合
     *
     * @param dictInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddDictInfoService(List<DictInfoVo> dictInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(dictInfoVoList)) {
            // 生成序列号
            Long id = defaultIdentifierGenerator.nextId(null);
            // 批量新增时的字典代码集合
            List<String> codeList = Lists.newArrayList();
            // 批量新增时的字典数据表集合
            List<String> tableList = Lists.newArrayList();
            // 批量新增时的字典时创建的对应的功能属性集合
            List<SysFeatures> sysFeaturesList = Lists.newArrayList();
            // 批量保存数据字典
            List<DictInfoEntity> dictInfoEntityList = Lists.newArrayList();
            for (int index = 0, length = dictInfoVoList.size(); index < length; index++) {
                DictInfoVo dictInfoVo = dictInfoVoList.get(index);
                codeList.add(dictInfoVo.getDictCode());

                DictInfoEntity dictInfoEntity = new DictInfoEntity();
                BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
                dictInfoEntity.setId(id + index);
                // 数据表
                if (StringUtils.isNotBlank(dictInfoVo.getDataTable())) {
                    tableList.add(dictInfoVo.getDataTable());
                } else {
                    dictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + dictInfoEntity.getId());
                }
                dictInfoEntityList.add(dictInfoEntity);

                SysFeatures sysFeatures = new SysFeatures();
                sysFeatures.setCode(dictInfoVo.getDictCode());
                sysFeatures.setName(dictInfoVo.getDictName());
                sysFeatures.setStatus(false);
                sysFeatures.setSerialNumber(0L);
                sysFeatures.setUseType(FeaturesConstants.FEATURES_USE_TYPE_SYS);
                sysFeaturesList.add(sysFeatures);
            }
            // 批量新增时校验字典代码是否已经存在
            LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
            lambdaQueryWrapper.select(DictInfoEntity::getId);
            lambdaQueryWrapper.in(DictInfoEntity::getDictCode, codeList);
            List<String> alreadyCodeList = super.list(lambdaQueryWrapper).stream().map(dictInfoEntity -> dictInfoEntity.getDictCode()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(alreadyCodeList)) {
                throw new UserException("字典代码：" + alreadyCodeList + " 已经存在！");
            }

            // 批量新增时校验字典数据表是否已经存在
            if (CollectionUtils.isNotEmpty(tableList)) {
                lambdaQueryWrapper = new LambdaQueryWrapper();
                lambdaQueryWrapper.select(DictInfoEntity::getId);
                lambdaQueryWrapper.in(DictInfoEntity::getDataTable, tableList);
                List<String> alreadyTableList = super.list(lambdaQueryWrapper).stream().map(dictInfoEntity -> dictInfoEntity.getDataTable()).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(alreadyTableList)) {
                    throw new UserException("字典数据表：" + alreadyTableList + " 已经存在！");
                }
            }

            // 如果启用，创建物理表
            for (DictInfoEntity dictInfoEntity : dictInfoEntityList) {
                if (dictInfoEntity.getStatus()) {
                    // 启用时：创建字段数据表
                    dbService.createTable("sys_dict_table", dictInfoEntity.getDataTable(), dictInfoEntity.getDictName() + "字典数据表");
                }
            }

            // 创建代码表对应的功能属性维护的数据
            ApiResult<List<Long>> result = remoteFeaturesService.batchAdd(sysFeaturesList);
            if (ApiStatusEnum.OK.getStatus().equals(result.getCode())) {
                // 批量保存代码表数据
                super.saveBatch(dictInfoEntityList);
                return dictInfoEntityList.stream().map(dictInfoEntity -> dictInfoEntity.getId()).collect(Collectors.toList());
            } else {
                throw new UserException("批量新增代码表失败！");
            }
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteDictInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            DictInfoEntity oldDictInfoEntity = dictInfoMapper.selectById(id);
            // 删除代码表对应的功能属性维护的数据
            if (oldDictInfoEntity.getFeaturesId() != null) {
                remoteFeaturesService.remove(new Long[]{oldDictInfoEntity.getFeaturesId()});
            }
            // 删除字典数据
            boolean flag = super.removeById(id);
            // drop 字典数据表
            String dataTable = oldDictInfoEntity.getDataTable();
            boolean tableExists = dbService.checkTableExists(dataTable);
            if (tableExists) {
                // 删除字典数据表
                dbService.dropTable(dataTable);
            }
            return flag;
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDictInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));

            // 先把要删的字典的数据查出来，再进行删除，否则删除之后，数据表就查不到了
            LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
            lambdaQueryWrapper.select(DictInfoEntity::getDataTable, DictInfoEntity::getFeaturesId);
            lambdaQueryWrapper.in(DictInfoEntity::getId, idList);
            List<DictInfoEntity> dictInfoEntityList = super.list(lambdaQueryWrapper);
            List<String> dataTableList = dictInfoEntityList.stream().map(dictInfoEntity -> dictInfoEntity.getDataTable()).collect(Collectors.toList());

            // 删除代码表对应的功能属性维护的数据
            List<Long> featuresIds = dictInfoEntityList.stream().filter(dictInfoEntity -> dictInfoEntity.getFeaturesId() != null).map(dictInfoEntity -> dictInfoEntity.getFeaturesId()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(featuresIds)) {
                Long[] longs = featuresIds.toArray(new Long[]{});
                remoteFeaturesService.remove(longs);
            }

            // 删除字典数据
            boolean flag = super.removeByIds(idList);
            // drop 字典数据表
            for (String dataTable : dataTableList) {
                if (dbService.checkTableExists(dataTable)) {
                    dbService.dropTable(dataTable);
                }
            }
            return flag;
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统数据字典表
     *
     * @param dictInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteDictInfoService(DictInfoDeleteParam dictInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictInfoDeleteParam != null) {
            boolean flag = Boolean.FALSE;
            // 设置查询条件   先把要删的字典的数据查出来，再进行删除，否则删除之后，数据表就查不到了
            lambdaQueryWrapper.select(DictInfoEntity::getDataTable, DictInfoEntity::getId);
            List<DictInfoEntity> dictInfoEntityList = super.list(lambdaQueryWrapper);

            Map<Long, String> dataMap = dictInfoEntityList.stream().collect(Collectors.toMap(DictInfoEntity::getId, DictInfoEntity::getDataTable));
            Collection<String> dataTableList = dataMap.values();
            Set<Long> idList = dataMap.keySet();
            // 删除字典数据
            if (CollectionUtils.isNotEmpty(idList)) {
                flag = super.removeByIds(idList);
            }
            // 删除字典数据表
            if (CollectionUtils.isNotEmpty(dataTableList)) {
                for (String dataTable : dataTableList) {
                    dbService.dropTable(dataTable);
                }
            }
            return flag;
        }
        return Boolean.TRUE;
    }

    /**
     * 修改 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateDictInfoService(DictInfoVo dictInfoVo) throws Exception {
        // 根据ID查询原字段代码
        Long id = dictInfoVo.getId();
        DictInfoEntity oldDictInfoEntity = dictInfoMapper.selectById(id);
        String oldDictCode = oldDictInfoEntity.getDictCode();
        String newDictCode = dictInfoVo.getDictCode();
        // 当发现字典代码发生更改时，校验新的字典代码是否存在
        if (!newDictCode.equals(oldDictCode)) {
            if (checkDictInfoServiceExists(new DictInfoCheckParam().setDictCode(newDictCode).setId(id))) {
                throw new UserException("字典代码：" + newDictCode + " 已经存在！");
            }
        }
        if (dictInfoVo.getStatus()) {
            // 修改成启用状态时，如果表不存在，则执行创建
            boolean tableExists = dbService.checkTableExists(oldDictInfoEntity.getDataTable());
            if (!tableExists) {
                // 启用时：创建字段数据表
                dbService.createTable("sys_dict_table", oldDictInfoEntity.getDataTable(), oldDictInfoEntity.getDictName() + "字典数据表");
            }
        }
        DictInfoEntity dictInfoEntity = new DictInfoEntity();
        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
        return super.updateById(dictInfoEntity);
    }

    @Override
    public boolean updateDictInfoServiceStatus(String id, Boolean status) throws Exception {
        DictInfoEntity dictInfoEntity = super.getById(id);
        dictInfoEntity.setStatus(status);
        super.updateById(dictInfoEntity);

        if (Boolean.TRUE.equals(status)) {
            // 新增的业务属性集合
            List<SysAttributes> sysAttributesList = remoteAttributesService.list(dictInfoEntity.getFeaturesId()).getData();
            // 字典模板表的字段名集合（固定16个字段）
            Map<String, FieldEntity> dictTableFixedColumnNameMap = dictTableService.getDictTableFixedColumnNameMap();
            // 启用
            String dataTable = dictInfoEntity.getDataTable();
            if (dbService.checkTableExists(dataTable)) {
                ///
                /**
                 *  这里的逻辑有一点儿绕，举例说明
                 *      1.sysAttributesList：新传入的属性集合
                 *      2.dictTableFixedColumnNameMap：固定模板表的字段名集合；固定字段个数16个
                 *      3.curTableColumnNameMap：当前数据表的字段名集合
                 *
                 *  数据表在创建表的第一次，传入了10个业务属性，其中有1个属性的代码，正好是模板表的字段，那么这个属性将不进行创建字段，下面这行代码就是为了过滤掉这个属性
                 *      sysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !dictTableFixedColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());
                 *      此时在该表中创建了9个属性的字段
                 *
                 *  当数据表存在时，说明时第二次进来了
                 *      1.依然过滤掉属性代码和模板表字段相同的属性
                 *          sysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !dictTableFixedColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());
                 *      2.此时当前物理表的字段有16+9=25个字段
                 *          Map<String, FieldEntity> curTableColumnNameMap = findCurTableColumnNameMap(dataTable);
                 *      3.当前物理表字段集合删除模板表的16个字段，剩余9个属性字段
                 *          removeAll(curTableColumnNameMap, dictTableFixedColumnNameMap);
                 *      4.如果当前传来的属性代码，不在这9个当中，则说明有新增的属性需要创建字段
                 *          List<SysAttributes> addSysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !curTableColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());
                 *          如果当前传来的属性代码和这个9个字段名完全一样，说明没有要新增的字段
                 *      5.剩余这9个字段，过滤掉传来的属性代码，如果还有剩余，则说明有字段要进行删除
                 *          Map<String, SysAttributes> sysAttributesMap = sysAttributesList.stream().collect(Collectors.toMap(SysAttributes::getCode, (sysAttributes) -> sysAttributes));
                 *          removeAll(curTableColumnNameMap, sysAttributesMap);
                 *          if (!curTableColumnNameMap.isEmpty()) {
                 *
                 *          }
                 *
                 */
                // 过滤掉属性代码和模板表字段相同的属性
                sysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !dictTableFixedColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());

                // 当前物理表字段集合删除模板表字段
                Map<String, FieldEntity> curTableColumnNameMap = findCurTableColumnNameMap(dataTable);
                removeAll(curTableColumnNameMap, dictTableFixedColumnNameMap);

                // 如果当前传来的属性代码，不在上面的集合当中，则说明有新增的属性需要创建字段
                List<SysAttributes> addSysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !curTableColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());
                addAttributes(dataTable, addSysAttributesList);

                // 当前物理表字段剩余的集合，过滤掉传来的属性代码，如果还有剩余，则说明有字段要进行删除
                Map<String, SysAttributes> sysAttributesMap = sysAttributesList.stream().collect(Collectors.toMap(SysAttributes::getCode, (sysAttributes) -> sysAttributes));
                removeAll(curTableColumnNameMap, sysAttributesMap);
                if (!curTableColumnNameMap.isEmpty()) {
                    Set<Map.Entry<String, FieldEntity>> entries = curTableColumnNameMap.entrySet();
                    for (Map.Entry<String, FieldEntity> entry : entries) {
                        FieldEntity fieldEntity = entry.getValue();
                        dbService.dropColumn(new FieldParam(fieldEntity.getTableSchema(), fieldEntity.getTableName(), fieldEntity.getFieldName()));
                    }
                }
            } else {
                // 物理表不存在时创建字段数据表
                dbService.createTable("sys_dict_table", dataTable, dictInfoEntity.getDictName() + "字典数据表");
                sysAttributesList = sysAttributesList.stream().filter(sysAttributes -> !dictTableFixedColumnNameMap.containsKey(sysAttributes.getCode())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(sysAttributesList)) {
                    addAttributes(dataTable, sysAttributesList);
                }
            }
        }
        return Boolean.TRUE;
    }

    private <T1, T2> void removeAll(Map<String, T1> map1, Map<String, T2> map2) {
        List<String> keyList = Lists.newArrayList(map1.keySet());
        for (String key : keyList) {
            if (map2.containsKey(key)) {
                map1.remove(key);
            }
        }
    }

    private void addAttributes(String dataTable, List<SysAttributes> sysAttributesList) {
        String dbName = queryDbNameService.getDbName();
        for (SysAttributes sysAttributes : sysAttributesList) {
            FieldParam fieldParam = new FieldParam(dbName, dataTable, sysAttributes.getCode());
            fieldParam.setColumnType(sysAttributes.getDataType());
            fieldParam.setColumnLength(sysAttributes.getDataLength());
            fieldParam.setColumnPrecision(sysAttributes.getDataPrecision());
            fieldParam.setIsNullable("Y".equals(sysAttributes.getIsNull()) ? Boolean.TRUE : Boolean.FALSE);
            fieldParam.setDefaultValue(sysAttributes.getDefaultValue());
            fieldParam.setComments(sysAttributes.getName());

            // 新增字段
            dbService.addColumn(fieldParam);
        }
    }

    /**
     * 获取当前吴丽奥的字段名集合
     *
     * @param dataTable
     * @return
     * @throws Exception
     */
    private Map<String, FieldEntity> findCurTableColumnNameMap(String dataTable) throws Exception {
        FieldNameListParam fieldNameListParam = new FieldNameListParam();
        fieldNameListParam.setTableSchema(queryDbNameService.getDbName());
        fieldNameListParam.setTableName(dataTable);
        List<FieldEntity> fieldEntityList = fieldService.getFieldEntityList(fieldNameListParam);
        Map<String, FieldEntity> curTableColumnNameMap = fieldEntityList.stream().collect(Collectors.toMap(FieldEntity::getFieldName, (fieldEntity) -> fieldEntity));

        return curTableColumnNameMap;
    }

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DictInfoVo getDictInfoServiceById(Serializable id) throws Exception {
        DictInfoEntity dictInfoEntity = super.getById(id);
        if (dictInfoEntity == null) {
            return null;
        }
        DictInfoVo dictInfoVo = new DictInfoVo();
        BeanUtils.copyProperties(dictInfoEntity, dictInfoVo);
        return dictInfoVo;
    }

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<DictInfoVo> getDictInfoServiceList(DictInfoListParam dictInfoListParam) throws Exception {
        return dictInfoMapper.getDictInfoServiceList(dictInfoListParam);
    }

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param dictInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<DictInfoVo> getDictInfoServicePageList(DictInfoPageParam dictInfoPageParam) throws Exception {
        Page page = setPageParam(dictInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<DictInfoVo> iPage = dictInfoMapper.getDictInfoServicePageList(page, dictInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(dictInfoVo -> dictInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<DictInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            DictInfoListParam dictInfoListParam = new DictInfoListParam();
            dictInfoListParam.setIdList(idList);
            List<DictInfoVo> dictInfoVoList = this.getDictInfoServiceList(dictInfoListParam);
            paging.setRecords(dictInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param dictInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countDictInfoService(DictInfoCountParam dictInfoCountParam) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dictInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
