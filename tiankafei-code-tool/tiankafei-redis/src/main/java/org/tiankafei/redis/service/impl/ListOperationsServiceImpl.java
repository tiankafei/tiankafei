package org.tiankafei.redis.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.redis.service.IListOperationsService;

/**
 * @author tiankafei
 */
@Service
public class ListOperationsServiceImpl<K, V> implements IListOperationsService<K, V> {

    @Autowired
    private ListOperations<K, V> listOperations;

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
    public List<V> range(K key, long start, long end) {
        return listOperations.range(key, start, end);
    }

    @Override
    public void trim(K key, long start, long end) {
        listOperations.trim(key, start, end);
    }

    @Override
    public Long size(K key) {
        return listOperations.size(key);
    }

    @Override
    public Long leftPush(K key, V value) {
        return listOperations.leftPush(key, value);
    }

    @Override
    public Long leftPushAll(K key, V... values) {
        return listOperations.leftPushAll(key, values);
    }

    @Override
    public Long leftPushAll(K key, Collection<V> values) {
        return listOperations.leftPushAll(key, values);
    }

    @Override
    public Long leftPushIfPresent(K key, V value) {
        return listOperations.leftPushIfPresent(key, value);
    }

    @Override
    public Long leftPush(K key, V pivot, V value) {
        return listOperations.leftPush(key, pivot, value);
    }

    @Override
    public Long rightPush(K key, V value) {
        return listOperations.rightPush(key, value);
    }

    @Override
    public Long rightPushAll(K key, V... values) {
        return listOperations.rightPushAll(key, values);
    }

    @Override
    public Long rightPushAll(K key, Collection<V> values) {
        return listOperations.rightPushAll(key, values);
    }

    @Override
    public Long rightPushIfPresent(K key, V value) {
        return listOperations.rightPushIfPresent(key, value);
    }

    @Override
    public Long rightPush(K key, V pivot, V value) {
        return listOperations.rightPush(key, pivot, value);
    }

    @Override
    public void set(K key, long index, V value) {
        listOperations.set(key, index, value);
    }

    @Override
    public Long remove(K key, long count, Object value) {
        return listOperations.remove(key, count, value);
    }

    @Override
    public V index(K key, long index) {
        return listOperations.index(key, index);
    }

    @Override
    public V leftPop(K key) {
        return listOperations.leftPop(key);
    }

    @Override
    public V leftPop(K key, long timeout, TimeUnit unit) {
        return listOperations.leftPop(key, timeout, unit);
    }

    @Override
    public V rightPop(K key) {
        return listOperations.rightPop(key);
    }

    @Override
    public V rightPop(K key, long timeout, TimeUnit unit) {
        return listOperations.rightPop(key, timeout, unit);
    }

    @Override
    public V rightPopAndLeftPush(K sourceKey, K destinationKey) {
        return listOperations.rightPopAndLeftPush(sourceKey, destinationKey);
    }

    @Override
    public V rightPopAndLeftPush(K sourceKey, K destinationKey, long timeout, TimeUnit unit) {
        return listOperations.rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
    }

    @Override
    public RedisOperations<K, V> getOperations() {
        return listOperations.getOperations();
    }

}
