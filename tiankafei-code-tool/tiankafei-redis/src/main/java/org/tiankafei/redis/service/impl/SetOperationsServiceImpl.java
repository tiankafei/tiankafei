package org.tiankafei.redis.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.tiankafei.redis.service.ISetOperationsService;

/**
 * @author tiankafei
 */
@Service
public class SetOperationsServiceImpl<K, V> implements ISetOperationsService<K, V> {

    @Autowired
    private SetOperations<K, V> setOperations;

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
    public Long add(K key, V... values) {
        return setOperations.add(key, values);
    }

    @Override
    public Long remove(K key, Object... values) {
        return setOperations.remove(key, values);
    }

    @Override
    public V pop(K key) {
        return setOperations.pop(key);
    }

    @Override
    public List<V> pop(K key, long count) {
        return setOperations.pop(key, count);
    }

    @Override
    public Boolean move(K key, V value, K destKey) {
        return setOperations.move(key, value, destKey);
    }

    @Override
    public Long size(K key) {
        return setOperations.size(key);
    }

    @Override
    public Boolean isMember(K key, Object o) {
        return setOperations.isMember(key, o);
    }

    @Override
    public Set<V> intersect(K key, K otherKey) {
        return setOperations.intersect(key, otherKey);
    }

    @Override
    public Set<V> intersect(K key, Collection<K> otherKeys) {
        return setOperations.intersect(key, otherKeys);
    }

    @Override
    public Long intersectAndStore(K key, K otherKey, K destKey) {
        return setOperations.intersectAndStore(key, otherKey, destKey);
    }

    @Override
    public Long intersectAndStore(K key, Collection<K> otherKeys, K destKey) {
        return setOperations.intersectAndStore(key, otherKeys, destKey);
    }

    @Override
    public Set<V> union(K key, K otherKey) {
        return setOperations.union(key, otherKey);
    }

    @Override
    public Set<V> union(K key, Collection<K> otherKeys) {
        return setOperations.union(key, otherKeys);
    }

    @Override
    public Long unionAndStore(K key, K otherKey, K destKey) {
        return setOperations.unionAndStore(key, otherKey, destKey);
    }

    @Override
    public Long unionAndStore(K key, Collection<K> otherKeys, K destKey) {
        return setOperations.unionAndStore(key, otherKeys, destKey);
    }

    @Override
    public Set<V> difference(K key, K otherKey) {
        return setOperations.difference(key, otherKey);
    }

    @Override
    public Set<V> difference(K key, Collection<K> otherKeys) {
        return setOperations.difference(key, otherKeys);
    }

    @Override
    public Long differenceAndStore(K key, K otherKey, K destKey) {
        return setOperations.differenceAndStore(key, otherKey, destKey);
    }

    @Override
    public Long differenceAndStore(K key, Collection<K> otherKeys, K destKey) {
        return setOperations.differenceAndStore(key, otherKeys, destKey);
    }

    @Override
    public Set<V> members(K key) {
        return setOperations.members(key);
    }

    @Override
    public V randomMember(K key) {
        return setOperations.randomMember(key);
    }

    @Override
    public Set<V> distinctRandomMembers(K key, long count) {
        return setOperations.distinctRandomMembers(key, count);
    }

    @Override
    public List<V> randomMembers(K key, long count) {
        return setOperations.randomMembers(key, count);
    }

    @Override
    public Cursor<V> scan(K key, ScanOptions options) {
        return setOperations.scan(key, options);
    }

    @Override
    public RedisOperations<K, V> getOperations() {
        return setOperations.getOperations();
    }
}
