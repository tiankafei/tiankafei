package org.tiankafei.web.generate.dbdoc.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class WorkflowCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.50.83:3306/activiti?useUnicode=true&characterEncoding=utf8&nullCatalogMeansCurrent=true&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true";
    }

    @Override
    public String getFileName() throws Exception {
        return "工作流系统";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.RUOYI_ACTIVITI;
    }

}
