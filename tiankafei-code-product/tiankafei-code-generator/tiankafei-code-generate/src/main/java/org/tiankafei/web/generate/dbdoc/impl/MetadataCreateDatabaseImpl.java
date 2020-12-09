package org.tiankafei.web.generate.dbdoc.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class MetadataCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.50.83:3306/jl-metadata?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
    }

    @Override
    public String getFileName() throws Exception {
        return "元数据系统";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.METADATA;
    }

    @Override
    public List<String> ignoreTableNameList() {
        List<String> ignoreTableNameList = super.ignoreTableNameList();
        ignoreTableNameList.add("sys_test");
        ignoreTableNameList.add("test_ytb_zbzcb");
        return ignoreTableNameList;
    }

    @Override
    public List<String> ignoreTablePrefixList() {
        List<String> ignoreTablePrefixList = super.ignoreTablePrefixList();
        ignoreTablePrefixList.add("tjcp_wd");
        ignoreTablePrefixList.add("GY_ML");
        ignoreTablePrefixList.add("GYX_ML");
        return ignoreTablePrefixList;
    }
}
