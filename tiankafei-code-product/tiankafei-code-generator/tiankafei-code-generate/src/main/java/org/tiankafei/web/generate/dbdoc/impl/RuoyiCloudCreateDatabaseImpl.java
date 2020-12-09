package org.tiankafei.web.generate.dbdoc.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class RuoyiCloudCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.50.83:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai";
    }

    @Override
    public String getFileName() throws Exception {
        return "总控系统";
    }

    @Override
    public List<String> ignoreTablePrefixList() {
        List<String> ignoreTablePrefixList = super.ignoreTablePrefixList();
        ignoreTablePrefixList.add("QRTZ_");
        ignoreTablePrefixList.add("gen");
        return ignoreTablePrefixList;
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.RUOYI_CLOUD;
    }

}
