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
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.mapper.DictInfoMapper;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统数据字典表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class DictInfoServiceImpl extends BaseServiceImpl<DictInfoMapper, DictInfoEntity> implements DictInfoService {

    @Autowired
    private DictInfoMapper dictInfoMapper;


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
        DictInfoEntity dictInfoEntity = new DictInfoEntity();
        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
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
            List<DictInfoEntity> dictInfoEntityList = Lists.newArrayList();
            for (DictInfoVo dictInfoVo : dictInfoVoList) {
                DictInfoEntity dictInfoEntity = new DictInfoEntity();
                BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
                dictInfoEntityList.add(dictInfoEntity);
            }
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
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDictInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
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

        }
        return super.remove(lambdaQueryWrapper);
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
        DictInfoEntity dictInfoEntity = new DictInfoEntity();
        BeanUtils.copyProperties(dictInfoVo, dictInfoEntity);
        return super.updateById(dictInfoEntity);
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
