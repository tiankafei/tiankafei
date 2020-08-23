package org.tiankafei.multidatasource.custom.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.tiankafei.multidatasource.custom.enums.DataSourceTypeEnums;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configurable
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(DataSource primaryDataSource, DataSource secondaryDataSource){
        Map<Object, Object> dataSourceMap = Maps.newHashMap();
        dataSourceMap.put(DataSourceTypeEnums.primary.name(), primaryDataSource);
        dataSourceMap.put(DataSourceTypeEnums.secondary.name(), secondaryDataSource);
        return new DynamicDataSource(primaryDataSource, dataSourceMap);
    }

}
