package org.tiankafei.cache.memory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheQueryRepository;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Repository
public class MemoryCacheQueryRepository extends MemoryCacheRepository implements CacheQueryRepository {

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
