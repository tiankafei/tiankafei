package org.tiankafei.user.cache.enums;

/**
 * @author 魏双双
 * @since 1.0
 **/
public enum UserCacheEnums {

    // 用户不存在时，往缓存中存储的key的值，用来避免缓存穿透的问题（当同样的用户名再次登录，则会直接返回错误消息）
    CACHE_NULL_VALUE("CACHE_NULL_VALUE"),
    LOGIN_ERROR("您输入的用户名或密码不正确，请重新输入！"),
    ;

    private String code;

    UserCacheEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
