package org.tiankafei.web.generate.dbdoc.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

@Component
public class DataTableCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:oracle:thin:@10.10.50.238:15224:ahsjzygl";
    }

    @Override
    public String getDriverClassName() {
        return "oracle.jdbc.OracleDriver";
    }

    @Override
    public String getUsername() {
        return "jccx";
    }

    @Override
    public String getPassword() {
        return "jccxpassword";
    }

    @Override
    public String getFileName() throws Exception {
        return "数据表管理";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.DATA_TABLE;
    }

    @Override
    public List<String> designatedTableNameList() {
        List<String> designatedTableNameList = super.designatedTableNameList();
        designatedTableNameList.add("YW_SJDR_SJBZC");
        designatedTableNameList.add("YW_SJDR_ZDZC");
        designatedTableNameList.add("YW_DATA_AREA");
        designatedTableNameList.add("YW_OBJECT_TYPE");
        return designatedTableNameList;
    }
}
