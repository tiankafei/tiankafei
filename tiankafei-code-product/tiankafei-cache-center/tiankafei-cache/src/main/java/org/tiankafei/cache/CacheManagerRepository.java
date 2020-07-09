package org.tiankafei.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 获取缓存数据
 *
 * @author tiankafei
 */
public interface CacheManagerRepository extends CacheRepository {

    /**
     * 设置缓存数据对象
     *
     * @param key   缓存的key值
     * @param value 缓存数据对象
     * @param <T>
     */
    <T> void setCacheObject(String key, T value);

    /**
     * 设置缓存数据
     *
     * @param map
     * @param <T>
     */
    <T> void setCacheObject(Map<String, T> map);

    /**
     * 设置缓存
     *
     * @param key       缓存的key值
     * @param dataList  缓存数据对象集合
     * @param <T>
     */
    <T> void setCacheList(String key, List<T> dataList);

    /**
     * 设置缓存
     *
     * @param key       缓存的key值
     * @param dataSet   缓存数据对象集合
     * @param <T>
     */
    <T> void setCacheSet(String key, Set<T> dataSet);

    /**
     * 设置缓存
     *
     * @param key       缓存的key值
     * @param dataMap   缓存数据对象集合
     * @param <T>
     */
    <T> void setCacheMap(String key, Map<String, T> dataMap);

    /**
     * 设置缓存
     *
     * @param key       缓存的key值
     * @param mapKey    缓存map的key
     * @param value     缓存map的值
     * @param <T>
     */
    <T> void setCacheMap(String key, String mapKey, T value);

    /**
     * 设置缓存
     *
     * @param key   缓存的key值
     * @param value 缓存数据对象
     * @param timeout   缓存失效时间
     * @param timeUnit  缓存失效的时间单位
     * @param <T>
     */
    <T> void setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit);

    /**
     * 删除缓存数据
     * @param key
     */
    void deleteObject(String key);

    /**
     * 批量根据传入的keys删除缓存数据
     * @param keys
     */
    void deleteObject(Collection keys);

}
