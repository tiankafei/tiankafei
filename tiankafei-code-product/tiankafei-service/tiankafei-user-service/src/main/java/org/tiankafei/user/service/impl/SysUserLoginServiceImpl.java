package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.user.service.CheckUserInfoExists;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.mapper.SysUserLoginMapper;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
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
public class SysUserLoginServiceImpl extends BaseServiceImpl<SysUserLoginMapper, SysUserLoginEntity> implements SysUserLoginService {

    @Autowired
    private SysUserLoginMapper sysUserLoginMapper;

    @Override
    public boolean checkUsernameExists(String username) throws Exception {
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getUsername, username);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkEmailExists(String email) throws Exception {
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, email);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkTelephoneExists(String telephone) throws Exception {
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getTelephone, telephone);
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkTkfUserLoginExists(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        return checkTkfUserLoginExists(lambdaQueryWrapper);
    }

    /**
     * 验证信息是否存在
     * @param lambdaQueryWrapper
     * @return
     * @throws Exception
     */
    private boolean checkTkfUserLoginExists(LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper) throws Exception {
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object saveTkfUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        checkSaveUserInfoExists(sysUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkSaveUserInfoExists(sysUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkSaveUserInfoExists(sysUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));

        SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
        super.save(sysUserLoginEntity);
        return sysUserLoginEntity.getId();
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
    public boolean saveTkfUserLoginList(List<SysUserLoginQueryVo> sysUserLoginQueryVoList) throws Exception {
        if(sysUserLoginQueryVoList != null && !sysUserLoginQueryVoList.isEmpty()){
            List<SysUserLoginEntity> tkfUserLoginList = new ArrayList<>();
            for ( SysUserLoginQueryVo sysUserLoginQueryVo : sysUserLoginQueryVoList) {
                SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
                BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
                tkfUserLoginList.add(sysUserLoginEntity);
            }
            super.saveBatch(tkfUserLoginList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateTkfUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        SysUserLoginEntity oldUserEntity = super.getById(sysUserLoginQueryVo.getId());
        checkUpdateUserInfoExists(oldUserEntity.getUsername(), sysUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getEmail(), sysUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getTelephone(), sysUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));

        SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
        return super.updateById(sysUserLoginEntity);
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
    public boolean deleteTkfUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysUserLoginQueryVo getTkfUserLoginById(Serializable id) throws Exception {
         SysUserLoginEntity sysUserLoginEntity = super.getById(id);
         SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
         BeanUtils.copyProperties(sysUserLoginEntity, sysUserLoginQueryVo);
        return sysUserLoginQueryVo;
    }

    @Override
    public Paging<SysUserLoginQueryVo> getTkfUserLoginPageList(SysUserLoginPageQueryParam sysUserLoginPageQueryParam) throws Exception {
        Page page = setPageParam(sysUserLoginPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysUserLoginQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysUserLoginQueryVo> getTkfUserLoginList(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        List<SysUserLoginQueryVo> sysUserLoginQueryVoList = sysUserLoginMapper.getTkfUserLoginList(sysUserLoginQueryParam);
        return sysUserLoginQueryVoList;
    }
    
    @Override
    public int countTkfUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}