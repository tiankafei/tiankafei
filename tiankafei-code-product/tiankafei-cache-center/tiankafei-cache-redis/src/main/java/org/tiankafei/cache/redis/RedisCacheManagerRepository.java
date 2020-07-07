package org.tiankafei.cache.redis;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class RedisCacheManagerRepository implements CacheManagerRepository {

    @Autowired
    public RedisTemplate redisTemplate;

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
    public void expireKey(String key, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.expire(key, timeout, timeUnit);
    }

    @Override
    public <T> T getCacheObject(String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    @Override
    public <T> List<T> getCacheList(String key) {
        List<T> dataList = Lists.newArrayList();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();

        Long size = listOperation.size(key);
        for (int index = 0; index < size; index++) {
            dataList.add(listOperation.index(key, index));
        }
        return dataList;
    }

    @Override
    public <T> Set<T> getCacheSet(String key) {
        BoundSetOperations<String, T> operation = redisTemplate.boundSetOps(key);
        Set<T> dataSet = operation.members();
        return dataSet;
    }

    @Override
    public <T> Map<String, T> getCacheMap(String key) {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    @Override
    public <T> T getCacheMap(String key, String mapKey) {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        T t = map.get(mapKey);
        return t;
    }

    @Override
    public void deleteObject(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void deleteObject(Collection keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

}
