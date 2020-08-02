package org.tiankafei.web.common.config;

import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tiankafei.web.common.config.impl.DynamicTableNameHandler;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        HashMap<String, ITableNameHandler> tableNameHandlerHashMap = Maps.newHashMap();
        //note note note 动态表名在这里配置
        tableNameHandlerHashMap.put("sys_dict_table", new DynamicTableNameHandler());
        dynamicTableNameParser.setTableNameHandlerMap(tableNameHandlerHashMap);

        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }

    /**
     * mybatios-plus乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
