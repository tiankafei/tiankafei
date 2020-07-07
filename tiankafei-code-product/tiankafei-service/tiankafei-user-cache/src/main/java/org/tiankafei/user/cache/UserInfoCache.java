package org.tiankafei.user.cache;

import cn.hutool.crypto.SecureUtil;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;
import org.tiankafei.user.cache.enums.UserCacheEnums;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 * 1.对于用户登录场景不需要进行数据预热
 * 2.对于权限比较大的功能用户（能够访问很多个用户的数据时），由于数据库中存的都是用户id，当要显示用户中文名的时候，这种场景只需要把用户详细信息预热即可
 *
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class UserInfoCache {

    @Autowired
    private CacheManagerRepository cacheManagerRepository;

    /**
     * 从缓存中获取用户对象
     * @param keywords
     * @return
     */
    public SysUserInfoQueryVo getUserInfo(String keywords){
        String sha1 = cacheManagerRepository.<String>getCacheObject(keywords);
        if(StringUtils.isNotBlank(sha1)){
            SysUserInfoQueryVo userInfoQueryVo = cacheManagerRepository.<SysUserInfoQueryVo>getCacheObject(sha1);
            return userInfoQueryVo;
        }
        return null;
    }

    /**
     * 再次登录缓存处理
     * @param keywords
     * @return
     */
    public SysUserInfoQueryVo againLoginCacheHandler(String keywords, String passwrod) throws LoginException {
        String sha1 = cacheManagerRepository.<String>getCacheObject(keywords);
        if(StringUtils.isNotBlank(sha1)){
            if(UserCacheEnums.CACHE_NULL_VALUE.getCode().equals(sha1)){
                // 当前用户不存在，
                throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
            }else{
                // 当前用户信息已经放进缓存中了
                SysUserInfoQueryVo userInfoQueryVo = cacheManagerRepository.<SysUserInfoQueryVo>getCacheObject(sha1);
                if(userInfoQueryVo == null){
                    // 如果为空，说明缓存失效了
                    return null;
                }
                // 缓存没有失效
                if(passwrod.equalsIgnoreCase(userInfoQueryVo.getPassword())){
                    // 输入的密码和缓存中的密码再次比对一样
                    return userInfoQueryVo;
                }else{
                    // 用户信息已存在，但是密码输入错误时的处理
                    throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
                }
            }
        }else{
            // 说明当前输入的用户还没有登录过
            return null;
        }
    }

    /**
     * 给不存在的用户设置null值，避免缓存穿透的问题
     * @param keywords
     */
    public void setUserNoExistSaveNullValue(String keywords){
        cacheManagerRepository.setCacheObject(keywords, UserCacheEnums.CACHE_NULL_VALUE.getCode());
    }

    /**
     * 设置用户信息对象到缓存中
     * @param sysUserInfoQueryVo
     */
    public void setSysUserInfoQueryVo(SysUserInfoQueryVo sysUserInfoQueryVo){
        String username = sysUserInfoQueryVo.getUsername();
        String email = sysUserInfoQueryVo.getEmail();
        String telephone = sysUserInfoQueryVo.getTelephone();
        String sha1 = SecureUtil.sha1(username + "-" + email + "-" + telephone);

        cacheManagerRepository.setCacheObject(username, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(email, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(telephone, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(sha1, sysUserInfoQueryVo, 30, TimeUnit.MINUTES);
    }

}
