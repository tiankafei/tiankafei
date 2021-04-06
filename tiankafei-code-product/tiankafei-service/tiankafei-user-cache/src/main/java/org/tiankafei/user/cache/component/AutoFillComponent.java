package org.tiankafei.user.cache.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.sql.Timestamp;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.common.datetime.DateTimeUtil;
import org.tiankafei.user.cache.UserInfoCache;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class AutoFillComponent implements MetaObjectHandler {

    @Autowired
    private UserInfoCache userInfoCache;

    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐使用)
        Timestamp timestamp = DateTimeUtil.longToTimestamp();
        this.strictInsertFill(metaObject, "createTime", Timestamp.class, timestamp);
        this.strictInsertFill(metaObject, "createUserId", Long.class, userInfoCache.getUserId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Timestamp timestamp = DateTimeUtil.longToTimestamp();
        this.strictInsertFill(metaObject, "updateTime", Timestamp.class, timestamp);
        this.strictInsertFill(metaObject, "updateUserId", Long.class, userInfoCache.getUserId());
    }

}
