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
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.db.service.DbService;
import org.tiankafei.user.constants.UserConstants;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.mapper.DictInfoMapper;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.exception.UserException;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.utils.SequenceUtil;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统数据字典表 服务实现类
 * </pre>
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

    @Override
    public boolean checkSysDictInfoExists(DictInfoListParam dictInfoListParam) throws Exception {
        return checkSysDictCodeExists(dictInfoListParam.getDictCode());
    }

    private boolean checkSysDictCodeExists(String dictCode) {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(DictInfoEntity::getDictCode, dictCode);
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysDictInfo(DictInfoVo dictInfoVo) throws Exception {
        String dictCode = dictInfoVo.getDictCode();
        if (checkSysDictCodeExists(dictCode)) {
            throw new UserException("字典代码：" + dictCode + " 已经存在！");
        }
        // 生成序列号
        Long id = SequenceUtil.generatorLonId();
        // 保存字典
        DictInfoEntity dictInfoEntity = new DictInfoEntity();
        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
        dictInfoEntity.setStatus(Boolean.FALSE);
        dictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + id);
        super.save(dictInfoEntity);
        return dictInfoEntity.getId();
    }

    @Override
    public boolean addSysDictInfoList(List<DictInfoVo> dictInfoVoList) throws Exception {
        if (dictInfoVoList != null && !dictInfoVoList.isEmpty()) {
            List<DictInfoEntity> sysDictInfoList = new ArrayList<>();
            for (DictInfoVo dictInfoVo : dictInfoVoList) {
                DictInfoEntity dictInfoEntity = new DictInfoEntity();
                BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
                sysDictInfoList.add(dictInfoEntity);
            }
            super.saveBatch(sysDictInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDictInfo(DictInfoVo dictInfoVo) throws Exception {
        DictInfoEntity dictInfoEntity = dictInfoMapper.selectById(dictInfoVo.getId());
        String dictCode = dictInfoVo.getDictCode();
        if (!dictInfoEntity.getDictCode().equals(dictCode)) {
            if (checkSysDictCodeExists(dictCode)) {
                throw new UserException("字典代码：" + dictCode + " 已经存在！");
            }
        }

        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
        return super.updateById(dictInfoEntity);
    }

    @Override
    public boolean enable(String id) throws Exception {
        DictInfoEntity dictInfoEntity = dictInfoMapper.selectById(id);
        dictInfoEntity.setStatus(Boolean.TRUE);
        dictInfoMapper.updateById(dictInfoEntity);

        // 如果表已经存在，则直接返回
        String dataTable = dictInfoEntity.getDataTable();
        if (dbService.checkTableExists(dataTable)) {
            return Boolean.TRUE;
        }

        // 表不存在的时候，创建表结构和索引
        dbService.createTable("sys_dict_table", dataTable, dictInfoEntity.getDictName() + "字典数据表");
        return Boolean.TRUE;
    }

    @Override
    public boolean disable(String id) throws Exception {
        DictInfoEntity dictInfoEntity = dictInfoMapper.selectById(id);
        dictInfoEntity.setStatus(Boolean.FALSE);
        dictInfoMapper.updateById(dictInfoEntity);
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysDictInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        List<String> idList = Arrays.asList(idArray);
        if (CollectionUtils.isNotEmpty(idList)) {
            LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
            // 设置只查询这一列的数据
            lambdaQueryWrapper.select(DictInfoEntity::getDataTable);
            lambdaQueryWrapper.in(DictInfoEntity::getId, idList);
            List<DictInfoEntity> dictInfoEntityList = dictInfoMapper.selectList(lambdaQueryWrapper);
            // 删除字典数据
            super.removeByIds(idList);

            // 删除字段的数据表
            for (int index = 0, length = dictInfoEntityList.size(); index < length; index++) {
                String dataTable = dictInfoEntityList.get(index).getDataTable();
                dbService.dropTable(dataTable);
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysDictInfo(DictInfoListParam dictInfoListParam) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public DictInfoVo getSysDictInfoById(Serializable id) throws Exception {
        //SysDictInfoQueryVo sysDictInfoQueryVo = sysDictInfoMapper.getSysDictInfoById(id);

        DictInfoEntity dictInfoEntity = super.getById(id);
        DictInfoVo dictInfoVo = new DictInfoVo();
        BeanUtils.copyProperties(dictInfoEntity, dictInfoVo);
        return dictInfoVo;
    }

    @Override
    public Paging<DictInfoVo> getSysDictInfoPageList(DictInfoPageParam dictInfoPageParam) throws Exception {
        //IPage<SysDictInfoQueryVo> iPage = sysDictInfoMapper.getSysDictInfoPageList(page, sysDictInfoPageQueryParam);

        Page page = setPageParam(dictInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<DictInfoVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<DictInfoVo> getSysDictInfoList(DictInfoListParam dictInfoListParam) throws Exception {
        List<DictInfoVo> dictInfoVoList = dictInfoMapper.getSysDictInfoList(dictInfoListParam);
        return dictInfoVoList;
    }

    @Override
    public int countSysDictInfo(DictInfoListParam dictInfoListParam) throws Exception {
        LambdaQueryWrapper<DictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}