package org.tiankafei.redis.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;
import org.tiankafei.redis.service.IHashOperationsService;

/**
 * @author tiankafei
 */
@Service
public class HashOperationsServiceImpl<H, HK, HV> implements IHashOperationsService<H, HK, HV> {

    @Autowired
    private HashOperations<H, HK, HV> hashOperations;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public <K> Boolean hasKey(K key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public <K> Boolean delete(K key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long delete(H key, Object... hashKeys) {
        return hashOperations.delete(key, hashKeys);
    }

    @Override
    public Boolean hasKey(H key, Object hashKey) {
        return hashOperations.hasKey(key, hashKey);
    }

    @Override
    public HV get(H key, Object hashKey) {
        return hashOperations.get(key, hashKey);
    }

    @Override
    public List<HV> multiGet(H key, Collection<HK> hashKeys) {
        return hashOperations.multiGet(key, hashKeys);
    }

    @Override
    public Long increment(H key, HK hashKey, long delta) {
        return hashOperations.increment(key, hashKey, delta);
    }

    @Override
    public Double increment(H key, HK hashKey, double delta) {
        return hashOperations.increment(key, hashKey, delta);
    }

    @Override
    public Set<HK> keys(H key) {
        return hashOperations.keys(key);
    }

    @Override
    public Long lengthOfValue(H key, HK hashKey) {
        return hashOperations.lengthOfValue(key, hashKey);
    }

    @Override
    public Long size(H key) {
        return hashOperations.size(key);
    }

    @Override
    public void putAll(H key, Map<? extends HK, ? extends HV> m) {
        hashOperations.putAll(key, m);
    }

    @Override
    public void put(H key, HK hashKey, HV value) {
        hashOperations.put(key, hashKey, value);
    }

    @Override
    public Boolean putIfAbsent(H key, HK hashKey, HV value) {
        return hashOperations.putIfAbsent(key, hashKey, value);
    }

    @Override
    public List<HV> values(H key) {
        return hashOperations.values(key);
    }

    @Override
    public Map<HK, HV> entries(H key) {
        return hashOperations.entries(key);
    }

    @Override
    public Cursor<Map.Entry<HK, HV>> scan(H key, ScanOptions options) {
        return hashOperations.scan(key, options);
    }

    @Override
    public RedisOperations<H, ?> getOperations() {
        return hashOperations.getOperations();
    }

}
