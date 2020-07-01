package org.tiankafei.dbmysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.dbmysql.entity.TableEntity;
import org.tiankafei.dbmysql.service.DbmysqlService;
import org.tiankafei.dbmysql.service.TableService;

import java.util.List;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Slf4j
public class DbmysqlServiceImpl implements DbmysqlService {

    @Value("${spring.datasource.url}")
    private String url;

    /**
     * 数据库名称
     */
    private String tableSchema;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TableService tableService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getTableSchema() {
        if(StringUtils.isNotBlank(tableSchema)){
            return tableSchema;
        }
//        jdbc:mysql://localhost:3306/db-user?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
        String str = url.split("\\?")[0];
        String[] split = str.split("/");
        tableSchema = split[split.length - 1];
        return tableSchema;
    }

    @Override
    public boolean checkTableExists(String tableName) {
        LambdaQueryWrapper<TableEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TableEntity::getTableSchema, getTableSchema());
        lambdaQueryWrapper.eq(TableEntity::getTableName, tableName);
        return tableService.count(lambdaQueryWrapper) > 0;
    }

    @Override
    public boolean dropTable(String tableName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drop table ").append(tableName);
        log.debug(stringBuilder.toString());
        jdbcTemplate.execute(stringBuilder.toString());
        return Boolean.TRUE;
    }

    @Override
    public boolean createTable(String templateTable, String tableName, String name) {
        // 1. 查询索引
        StringBuilder searchIndexSql = new StringBuilder();
        searchIndexSql.append("show index from ").append(templateTable);
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(searchIndexSql.toString());

        List<String> sqlList = Lists.newArrayList();
        // 2. 创建表语句
        sqlList.add("create table " + tableName + " as select * from " + templateTable + " where 1=2");

        for (int index = 0, length = dataMapList.size(); index < length; index++) {
            Map<String, Object> dataMap = dataMapList.get(index);
            Object key_name = dataMap.get("Key_name");
            Object column_name = dataMap.get("Column_name");
            Integer non_unique = (Integer) dataMap.get("Non_unique");

            if(!"PRIMARY".equals(key_name)){
                // 3. 创建索引语句
                StringBuilder createIndexSql = new StringBuilder();
                createIndexSql.append("ALTER TABLE `")
                        .append(getTableSchema()).append("`.`").append(tableName)
                        .append("` ADD ").append(non_unique == 0 ? "UNIQUE" : "").append(" INDEX `")
                        .append(key_name).append("`(`").append(column_name).append("`) COMMENT '").append(name).append("'");
                sqlList.add(createIndexSql.toString());
            }
        }
        // 4. 创建表注释
        if(StringUtils.isNotBlank(name)){
            StringBuilder tableCommentSql = new StringBuilder();
            tableCommentSql.append("ALTER TABLE `").append(getTableSchema()).append("`.`").append(tableName).append("` COMMENT = '").append(name).append("'");
            sqlList.add(tableCommentSql.toString());
        }
        jdbcTemplate.batchUpdate(sqlList.toArray(new String[]{}));

        return Boolean.TRUE;
    }

}
