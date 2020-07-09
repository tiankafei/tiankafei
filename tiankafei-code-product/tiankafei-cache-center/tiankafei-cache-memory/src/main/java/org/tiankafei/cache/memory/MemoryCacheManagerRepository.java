package org.tiankafei.cache.memory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class MemoryCacheManagerRepository extends MemoryCacheRepository implements CacheManagerRepository {

    @Override
    public <T> void setCacheObject(String key, T value) {

    }

    @Override
    public <T> void setCacheObject(Map<String, T> map) {

    }

    @Override
    public <T> void setCacheList(String key, List<T> dataList) {

    }

    @Override
    public <T> void setCacheSet(String key, Set<T> dataSet) {

    }

    @Override
    public <T> void setCacheMap(String key, Map<String, T> dataMap) {

    }

    @Override
    public <T> void setCacheMap(String key, String mapKey, T value) {

    }

    @Override
    public <T> void setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit) {

    }

    @Override
    public void deleteObject(String key) {

    }

    @Override
    public void deleteObject(Collection keys) {

    }
}
