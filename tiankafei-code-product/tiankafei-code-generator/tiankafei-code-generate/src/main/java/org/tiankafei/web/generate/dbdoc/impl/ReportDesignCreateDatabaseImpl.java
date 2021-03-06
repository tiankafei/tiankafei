package org.tiankafei.web.generate.dbdoc.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class ReportDesignCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.50.83:3306/thtftjcp?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
    }

    @Override
    public String getFileName() throws Exception {
        return "统计报表";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.REPORT_DESIGN;
    }

    @Override
    public List<String> ignoreTableNameList() {
        List<String> ignoreTableNameList = super.ignoreTableNameList();
        ignoreTableNameList.add("gh_gz_gz");
        return ignoreTableNameList;
    }

    @Override
    public List<String> ignoreTablePrefixList() {
        List<String> ignoreTablePrefixList = super.ignoreTablePrefixList();
        ignoreTablePrefixList.add("tjcp_ewb");
        ignoreTablePrefixList.add("tjcp_sjzd");
        ignoreTablePrefixList.add("tjcp_ywb");
        return ignoreTablePrefixList;
    }
}
