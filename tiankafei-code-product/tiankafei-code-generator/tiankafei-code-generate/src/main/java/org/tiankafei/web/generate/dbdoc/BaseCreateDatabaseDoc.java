package org.tiankafei.web.generate.dbdoc;

import com.google.common.collect.Lists;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

public abstract class BaseCreateDatabaseDoc {

    public String getDriverClassName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    public String getJdbcUrl() throws Exception {
        throw new Exception("jdbc-url不能为空");
    }

    public String getUsername() {
        return "tjcp";
    }

    public String getPassword() {
        return "tjcp";
    }

    public String getFileDirectory() {
        return "C:\\Users\\Administrator\\Desktop\\统计产品";
    }

    public String getVersion() {
        return "1.0.0";
    }

    public String getDescription() {
        return "数据库设计文档生成";
    }

    public String getFileName() throws Exception {
        throw new Exception("生成的文件名不能为空");
    }

    public BusinessTypeEnum getBusinessType() {
        return null;
    }

    public List<String> ignoreTableNameList() {
        return Lists.newArrayList("undo_log", "PDMAN_DB_VERSION", "test", "testtab");
    }

    public List<String> ignoreTablePrefixList() {
        return Lists.newArrayList();
    }

    public List<String> ignoreTableSuffixList() {
        return Lists.newArrayList();
    }

    public List<String> designatedTableNameList() {
        return Lists.newArrayList();
    }

    public List<String> designatedTablePrefixList() {
        return Lists.newArrayList();
    }

    public List<String> designatedTableSuffixList() {
        return Lists.newArrayList();
    }
}
