package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.user.service.CheckUserInfoExists;
import org.tiankafei.user.entity.TkfUserLoginEntity;
import org.tiankafei.user.mapper.TkfUserLoginMapper;
import org.tiankafei.user.param.TkfUserLoginPageQueryParam;
import org.tiankafei.user.param.TkfUserLoginQueryParam;
import org.tiankafei.user.service.TkfUserLoginService;
import org.tiankafei.user.vo.TkfUserLoginQueryVo;
import org.tiankafei.web.common.config.CommonWebConfig;
import org.tiankafei.web.common.exception.UserException;
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
        checkSaveUserInfoExists(tkfUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkSaveUserInfoExists(tkfUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkSaveUserInfoExists(tkfUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));

        TkfUserLoginEntity tkfUserLoginEntity = new TkfUserLoginEntity();
        BeanUtils.copyProperties(tkfUserLoginQueryVo, tkfUserLoginEntity);
        super.save(tkfUserLoginEntity);
        return tkfUserLoginEntity.getId();
    }

    /**
     * 新增时校验用户信息是否存在
     * @param str
     * @param message
     * @param checkUserInfoExists
     * @throws Exception
     */
    private void checkSaveUserInfoExists(String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception {
        if(StringUtils.isNotBlank(str)){
            boolean existsFlag = checkUserInfoExists.checkUserInfoExists(str);
            if(existsFlag){
                throw new UserException(message + "已经存在，请重新输入！");
            }
        }
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
        TkfUserLoginEntity oldUserEntity = super.getById(tkfUserLoginQueryVo.getId());
        checkUpdateUserInfoExists(oldUserEntity.getUsername(), tkfUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getEmail(), tkfUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getTelephone(), tkfUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));

        TkfUserLoginEntity tkfUserLoginEntity = new TkfUserLoginEntity();
        BeanUtils.copyProperties(tkfUserLoginQueryVo, tkfUserLoginEntity);
        return super.updateById(tkfUserLoginEntity);
    }

    /**
     * 修改时，校验用户信息是否存在
     * @param oldStr
     * @param str
     * @param message
     * @param checkUserInfoExists
     * @throws Exception
     */
    private void checkUpdateUserInfoExists(String oldStr, String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception {
        boolean emailChangeFlag = Boolean.FALSE;
        if(StringUtils.isNotEmpty(oldStr)){
            emailChangeFlag = !oldStr.equals(str);
        }else if(StringUtils.isNotEmpty(str)){
            emailChangeFlag = !str.equals(oldStr);
        }
        if(emailChangeFlag){
            boolean existsFlag = checkUserInfoExists.checkUserInfoExists(str);
            if(existsFlag){
                throw new UserException(message + "已经存在，请重新输入！");
            }
        }
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