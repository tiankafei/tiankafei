package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysDataDictEntity;
import org.tiankafei.user.mapper.SysDataDictMapper;
import org.tiankafei.user.service.SysDataDictService;
import org.tiankafei.user.param.SysDataDictQueryParam;
import org.tiankafei.user.param.SysDataDictPageQueryParam;
import org.tiankafei.user.vo.SysDataDictQueryVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
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
public class SysDataDictServiceImpl extends BaseServiceImpl<SysDataDictMapper, SysDataDictEntity> implements SysDataDictService {

    @Autowired
    private SysDataDictMapper sysDataDictMapper;

    @Override
    public boolean checkSysDataDictExists(SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        LambdaQueryWrapper<SysDataDictEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object saveSysDataDict(SysDataDictQueryVo sysDataDictQueryVo) throws Exception {
        SysDataDictEntity sysDataDictEntity = new SysDataDictEntity();
        BeanUtils.copyProperties(sysDataDictQueryVo, sysDataDictEntity);
        super.save(sysDataDictEntity);
        return sysDataDictEntity.getId();
    }
        
    @Override
    public boolean saveSysDataDictList(List<SysDataDictQueryVo> sysDataDictQueryVoList) throws Exception {
        if(sysDataDictQueryVoList != null && !sysDataDictQueryVoList.isEmpty()){
            List<SysDataDictEntity> sysDataDictList = new ArrayList<>();
            for ( SysDataDictQueryVo sysDataDictQueryVo : sysDataDictQueryVoList) {
                SysDataDictEntity sysDataDictEntity = new SysDataDictEntity();
                BeanUtils.copyProperties(sysDataDictQueryVo, sysDataDictEntity);
                sysDataDictList.add(sysDataDictEntity);
            }
            super.saveBatch(sysDataDictList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDataDict(SysDataDictQueryVo sysDataDictQueryVo) throws Exception {
        SysDataDictEntity sysDataDictEntity = new SysDataDictEntity();
        BeanUtils.copyProperties(sysDataDictQueryVo, sysDataDictEntity);
        return super.updateById(sysDataDictEntity);
    }

    @Override
    public boolean deleteSysDataDict(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysDataDict(SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        LambdaQueryWrapper <SysDataDictEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysDataDictQueryVo getSysDataDictById(Serializable id) throws Exception {
         SysDataDictEntity sysDataDictEntity = super.getById(id);
         SysDataDictQueryVo sysDataDictQueryVo = new SysDataDictQueryVo();
         BeanUtils.copyProperties(sysDataDictEntity, sysDataDictQueryVo);
        return sysDataDictQueryVo;
    }

    @Override
    public Paging<SysDataDictQueryVo> getSysDataDictPageList(SysDataDictPageQueryParam sysDataDictPageQueryParam) throws Exception {
        Page page = setPageParam(sysDataDictPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysDataDictEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysDataDictQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysDataDictQueryVo> getSysDataDictList(SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        List<SysDataDictQueryVo> sysDataDictQueryVoList = sysDataDictMapper.getSysDataDictList(sysDataDictQueryParam);
        return sysDataDictQueryVoList;
    }
    
    @Override
    public int countSysDataDict(SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        LambdaQueryWrapper <SysDataDictEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}