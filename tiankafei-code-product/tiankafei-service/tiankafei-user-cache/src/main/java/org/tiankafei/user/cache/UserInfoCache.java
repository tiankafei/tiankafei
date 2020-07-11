package org.tiankafei.user.cache;

import cn.hutool.crypto.SecureUtil;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;
import org.tiankafei.cache.CacheQueryRepository;
import org.tiankafei.user.cache.enums.UserCacheEnums;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.web.common.config.TokenConfig;
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

    @Autowired
    private CacheQueryRepository cacheQueryRepository;

    @Autowired
    private TokenConfig tokenConfig;

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId(){
        return getUserId(tokenConfig.getToken());
    }

    /**
     * 获取用户ID
     * @param token
     * @return
     */
    public Long getUserId(String token){
        SysUserInfoQueryVo userInfo = getUserInfo(token);
        if(userInfo != null){
            return userInfo.getId();
        }
        return null;
    }

    /**
     * 获取用户昵称
     * @return
     */
    public String getUserNickname(){
        return getUserNickname(tokenConfig.getToken());
    }

    /**
     * 获取用户昵称
     * @param token
     * @return
     */
    public String getUserNickname(String token){
        SysUserInfoQueryVo userInfo = getUserInfo(token);
        if(userInfo != null){
            return userInfo.getNickname();
        }
        return null;
    }

    /**
     * 根据用户名获取缓存的用户信息
     * @return
     */
    public SysUserInfoQueryVo getUserInfo(){
        return getUserInfo(tokenConfig.getToken());
    }

    /**
     * 根据用户名获取缓存的用户信息
     * @param token
     * @return
     */
    public SysUserInfoQueryVo getUserInfo(String token){
        String sha1 = cacheQueryRepository.<String>getCacheObject(token);
        if(StringUtils.isNotBlank(sha1)){
            if(!UserCacheEnums.CACHE_NULL_VALUE.getCode().equals(sha1)){
                SysUserInfoQueryVo userInfoQueryVo = cacheQueryRepository.<SysUserInfoQueryVo>getCacheObject(sha1);
                if(userInfoQueryVo != null){
                    // 每调用一次该方法，就延长一次时间
                    setUserInfoExtendTime(userInfoQueryVo, token);
                }
                return userInfoQueryVo;
            }
        }
        return null;
    }

    /**
     * 登录时调用从缓存中验证该登录用户是否存在，
     *      1.缓存存在，但是值是写死的固定值，则说明该用户不存在，则直接抛出异常即可
     *      2.缓存存在，值就是用户数据本身，则直接返回即可
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    public SysUserInfoQueryVo getUserInfo(String keywords, String password) throws LoginException {
        String sha1 = cacheQueryRepository.<String>getCacheObject(keywords);
        if(StringUtils.isNotBlank(sha1)){
            // 该用户名输入过
            if(UserCacheEnums.CACHE_NULL_VALUE.getCode().equals(sha1)){
                // 该用户名不存在时，在缓存中放置一个空值
                throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
            }else{
                SysUserInfoQueryVo userInfoQueryVo = cacheQueryRepository.<SysUserInfoQueryVo>getCacheObject(sha1);
                if(userInfoQueryVo != null){
                    String cachePassword = userInfoQueryVo.getUserLoginQueryVo().getPassword();
                    // 密码加密后和缓存中的密码进行校验
                    if(cachePassword.equalsIgnoreCase(SecureUtil.md5(password))){
                        // 比对密码是否匹配
                        return userInfoQueryVo;
                    }else{
                        // 密码输入错误
                        throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
                    }
                }
                // 等于空，可能过了超时时间，值被清空了
            }
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
     * 设置验证码，有效期5分钟
     * @param key
     * @param value
     */
    public void setCaptchaCode(String key, String value){
        cacheManagerRepository.setCacheObject(key, value, 5, TimeUnit.MINUTES);
    }

    /**
     * 从缓存当中获取验证码
     * @param key
     * @return
     */
    public String getCaptchaCode(String key){
        return cacheQueryRepository.<String>getCacheObject(key);
    }

    /**
     * 设置用户信息对象到缓存中
     *
     * @param userInfoQueryVo
     * @param token
     */
    public void setUserInfo(SysUserInfoQueryVo userInfoQueryVo, String token){
        String username = userInfoQueryVo.getUsername();
        String email = userInfoQueryVo.getEmail();
        String telephone = userInfoQueryVo.getTelephone();
        String sha1 = SecureUtil.sha1(username + "-" + email + "-" + telephone);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put(username, sha1);
        dataMap.put(email, sha1);
        dataMap.put(telephone, sha1);
        dataMap.put(token, sha1);
        dataMap.put(sha1, userInfoQueryVo);
        // 批量设置缓存
        cacheManagerRepository.setCacheObject(dataMap);
        // 设置过期时间
        setUserInfoExtendTime(username, email, telephone, token, sha1);
    }

    /**
     * 延长过期时间
     * @param username
     * @param email
     * @param telephone
     * @param sha1
     */
    private void setUserInfoExtendTime(String username, String email, String telephone, String token, String sha1){
        // 延长过期时间
        cacheManagerRepository.batchExpireKey(Arrays.asList(username, email, telephone, token, sha1), 30, TimeUnit.MINUTES);;
    }

    /**
     * 设置用户信息过期时间
     * @param userInfoQueryVo
     */
    private void setUserInfoExtendTime(SysUserInfoQueryVo userInfoQueryVo, String token){
        String username = userInfoQueryVo.getUsername();
        String email = userInfoQueryVo.getEmail();
        String telephone = userInfoQueryVo.getTelephone();
        String sha1 = SecureUtil.sha1(username + "-" + email + "-" + telephone);
        // 延长过期时间
        setUserInfoExtendTime(username, email, telephone, token, sha1);
    }

    /**
     * 删除指定的key
     * @param key
     */
    public void removeKey(String key){
        cacheManagerRepository.deleteObject(key);
    }

}
