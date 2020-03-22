package cn.tiankafei.base.enums;

/**
 * 基础枚举类
 *
 * @author tiankafei
 * @since 1.0
 **/
public enum BaseEnums {

    /**
     * boolean数据类型
     */
    DATA_TYPE_BOOLEAN(10, "boolean数据类型"),

    /**
     * 时间数据类型
     */
    DATA_TYPE_DATE(20, "时间数据类型"),

    /**
     * 整型数据类型
     */
    DATA_TYPE_INT(30, "整型数据类型"),

    /**
     * double数据类型
     */
    DATA_TYPE_DOUBE(40, "double数据类型"),

    /**
     * 字符串数据类型
     */
    DATA_TYPE_STRING(50, "字符串数据类型"),

    /**
     * 显示代码
     */
    VIEW_CODE(10, "显示代码"),

    /**
     * 显示名称
     */
    VIEW_NAME(20, "显示名称"),

    /**
     * 显示代码和名称
     */
    VIEW_CODE_NAME(30, "显示代码和名称"),

    /**
     * 显示名称和代码
     */
    VIEW_NAME_CODE(40, "显示名称和代码"),
    ;

    private int code;

    private String name;

    BaseEnums(int code, String name) {
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
