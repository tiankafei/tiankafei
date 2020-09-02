package org.tiankafei.redis.service;

/**
 * @Author 魏双双
 * @Date 2019/12/27
 * @Version V1.0
 **/
public interface IRedisService {

    /**
     * 判断key是否存在
     *
     * @param key
     * @param <K>
     * @return
     */
    <K> Boolean hasKey(K key);

    /**
     * 删除指定key
     *
     * @param key
     * @param <K>
     * @return
     */
    <K> Boolean delete(K key);

}
