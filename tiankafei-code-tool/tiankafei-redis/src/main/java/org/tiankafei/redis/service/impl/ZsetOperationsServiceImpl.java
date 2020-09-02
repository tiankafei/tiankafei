package org.tiankafei.redis.service.impl;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.tiankafei.redis.service.IZsetOperationsService;

/**
 * @author tiankafei
 */
@Service
public class ZsetOperationsServiceImpl<K, V> implements IZsetOperationsService<K, V> {

    @Autowired
    private ZSetOperations<K, V> zSetOperations;

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
    public Boolean add(K key, V value, double score) {
        return zSetOperations.add(key, value, score);
    }

    @Override
    public Long add(K key, Set<ZSetOperations.TypedTuple<V>> typedTuples) {
        return zSetOperations.add(key, typedTuples);
    }

    @Override
    public Long remove(K key, Object... values) {
        return zSetOperations.remove(key, values);
    }

    @Override
    public Double incrementScore(K key, V value, double delta) {
        return zSetOperations.incrementScore(key, value, delta);
    }

    @Override
    public Long rank(K key, Object o) {
        return zSetOperations.rank(key, o);
    }

    @Override
    public Long reverseRank(K key, Object o) {
        return zSetOperations.reverseRank(key, o);
    }

    @Override
    public Set<V> range(K key, long start, long end) {
        return zSetOperations.range(key, start, end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> rangeWithScores(K key, long start, long end) {
        return zSetOperations.rangeWithScores(key, start, end);
    }

    @Override
    public Set<V> rangeByScore(K key, double min, double max) {
        return zSetOperations.rangeByScore(key, min, max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> rangeByScoreWithScores(K key, double min, double max) {
        return zSetOperations.rangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<V> rangeByScore(K key, double min, double max, long offset, long count) {
        return zSetOperations.rangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> rangeByScoreWithScores(K key, double min, double max, long offset, long count) {
        return zSetOperations.rangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<V> reverseRange(K key, long start, long end) {
        return zSetOperations.reverseRange(key, start, end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> reverseRangeWithScores(K key, long start, long end) {
        return zSetOperations.reverseRangeWithScores(key, start, end);
    }

    @Override
    public Set<V> reverseRangeByScore(K key, double min, double max) {
        return zSetOperations.reverseRangeByScore(key, min, max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> reverseRangeByScoreWithScores(K key, double min, double max) {
        return zSetOperations.reverseRangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<V> reverseRangeByScore(K key, double min, double max, long offset, long count) {
        return zSetOperations.reverseRangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<V>> reverseRangeByScoreWithScores(K key, double min, double max, long offset, long count) {
        return zSetOperations.reverseRangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Long count(K key, double min, double max) {
        return zSetOperations.count(key, min, max);
    }

    @Override
    public Long size(K key) {
        return zSetOperations.size(key);
    }

    @Override
    public Long zCard(K key) {
        return zSetOperations.zCard(key);
    }

    @Override
    public Double score(K key, Object o) {
        return zSetOperations.score(key, o);
    }

    @Override
    public Long removeRange(K key, long start, long end) {
        return zSetOperations.removeRange(key, start, end);
    }

    @Override
    public Long removeRangeByScore(K key, double min, double max) {
        return zSetOperations.removeRangeByScore(key, min, max);
    }

    @Override
    public Long unionAndStore(K key, K otherKey, K destKey) {
        return zSetOperations.unionAndStore(key, otherKey, destKey);
    }

    @Override
    public Long unionAndStore(K key, Collection<K> otherKeys, K destKey) {
        return zSetOperations.unionAndStore(key, otherKeys, destKey);
    }

    @Override
    public Long unionAndStore(K key, Collection<K> otherKeys, K destKey, RedisZSetCommands.Aggregate aggregate, RedisZSetCommands.Weights weights) {
        return zSetOperations.unionAndStore(key, otherKeys, destKey, aggregate, weights);
    }

    @Override
    public Long intersectAndStore(K key, K otherKey, K destKey) {
        return zSetOperations.intersectAndStore(key, otherKey, destKey);
    }

    @Override
    public Long intersectAndStore(K key, Collection<K> otherKeys, K destKey) {
        return zSetOperations.intersectAndStore(key, otherKeys, destKey);
    }

    @Override
    public Long intersectAndStore(K key, Collection<K> otherKeys, K destKey, RedisZSetCommands.Aggregate aggregate, RedisZSetCommands.Weights weights) {
        return zSetOperations.intersectAndStore(key, otherKeys, destKey, aggregate, weights);
    }

    @Override
    public Set<V> rangeByLex(K key, RedisZSetCommands.Range range) {
        return zSetOperations.rangeByLex(key, range);
    }

    @Override
    public Set<V> rangeByLex(K key, RedisZSetCommands.Range range, RedisZSetCommands.Limit limit) {
        return zSetOperations.rangeByLex(key, range, limit);
    }

    @Override
    public RedisOperations<K, V> getOperations() {
        return zSetOperations.getOperations();
    }
}
