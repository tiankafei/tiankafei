package org.tiankafei.web.generate.dbdoc.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.web.generate.dbdoc.BaseCreateDatabaseDoc;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

@Component
public class MlbdCreateDatabaseImpl extends BaseCreateDatabaseDoc {

    @Override
    public String getJdbcUrl() throws Exception {
        return "jdbc:mysql://10.10.60.21:3306/mlbd?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
    }

    @Override
    public String getUsername() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "m.&_dAkYE,.o00";
    }

    @Override
    public String getFileName() throws Exception {
        return "名录比对";
    }

    @Override
    public BusinessTypeEnum getBusinessType() {
        return BusinessTypeEnum.MLBD;
    }

}
