package org.tiankafei.multidatasource.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configuration
public class DataSourceJpaConfig {

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate() {
        DataSource dataSource = dynamicRoutingDataSource.getDataSource("blog");
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate() {
        DataSource dataSource = dynamicRoutingDataSource.getDataSource("user");
        return new JdbcTemplate(dataSource);
    }

}
