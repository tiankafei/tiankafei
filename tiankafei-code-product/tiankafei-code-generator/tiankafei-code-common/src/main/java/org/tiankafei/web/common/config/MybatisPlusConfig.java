package org.tiankafei.web.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.google.common.collect.Maps;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tiankafei.web.common.config.impl.DynamicTableNameHandler;
import org.tiankafei.web.common.config.impl.MoreTenantLineHandler;
import org.tiankafei.web.common.properties.DynamicTableProperties;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configuration
public class MybatisPlusConfig {

    @Autowired
    private DynamicTableProperties dynamicTableProperties;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        InnerInterceptor
//                我们提供的插件都将基于此接口来实现功能
//        目前已有的功能:
//        自动分页: PaginationInnerInterceptor
//        多租户: TenantLineInnerInterceptor
//        动态表名: DynamicTableNameInnerInterceptor
//        乐观锁: OptimisticLockerInnerInterceptor
//        sql性能规范: IllegalSQLInnerInterceptor
//        防止全表更新与删除: BlockAttackInnerInterceptor
//        TODO 注意:
//        使用多个功能需要注意顺序关系,建议使用如下顺序
//        多租户,动态表名
//        分页,乐观锁
//        sql性能规范,防止全表更新与删除
//        总结: 对sql进行单次改造的优先放入,不对sql进行改造的最后放入

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // note note note 这里是多租户的配置
        TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor(new MoreTenantLineHandler(dynamicTableProperties.getTenantId()));
        interceptor.addInnerInterceptor(tenantLineInnerInterceptor);

        // note note note 这里是动态表名的配置
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        HashMap<String, TableNameHandler> tableNameHandlerHashMap = Maps.newHashMap();
        for (String tableName : dynamicTableProperties.getTableNames()) {
            tableNameHandlerHashMap.put(tableName, new DynamicTableNameHandler());
        }
        dynamicTableNameInnerInterceptor.setTableNameHandlerMap(tableNameHandlerHashMap);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);

//        mysql,,,MySql数据库
//        mariadb,,,MariaDB数据库
//        oracle,,,Oracle11g及以下数据库(高版本推荐使用ORACLE_NEW)
//        oracle12c,,,Oracle12c+数据库
//        db2,,,DB2数据库
//        h2,,,H2数据库
//        hsql,,,HSQL数据库
//        sqlite,,,SQLite数据库
//        postgresql,,,Postgre数据库
//        sqlserver2005,,,SQLServer2005数据库
//        sqlserver,,,SQLServer数据库
//        dm,,,达梦数据库
//        xugu,,,虚谷数据库
//        kingbasees,,,人大金仓数据库
//        phoenix,,,Phoenix HBase数据库
//        zenith,,,Gauss 数据库
//        clickhouse,,,clickhouse 数据库
//        gbase,,,南大通用数据库
//        oscar,,,神通数据库
//        sybase,,,Sybase ASE 数据库
//        oceanbase,,,OceanBase 数据库
//        Firebird,,,Firebird 数据库
//        other,,,其他数据库

        // note note note 这里是分页的配置
        DbType dbType = DbType.MYSQL;
        if(StringUtils.isNotBlank(dynamicTableProperties.getDbType())){
            dbType = DbType.valueOf(dynamicTableProperties.getDbType());
        }
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(dbType);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);

        // note note note 这里是乐观锁的配置
        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);

        // note note note 这里是sql性能规范的配置
        IllegalSQLInnerInterceptor illegalSQLInnerInterceptor = new IllegalSQLInnerInterceptor();
        interceptor.addInnerInterceptor(illegalSQLInnerInterceptor);

        // note note note 这里是防止全表更新与删除的配置
        BlockAttackInnerInterceptor blockAttackInnerInterceptor = new BlockAttackInnerInterceptor();
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor);

        return interceptor;
    }

    /**
     * 雪花算法生成ID的对象
     * @return
     */
    @Bean
    public DefaultIdentifierGenerator defaultIdentifierGenerator(){
        return new DefaultIdentifierGenerator();
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
