package org.tiankafei.base.enums;

/**
 * 显示类型
 * @author tiankafei
 */
public enum ViewTypeEnum {

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

    ViewTypeEnum(int code, String name) {
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
