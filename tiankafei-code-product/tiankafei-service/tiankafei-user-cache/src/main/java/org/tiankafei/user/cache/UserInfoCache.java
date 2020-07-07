package org.tiankafei.user.cache;

import cn.hutool.crypto.SecureUtil;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;
import org.tiankafei.user.cache.enums.UserCacheEnums;
import org.tiankafei.user.vo.SysUserInfoQueryVo;

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
     * 设置用户名空值到缓存当中
     *
     * @param keywords
     */
    public void setUsernameNullValue(String keywords){
        cacheManagerRepository.setCacheObject(keywords, UserCacheEnums.CACHE_NULL_VALUE.getCode(), 30, TimeUnit.MINUTES);
    }

    /**
     * 设置用户信息对象到缓存中
     * @param userInfoQueryVo
     */
    public void setUserInfo(SysUserInfoQueryVo userInfoQueryVo){
        String username = userInfoQueryVo.getUsername();
        String email = userInfoQueryVo.getEmail();
        String telephone = userInfoQueryVo.getTelephone();
        String sha1 = SecureUtil.sha1(username + "-" + email + "-" + telephone);

        cacheManagerRepository.setCacheObject(username, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(email, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(telephone, sha1, 30, TimeUnit.MINUTES);
        cacheManagerRepository.setCacheObject(sha1, userInfoQueryVo, 30, TimeUnit.MINUTES);
    }

}
