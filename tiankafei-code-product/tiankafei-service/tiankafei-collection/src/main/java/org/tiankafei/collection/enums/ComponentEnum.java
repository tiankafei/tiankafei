package org.tiankafei.collection.enums;

/**
 * @author 魏双双
 * @since 1.0
 **/
public enum ComponentEnum {

    // 单行文本
    SINGLE_LINE(1),
    // 多行文本
    MULTI_LINE(2),
    // 密码
    PASSWORD(3),
    // 计数器
    COUNTER(4),
    // 下拉框
    SELECTION(5),
    // 级联下拉框
    CASCADE_SELECTION(6),
    // 单选按钮组
    RADIO(7),


    ;

    private Integer code;

    ComponentEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
