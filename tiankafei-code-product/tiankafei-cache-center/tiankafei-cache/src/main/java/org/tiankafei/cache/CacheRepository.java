package org.tiankafei.cache;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface CacheRepository {

    /**
     * 批量设置过期时间
     * @param keys
     * @param timeout
     * @param timeUnit
     */
    void batchExpireKey(Collection<String> keys, Integer timeout, TimeUnit timeUnit);

    /**
     * 给key设置过期时间
     *
     * @param key
     * @param timeout
     * @param timeUnit
     */
    void expireKey(String key, Integer timeout, TimeUnit timeUnit);

    /**
     * 获取key集合
     * @param pattern
     * @return
     */
    Collection<String> keys(String pattern);

}
