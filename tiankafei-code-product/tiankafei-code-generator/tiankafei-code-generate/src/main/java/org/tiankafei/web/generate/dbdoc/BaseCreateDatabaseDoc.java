package org.tiankafei.web.generate.dbdoc;

import com.google.common.collect.Lists;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

public abstract class BaseCreateDatabaseDoc implements ICreateDatabaseDoc {

    @Override
    public String getDriverClassName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public String getJdbcUrl() throws Exception {
        throw new Exception("jdbc-url不能为空");
    }

    @Override
    public String getUsername() {
        return "tjcp";
    }

    @Override
    public String getPassword() {
        return "tjcp";
    }

    @Override
    public String getFileDirectory() {
        return "C:\\Users\\Administrator\\Desktop\\统计产品";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getDescription() {
        return "数据库设计文档生成";
    }

    @Override
    public String getFileName() throws Exception {
        throw new Exception("生成的文件名不能为空");
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return null;
    }

    @Override
    public List<String> ignoreTableNameList() {
        return Lists.newArrayList("undo_log", "PDMAN_DB_VERSION", "test", "testtab");
    }

    @Override
    public List<String> ignoreTablePrefixList() {
        return Lists.newArrayList();
    }

    @Override
    public List<String> ignoreTableSuffixList() {
        return Lists.newArrayList();
    }

    @Override
    public List<String> designatedTableNameList() {
        return Lists.newArrayList();
    }

    @Override
    public List<String> designatedTablePrefixList() {
        return Lists.newArrayList();
    }

    @Override
    public List<String> designatedTableSuffixList() {
        return Lists.newArrayList();
    }
}
