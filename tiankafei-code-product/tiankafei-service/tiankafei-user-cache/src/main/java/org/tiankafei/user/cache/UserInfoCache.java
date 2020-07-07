package org.tiankafei.user.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;
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
     * 从缓存中获取用户信息对象
     * @param username
     * @return
     */
    public SysUserInfoQueryVo getSysUserInfoQueryVo(String username){


        return null;
    }

    /**
     * 设置用户信息对象到缓存中
     * @param username
     * @param sysUserInfoQueryVo
     */
    public void setSysUserInfoQueryVo(String username, SysUserInfoQueryVo sysUserInfoQueryVo){

    }

}
