package org.tiankafei.base.enums;

/**
 * 代码和名称
 *
 * @author tiankafei
 * @since 1.0
 **/
public enum DictEnum {

    /**
     * 默认用户
     */
    DEFAULT_USERNAME("super", "超级管理员"),

    /**
     * 默认用户所在的公司
     */
    DEFAULT_COMPANY("000001", "北京甜咖啡信息技术有限公司"),

    /**
     * 默认用户所在的部门
     */
    DEFAULT_ORGANIZATION("100001", "软件开发一部"),

    /**
     * 程序使用的代码表
     */
    CODE_TABLE_SOFTWARE("0", "程序使用的代码表"),

    /**
     * 系统业务使用的代码表
     */
    CODE_TABLE_SYSTEM("1", "系统业务使用的代码表"),

    /**
     * 设计中
     */
    STATUS_DESIGNER("0", "设计中"),

    /**
     * 提交审批中
     */
    STATUS_APPROVAL("1", "提交审批中"),

    /**
     * 审批通过
     */
    STATUS_APPROVAL_BY("2", "审批通过"),

    /**
     * 在用
     */
    STATUS_USEING("3", "在用"),

    /**
     * 停用
     */
    STATUS_UN_USEING("4", "停用"),

    /**
     * 文本输入
     */
    CONTROL_TYPE_TEXT("1", "文本输入"),

    /**
     * 下拉框
     */
    CONTROL_TYPE_SELECT("2", "下拉框"),

    /**
     * 超长控件
     */
    CONTROL_TYPE_CHOOSE("3", "超长控件"),

    /**
     * 日期时间控件
     */
    CONTROL_TYPE_DATE("4", "日期时间控件"),

    /**
     * boolean数据类型
     */
    DATA_TYPE_BOOLEAN("10", "boolean数据类型"),

    /**
     * 时间数据类型
     */
    DATA_TYPE_DATE("20", "时间数据类型"),

    /**
     * 整型数据类型
     */
    DATA_TYPE_INT("30", "整型数据类型"),

    /**
     * double数据类型
     */
    DATA_TYPE_DOUBE("40", "double数据类型"),

    /**
     * 字符串数据类型
     */
    DATA_TYPE_STRING("50", "字符串数据类型"),

    /**
     * 显示代码
     */
    VIEW_CODE("10", "显示代码"),

    /**
     * 显示名称
     */
    VIEW_NAME("20", "显示名称"),

    /**
     * 显示代码和名称
     */
    VIEW_CODE_NAME("30", "显示代码和名称"),

    /**
     * 显示名称和代码
     */
    VIEW_NAME_CODE("40", "显示名称和代码"),

    /**
     * 是
     */
    YES("1", "是"),

    /**
     * 否
     */
    NO("0", "否"),
    ;

    private String code;

    private String name;

    DictEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
