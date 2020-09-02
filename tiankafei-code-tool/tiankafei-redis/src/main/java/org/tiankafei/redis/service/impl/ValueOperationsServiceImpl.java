package org.tiankafei.redis.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.tiankafei.redis.service.IValueOperationsService;

/**
 * @author tiankafei
 */
@Service
public class ValueOperationsServiceImpl<K, V> implements IValueOperationsService<K, V> {

    @Autowired
    private ValueOperations<K, V> valueOperations;

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
    public void set(K key, V value) {
        valueOperations.set(key, value);
    }

    @Override
    public void set(K key, V value, long timeout, TimeUnit unit) {
        valueOperations.set(key, value, timeout, unit);
    }

    @Override
    public Boolean setIfAbsent(K key, V value) {
        return valueOperations.setIfAbsent(key, value);
    }

    @Override
    public Boolean setIfAbsent(K key, V value, long timeout, TimeUnit unit) {
        return valueOperations.setIfAbsent(key, value, timeout, unit);
    }

    @Override
    public Boolean setIfPresent(K key, V value) {
        return valueOperations.setIfPresent(key, value);
    }

    @Override
    public Boolean setIfPresent(K key, V value, long timeout, TimeUnit unit) {
        return valueOperations.setIfPresent(key, value, timeout, unit);
    }

    @Override
    public void multiSet(Map<? extends K, ? extends V> map) {
        valueOperations.multiSet(map);
    }

    @Override
    public Boolean multiSetIfAbsent(Map<? extends K, ? extends V> map) {
        return valueOperations.multiSetIfAbsent(map);
    }

    @Override
    public V get(Object key) {
        return valueOperations.get(key);
    }

    @Override
    public V getAndSet(K key, V value) {
        return valueOperations.getAndSet(key, value);
    }

    @Override
    public List<V> multiGet(Collection<K> keys) {
        return valueOperations.multiGet(keys);
    }

    @Override
    public Long increment(K key) {
        return valueOperations.increment(key);
    }

    @Override
    public Long increment(K key, long delta) {
        return valueOperations.increment(key, delta);
    }

    @Override
    public Double increment(K key, double delta) {
        return valueOperations.increment(key, delta);
    }

    @Override
    public Long decrement(K key) {
        return valueOperations.decrement(key);
    }

    @Override
    public Long decrement(K key, long delta) {
        return valueOperations.decrement(key, delta);
    }

    @Override
    public Integer append(K key, String value) {
        return valueOperations.append(key, value);
    }

    @Override
    public String get(K key, long start, long end) {
        return valueOperations.get(key, start, end);
    }

    @Override
    public void set(K key, V value, long offset) {
        valueOperations.set(key, value, offset);
    }

    @Override
    public Long size(K key) {
        return valueOperations.size(key);
    }

    @Override
    public Boolean setBit(K key, long offset, boolean value) {
        return valueOperations.setBit(key, offset, value);
    }

    @Override
    public Boolean getBit(K key, long offset) {
        return valueOperations.getBit(key, offset);
    }

    @Override
    public List<Long> bitField(K key, BitFieldSubCommands subCommands) {
        return valueOperations.bitField(key, subCommands);
    }

    @Override
    public RedisOperations<K, V> getOperations() {
        return valueOperations.getOperations();
    }
}
