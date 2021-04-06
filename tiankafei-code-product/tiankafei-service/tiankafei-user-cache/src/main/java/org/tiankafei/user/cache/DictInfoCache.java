package org.tiankafei.user.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tiankafei.cache.CacheManagerRepository;

/**
 * 字典数据缓存
 * 1.对于已经启动的字典，可以进行字典数据的长期缓存，
 * 2.当用户手动停用字典，可以使用异步的方式进行字典数据缓存的删除
 * 3.当用户删除字典时，可以使用异步的方式进行字典数据缓存的删除
 * 这种情况，字典数据的缓存可能已经删除了，因为在停用的时候，已经通过异步消息删除了一次。在用的不能直接删除，需要先停用然后才能删除
 * 4.
 *
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public class DictInfoCache {

    @Autowired
    private CacheManagerRepository cacheManagerRepository;

}
