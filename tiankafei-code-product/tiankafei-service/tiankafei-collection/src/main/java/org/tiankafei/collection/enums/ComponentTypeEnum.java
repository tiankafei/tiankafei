package org.tiankafei.collection.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ComponentTypeEnum {

    SINGLE_LINE(10, "单行文本"),
    MULTI_LINE(20, "多行文本"),
    NUMBER(21, "数字"),
    PASSWORD(30, "密码"),
    COUNTER(40, "计数器"),
    EDIT(41, "编辑器"),
    SELECTION(50, "下拉选择"),
    CASCADE_SELECTION(60, "级联选择"),
    RADIO(70, "单选框组"),
    CHECK_BOX(80, "多选框组"),
    SWITCH(90, "开关"),
    SLIDER(100, "滑块"),
    TIME(110, "时间选择"),
    TIME_RANGE(120, "时间范围"),
    DATE(130, "日期选择"),
    DATE_RANGE(140, "日期范围"),
    RATE(170, "评分"),
    COLOR(180, "颜色选择"),
    UPLOAD(190, "上传"),
    PANEL(200, "面板"),
    TABLE(210, "表格"),
    BUTTON(220, "按钮"),
    ;

    private Integer code;

    private String name;

    ComponentTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
