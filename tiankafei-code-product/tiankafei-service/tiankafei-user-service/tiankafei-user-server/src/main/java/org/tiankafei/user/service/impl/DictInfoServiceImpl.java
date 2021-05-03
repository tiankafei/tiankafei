package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.db.service.DbService;
import org.tiankafei.user.constants.UserConstants;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.mapper.DictInfoMapper;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.vo.DictInfoVo;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class DictInfoServiceImpl extends BaseServiceImpl<DictInfoMapper, DictInfoEntity> implements DictInfoService {

    @Autowired
    private DictInfoMapper dictInfoMapper;

    @Autowired
    private DbService dbService;

    @Autowired
    private DefaultIdentifierGenerator defaultIdentifierGenerator;

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
                throw new UserException("字典数据表：" + dataTable + " 已经存在！");
            }
        } else {
            dictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + id);
        }

        Boolean status = dictInfoVo.getStatus();
        if (status) {
            // 启用时：创建字段数据表
            dbService.createTable("sys_dict_table" , dictInfoVo.getDataTable(), dictInfoVo.getDictName() + "字典数据表");
        }
        super.save(dictInfoEntity);
        return dictInfoEntity.getId();
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
            List<String> dictCodeList = Lists.newArrayList();
            // 批量保存数据字典
            List<DictInfoEntity> dictInfoEntityList = Lists.newArrayList();
            for (int index = 0, length = dictInfoVoList.size(); index < length; index++) {
                DictInfoVo dictInfoVo = dictInfoVoList.get(index);
                dictCodeList.add(dictInfoVo.getDictCode());

                DictInfoEntity dictInfoEntity = new DictInfoEntity();
                BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
                dictInfoEntity.setId(id + 1);
                dictInfoEntity.setStatus(Boolean.FALSE);
                dictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + (id + 1));
                dictInfoEntityList.add(dictInfoEntity);
            }
            // 批量新增时校验字典代码是否已经存在
            LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
            lambdaQueryWrapper.select(DictInfoEntity::getId);
            lambdaQueryWrapper.in(DictInfoEntity::getDictCode, dictCodeList);
            List<String> alreadyDictCodeList = super.list(lambdaQueryWrapper).stream().map(dictInfoEntity -> dictInfoEntity.getDictCode()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(alreadyDictCodeList)) {
                throw new UserException("字典代码：" + alreadyDictCodeList + " 已经存在！");
            }
            // 执行保存
            super.saveBatch(dictInfoEntityList);
            return dictInfoEntityList.stream().map(dictInfoEntity -> dictInfoEntity.getId()).collect(Collectors.toList());
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
            lambdaQueryWrapper.select(DictInfoEntity::getDataTable);
            lambdaQueryWrapper.in(DictInfoEntity::getId, idList);
            List<DictInfoEntity> dictInfoEntityList = super.list(lambdaQueryWrapper);
            List<String> dataTableList = dictInfoEntityList.stream().map(dictInfoEntity -> dictInfoEntity.getDataTable()).collect(Collectors.toList());
            // 删除字典数据
            boolean flag = super.removeByIds(idList);
            // drop 字典数据表
            for (String dataTable : dataTableList) {
                if(dbService.checkTableExists(dataTable)){
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
                dbService.createTable("sys_dict_table" , oldDictInfoEntity.getDataTable(), oldDictInfoEntity.getDictName() + "字典数据表");
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
            // 启用
            String dataTable = dictInfoEntity.getDataTable();
            if (!dbService.checkTableExists(dataTable)) {
                // 物理表不存在时创建字段数据表
                dbService.createTable("sys_dict_table" , dataTable, dictInfoEntity.getDictName() + "字典数据表");
            }
        }
        return Boolean.TRUE;
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
