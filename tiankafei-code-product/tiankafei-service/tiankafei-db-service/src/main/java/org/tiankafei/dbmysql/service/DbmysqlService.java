package org.tiankafei.dbmysql.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.exception.DaoException;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class DbmysqlService {

    @Value("${spring.datasource.url}")
    private String url;

    /**
     * 数据库名称
     */
    private String tableSchema;

    public String getTableSchema() throws DaoException {
        if(StringUtils.isNotBlank(tableSchema)){
            return tableSchema;
        }
//        jdbc:mysql://localhost:3306/db-user?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
        String str = url.split("\\?")[0];
        String[] split = str.split("/");
        tableSchema = split[split.length - 1];
        return tableSchema;
    }

}
