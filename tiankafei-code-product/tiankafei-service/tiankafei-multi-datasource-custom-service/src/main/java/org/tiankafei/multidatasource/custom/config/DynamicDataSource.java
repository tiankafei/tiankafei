package org.tiankafei.multidatasource.custom.config;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author tiankafei
 * @since 1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource primaryDataSource, Map<Object, Object> dataSourceMap) {
        super.setDefaultTargetDataSource(primaryDataSource);
        super.setTargetDataSources(dataSourceMap);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceType();
    }
}
