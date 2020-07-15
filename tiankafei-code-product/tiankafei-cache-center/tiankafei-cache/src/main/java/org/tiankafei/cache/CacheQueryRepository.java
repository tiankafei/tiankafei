package org.tiankafei.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 获取缓存数据
 *
 * @author tiankafei
 */
public interface CacheQueryRepository extends CacheRepository {

    /**
     * 获取缓存数据对象
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> T getCacheObject(String key);

    /**
     * 获取缓存数据对象
     *
     * @param keys
     * @param <T>
     * @return
     */
    <T> List<T> getCacheObject(Collection<String> keys);

    /**
     * 获取缓存数据对象集合
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> List<T> getCacheList(String key);

    /**
     * 获取缓存数据对象集合
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> Set<T> getCacheSet(String key);

    /**
     * 获取缓存数据对象集合
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> Map<String, T> getCacheMap(String key);

    /**
     * 获取缓存数据对象
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> T getCacheMap(String key, String mapKey);

}
