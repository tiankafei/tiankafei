package org.tiankafei.cache.redis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class RedisCacheManagerRepository extends RedisCacheRepository implements CacheManagerRepository {

    @Override
    public <T> void setCacheObject(String key, T value) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    @Override
    public <T> void setCacheObject(Map<String, T> map) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.multiSet(map);
    }

    @Override
    public <T> void setCacheList(String key, List<T> dataList) {
        ListOperations listOperations = redisTemplate.opsForList();
        if (CollectionUtils.isNotEmpty(dataList)) {
            dataList.stream().forEach(t -> listOperations.rightPush(key, t));
        }
    }

    @Override
    public <T> void setCacheSet(String key, Set<T> dataSet) {
        BoundSetOperations<String, T> boundSetOperations = redisTemplate.boundSetOps(key);
        if (CollectionUtils.isNotEmpty(dataSet)) {
            dataSet.stream().forEach(t -> boundSetOperations.add(t));
        }
    }

    @Override
    public <T> void setCacheMap(String key, Map<String, T> dataMap) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (dataMap != null && !dataMap.isEmpty()) {
            Set<Map.Entry<String, T>> entries = dataMap.entrySet();
            for (Map.Entry<String, T> entry : entries) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public <T> void setCacheMap(String key, String mapKey, T value) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, mapKey, value);
    }

    @Override
    public <T> void setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, timeout, timeUnit);
    }

    @Override
    public void deleteObject(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void deleteObject(Collection keys) {
        redisTemplate.delete(keys);
    }

}
