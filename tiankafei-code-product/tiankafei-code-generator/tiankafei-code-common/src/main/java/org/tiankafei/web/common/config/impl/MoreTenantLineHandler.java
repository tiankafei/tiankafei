package org.tiankafei.web.common.config.impl;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;

/**
 * @author tiankafei
 * @since 1.0
 */
public class MoreTenantLineHandler implements TenantLineHandler {

    /**
     * 租户
     */
    private String tenantId;

    public MoreTenantLineHandler(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public Expression getTenantId() {
        return new LongValue(tenantId);
    }

    @Override
    public boolean ignoreTable(String tableName) {
        // 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
        return false;
    }
}
