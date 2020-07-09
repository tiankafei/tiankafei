package org.tiankafei.cache.redis;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.tiankafei.cache.CacheRepository;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class RedisCacheRepository implements CacheRepository {

    @Autowired
    protected RedisTemplate redisTemplate;

    @Override
    public void batchExpireKey(Collection<String> keys, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.executePipelined((RedisCallback<?>) connection -> {
            keys.stream().forEach(key -> {
                connection.expire(key.getBytes(), timeUnit.toSeconds(timeout));
            });
            return null;
        });
    }

    @Override
    public void expireKey(String key, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.expire(key, timeout, timeUnit);
    }

    @Override
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

}
