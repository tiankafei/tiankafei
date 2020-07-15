package org.tiankafei.user.cache.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.base.base.datetime.DateTimeUtil;
import org.tiankafei.base.base.enums.DateTimeEnum;
import org.tiankafei.base.base.exceptions.BaseException;
import org.tiankafei.user.cache.UserInfoCache;

import java.sql.Timestamp;

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
        try {
            Timestamp timestamp = DateTimeUtil.longToTimestamp(System.currentTimeMillis(), DateTimeEnum.YYYY_1_MM_1_DDHH_1_MM_1_SS.getCode());
            this.strictInsertFill(metaObject, "createTime", Timestamp.class, timestamp);
        } catch (BaseException e) {
            e.printStackTrace();
        }
        this.strictInsertFill(metaObject, "createUserId", Long.class, userInfoCache.getUserId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            Timestamp timestamp = DateTimeUtil.longToTimestamp(System.currentTimeMillis(), DateTimeEnum.YYYY_1_MM_1_DDHH_1_MM_1_SS.getCode());
            this.strictInsertFill(metaObject, "updateTime", Timestamp.class, timestamp);
        } catch (BaseException e) {
            e.printStackTrace();
        }
        this.strictInsertFill(metaObject, "updateUserId", Long.class, userInfoCache.getUserId());
    }

}
