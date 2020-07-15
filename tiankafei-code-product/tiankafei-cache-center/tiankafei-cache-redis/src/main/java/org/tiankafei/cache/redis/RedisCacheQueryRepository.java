package org.tiankafei.cache.redis;

import com.google.common.collect.Lists;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheQueryRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class RedisCacheQueryRepository extends RedisCacheRepository implements CacheQueryRepository {

    @Override
    public <T> T getCacheObject(String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    @Override
    public <T> List<T> getCacheObject(Collection<String> keys) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.multiGet(keys);
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

}
