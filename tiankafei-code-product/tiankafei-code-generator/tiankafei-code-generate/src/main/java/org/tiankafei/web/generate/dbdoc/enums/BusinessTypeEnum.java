package org.tiankafei.web.generate.dbdoc.enums;

public enum BusinessTypeEnum {

    REPORT_DESIGN("report_design"),
    REPORT_FILL("report_fill"),
    RULE_DESIGN("rule_design"),
    RULE_VERIFY("rule_verify"),
    METADATA("metadata"),
    MLBD("mlbd"),
    RUOYI_CLOUD("ruoyi_cloud"),
    RUOYI_ACTIVITI("ruoyi_activiti"),
    ;

    private String businessType;

    BusinessTypeEnum(String businessType){
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
