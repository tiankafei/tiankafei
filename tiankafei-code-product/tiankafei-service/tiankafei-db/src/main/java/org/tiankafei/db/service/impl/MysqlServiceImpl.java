package org.tiankafei.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.db.entity.TableEntity;
import org.tiankafei.db.service.DbService;
import org.tiankafei.db.service.TableService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Slf4j
public class MysqlServiceImpl implements DbService {

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

    @Override
    public String getTableSchema() {
        if (StringUtils.isNotBlank(tableSchema)) {
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
        log.debug("delete table sql is : {}", stringBuilder.toString());
        jdbcTemplate.execute(stringBuilder.toString());
        return Boolean.TRUE;
    }

    @Override
    public boolean createTable(String templateTable, String tableName, String name) {
        // 1. 查询索引
        StringBuilder searchIndexSql = new StringBuilder();
        searchIndexSql.append("show index from ").append(templateTable);
        log.debug("show index sql : {}", searchIndexSql.toString());
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(searchIndexSql.toString());

        List<String> sqlList = Lists.newArrayList();
        // 2. 创建表语句
        StringBuilder createTableSql = new StringBuilder();
        createTableSql.append("create table ").append(tableName).append(" as select * from ").append(templateTable).append(" where 1=2");
        log.debug("create table sql : {}", createTableSql.toString());
        sqlList.add(createTableSql.toString());

        for (int index = 0, length = dataMapList.size(); index < length; index++) {
            Map<String, Object> dataMap = dataMapList.get(index);
            Object keyName = dataMap.get("Key_name");
            Object columnName = dataMap.get("Column_name");
            Integer nonUnique = (Integer) dataMap.get("Non_unique");
            String indexComment = (String) dataMap.get("Index_comment");

            if (!"PRIMARY".equals(keyName)) {
                // 3. 创建索引语句
                StringBuilder createIndexSql = new StringBuilder();
                createIndexSql.append("ALTER TABLE `")
                        .append(getTableSchema()).append("`.`").append(tableName)
                        .append("` ADD ").append(nonUnique == 0 ? "UNIQUE" : "").append(" INDEX `")
                        .append(keyName).append("`(`").append(columnName).append("`) COMMENT '").append(indexComment).append("'");
                log.debug("create index sql : {}", createIndexSql.toString());
                sqlList.add(createIndexSql.toString());
            }
        }
        // 4. 创建表注释
        if (StringUtils.isNotBlank(name)) {
            StringBuilder tableCommentSql = new StringBuilder();
            tableCommentSql.append("ALTER TABLE `").append(getTableSchema()).append("`.`").append(tableName).append("` COMMENT = '").append(name).append("'");
            log.debug("alter table comment : {}", tableCommentSql.toString());
            sqlList.add(tableCommentSql.toString());
        }
        jdbcTemplate.batchUpdate(sqlList.toArray(new String[]{}));

        return Boolean.TRUE;
    }

}
