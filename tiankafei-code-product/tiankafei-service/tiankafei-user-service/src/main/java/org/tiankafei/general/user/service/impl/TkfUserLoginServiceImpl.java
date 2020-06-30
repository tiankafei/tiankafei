package org.tiankafei.general.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.config.CommonWebConfig;
import org.tiankafei.general.user.entity.TkfUserLoginEntity;
import org.tiankafei.general.user.mapper.TkfUserLoginMapper;
import org.tiankafei.general.user.service.TkfUserLoginService;
import org.tiankafei.general.user.param.TkfUserLoginQueryParam;
import org.tiankafei.general.user.param.TkfUserLoginPageQueryParam;
import org.tiankafei.general.user.vo.TkfUserLoginQueryVo;
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
 * 用户登录信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TkfUserLoginServiceImpl extends BaseServiceImpl<TkfUserLoginMapper, TkfUserLoginEntity> implements TkfUserLoginService {

    @Autowired
    private TkfUserLoginMapper tkfUserLoginMapper;

    @Override
    public boolean checkUsernameExists(String username) throws Exception {
        LambdaQueryWrapper<TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(TkfUserLoginEntity::getUsername, username);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkEmailExists(String email) throws Exception {
        LambdaQueryWrapper<TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(TkfUserLoginEntity::getEmail, email);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkTelephoneExists(String telephone) throws Exception {
        LambdaQueryWrapper<TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(TkfUserLoginEntity::getTelephone, telephone);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkTkfUserLoginExists(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper<TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    /**
     * 验证信息是否存在
     * @param lambdaQueryWrapper
     * @return
     * @throws Exception
     */
    private boolean checkTkfUserLoginExists(LambdaQueryWrapper<TkfUserLoginEntity> lambdaQueryWrapper) throws Exception {
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object saveTkfUserLogin(TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception {
        TkfUserLoginEntity tkfUserLoginEntity = new TkfUserLoginEntity();
        BeanUtils.copyProperties(tkfUserLoginQueryVo, tkfUserLoginEntity);
        super.save(tkfUserLoginEntity);
        return tkfUserLoginEntity.getId();
    }
        
    @Override
    public boolean saveTkfUserLoginList(List<TkfUserLoginQueryVo> tkfUserLoginQueryVoList) throws Exception {
        if(tkfUserLoginQueryVoList != null && !tkfUserLoginQueryVoList.isEmpty()){
            List<TkfUserLoginEntity> tkfUserLoginList = new ArrayList<>();
            for ( TkfUserLoginQueryVo tkfUserLoginQueryVo : tkfUserLoginQueryVoList) {
                TkfUserLoginEntity tkfUserLoginEntity = new TkfUserLoginEntity();
                BeanUtils.copyProperties(tkfUserLoginQueryVo, tkfUserLoginEntity);
                tkfUserLoginList.add(tkfUserLoginEntity);
            }
            super.saveBatch(tkfUserLoginList, CommonWebConfig.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateTkfUserLogin(TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception {
        TkfUserLoginEntity tkfUserLoginEntity = new TkfUserLoginEntity();
        BeanUtils.copyProperties(tkfUserLoginQueryVo, tkfUserLoginEntity);
        return super.updateById(tkfUserLoginEntity);
    }

    @Override
    public boolean deleteTkfUserLogin(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteTkfUserLogin(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public TkfUserLoginQueryVo getTkfUserLoginById(Serializable id) throws Exception {
         TkfUserLoginEntity tkfUserLoginEntity = super.getById(id);
         TkfUserLoginQueryVo tkfUserLoginQueryVo = new TkfUserLoginQueryVo();
         BeanUtils.copyProperties(tkfUserLoginEntity, tkfUserLoginQueryVo);
        return tkfUserLoginQueryVo;
    }

    @Override
    public Paging<TkfUserLoginQueryVo> getTkfUserLoginPageList(TkfUserLoginPageQueryParam tkfUserLoginPageQueryParam) throws Exception {
        Page page = setPageParam(tkfUserLoginPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<TkfUserLoginQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<TkfUserLoginQueryVo> getTkfUserLoginList( TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        List<TkfUserLoginQueryVo> tkfUserLoginQueryVoList = tkfUserLoginMapper.getTkfUserLoginList(tkfUserLoginQueryParam);
        return tkfUserLoginQueryVoList;
    }
    
    @Override
    public int countTkfUserLogin(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <TkfUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}