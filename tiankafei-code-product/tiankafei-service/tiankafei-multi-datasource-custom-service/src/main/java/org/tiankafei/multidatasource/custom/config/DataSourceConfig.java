package org.tiankafei.multidatasource.custom.config;

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
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DruidDataSourceBuilder.create().build();
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
