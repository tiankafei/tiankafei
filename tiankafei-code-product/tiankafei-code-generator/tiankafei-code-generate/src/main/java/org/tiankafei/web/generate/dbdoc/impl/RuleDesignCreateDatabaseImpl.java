package org.tiankafei.web.generate.dbdoc.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class RuleDesignCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.50.83:3306/thtftjcp-rule-design?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
    }

    @Override
    public String getFileName() throws Exception {
        return "规则设计";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.RULE_DESIGN;
    }

    @Override
    public List<String> ignoreTableNameList() {
        return Lists.newArrayList("undo_log", "gh_gz_gz");
    }
}
