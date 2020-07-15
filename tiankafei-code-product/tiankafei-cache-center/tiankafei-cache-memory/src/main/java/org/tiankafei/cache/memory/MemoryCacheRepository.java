package org.tiankafei.cache.memory;

import org.tiankafei.cache.CacheRepository;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class MemoryCacheRepository implements CacheRepository {

    @Override
    public void batchExpireKey(Collection<String> keys, Integer timeout, TimeUnit timeUnit) {

    }

    @Override
    public void expireKey(String key, Integer timeout, TimeUnit timeUnit) {

    }

    @Override
    public Collection<String> keys(String pattern) {
        return null;
    }

}
