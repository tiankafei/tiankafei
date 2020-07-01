package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.user.constants.UserConstants;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysDictInfoEntity;
import org.tiankafei.user.mapper.SysDictInfoMapper;
import org.tiankafei.user.service.SysDictInfoService;
import org.tiankafei.user.param.SysDictInfoQueryParam;
import org.tiankafei.user.param.SysDictInfoPageQueryParam;
import org.tiankafei.user.vo.SysDictInfoQueryVo;
import org.tiankafei.web.common.exception.UserException;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.utils.SequenceUtil;
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
 * 系统数据字典表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDictInfoServiceImpl extends BaseServiceImpl<SysDictInfoMapper, SysDictInfoEntity> implements SysDictInfoService {

    @Autowired
    private SysDictInfoMapper sysDictInfoMapper;

    @Override
    public boolean checkSysDictInfoExists(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        return checkSysDictCodeExists(sysDictInfoQueryParam.getDictCode());
    }

    private boolean checkSysDictCodeExists(String dictCode){
        LambdaQueryWrapper<SysDictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysDictInfoEntity::getDictCode, dictCode);
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysDictInfo(SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception {
        String dictCode = sysDictInfoQueryVo.getDictCode();
        if(checkSysDictCodeExists(dictCode)){
            throw new UserException("字典代码：" + dictCode + " 已经存在！");
        }
        // 生成序列号
        Long id = SequenceUtil.generatorLonId();
        // 保存字典
        SysDictInfoEntity sysDictInfoEntity = new SysDictInfoEntity();
        BeanUtils.copyProperties(sysDictInfoQueryVo, sysDictInfoEntity);
        sysDictInfoEntity.setStatus(Boolean.FALSE);
        sysDictInfoEntity.setDataTable(UserConstants.DICT_DATA_TABLE_PREFIX + id);
        super.save(sysDictInfoEntity);
        return sysDictInfoEntity.getId();
    }
        
    @Override
    public boolean addSysDictInfoList(List<SysDictInfoQueryVo> sysDictInfoQueryVoList) throws Exception {
        if(sysDictInfoQueryVoList != null && !sysDictInfoQueryVoList.isEmpty()){
            List<SysDictInfoEntity> sysDictInfoList = new ArrayList<>();
            for ( SysDictInfoQueryVo sysDictInfoQueryVo : sysDictInfoQueryVoList) {
                SysDictInfoEntity sysDictInfoEntity = new SysDictInfoEntity();
                BeanUtils.copyProperties(sysDictInfoQueryVo, sysDictInfoEntity);
                sysDictInfoList.add(sysDictInfoEntity);
            }
            super.saveBatch(sysDictInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDictInfo(SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception {
        SysDictInfoEntity sysDictInfoEntity = sysDictInfoMapper.selectById(sysDictInfoQueryVo.getId());
        String dictCode = sysDictInfoQueryVo.getDictCode();
        if(!sysDictInfoEntity.getDictCode().equals(dictCode)){
            if(checkSysDictCodeExists(dictCode)){
                throw new UserException("字典代码：" + dictCode + " 已经存在！");
            }
        }

        BeanUtils.copyProperties(sysDictInfoQueryVo, sysDictInfoEntity);
        return super.updateById(sysDictInfoEntity);
    }

    @Override
    public boolean deleteSysDictInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysDictInfo(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysDictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysDictInfoQueryVo getSysDictInfoById(Serializable id) throws Exception {
         SysDictInfoEntity sysDictInfoEntity = super.getById(id);
         SysDictInfoQueryVo sysDictInfoQueryVo = new SysDictInfoQueryVo();
         BeanUtils.copyProperties(sysDictInfoEntity, sysDictInfoQueryVo);
        return sysDictInfoQueryVo;
    }

    @Override
    public Paging<SysDictInfoQueryVo> getSysDictInfoPageList(SysDictInfoPageQueryParam sysDictInfoPageQueryParam) throws Exception {
        Page page = setPageParam(sysDictInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysDictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysDictInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysDictInfoQueryVo> getSysDictInfoList(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        List<SysDictInfoQueryVo> sysDictInfoQueryVoList = sysDictInfoMapper.getSysDictInfoList(sysDictInfoQueryParam);
        return sysDictInfoQueryVoList;
    }
    
    @Override
    public int countSysDictInfo(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysDictInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}