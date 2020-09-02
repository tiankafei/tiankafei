package org.tiankafei.redis.config;

import javax.annotation.Resource;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

/**
 * <p>Description: </p>
 * <p>Copyright: </p>
 * <p>Company: www.tiankafei.net</p>
 *
 * @author tiankafei
 * @date 2018-11-18 10:10
 */
@Configuration
@EnableCaching
public class TiankafeiRedisConfig {

    @Resource
    private RedisTemplate redisTemplate;

    @Bean
    public HashOperations opsForHash() {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ListOperations opsForList() {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations opsForSet() {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ValueOperations opsForValue() {
        return redisTemplate.opsForValue();
    }

    @Bean
    public ZSetOperations opsForZSet() {
        return redisTemplate.opsForZSet();
    }

    @Bean
    public ClusterOperations opsForCluster() {
        return redisTemplate.opsForCluster();
    }

    @Bean
    public GeoOperations opsForGeo() {
        return redisTemplate.opsForGeo();
    }

    @Bean
    public HyperLogLogOperations opsForHyperLogLog() {
        return redisTemplate.opsForHyperLogLog();
    }

}
