package org.tiankafei.rule.enums;

/**
 * @author tiankafei
 * @since 1.0
 */
public enum RuleEnums {

    VERIFY(1, "审核规则"),
    COMPUTE(2, "计算规则"),
    JUMP(3, "跳转规则"),
    TABLE_VERIFY(4, "基于物理表的审核规则"),
    ;

    private int code;
    private String name;

    RuleEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
