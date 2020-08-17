package org.tiankafei.cache.memory;

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
public class MemoryCacheQueryRepository extends BaseMemoryCacheRepository implements CacheQueryRepository {

    @Override
    public <T> T getCacheObject(String key) {
        return null;
    }

    @Override
    public <T> List<T> getCacheObject(Collection<String> keys) {
        return null;
    }

    @Override
    public <T> List<T> getCacheList(String key) {
        return null;
    }

    @Override
    public <T> Set<T> getCacheSet(String key) {
        return null;
    }

    @Override
    public <T> Map<String, T> getCacheMap(String key) {
        return null;
    }

    @Override
    public <T> T getCacheMap(String key, String mapKey) {
        return null;
    }

}
