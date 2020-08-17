package org.tiankafei.collection.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ComponentTypeEnum {

    // 单行文本
    SINGLE_LINE(10, "单行文本"),
    // 多行文本
    MULTI_LINE(20, "多行文本"),
    // 数字
    NUMBER(21, "数字"),
    // 密码
    PASSWORD(30, "密码"),
    // 计数器
    COUNTER(40, "计数器"),
    // 编辑器
    EDIT(41, "编辑器"),
    // 下拉选择
    SELECTION(50, "下拉选择"),
    // 级联选择
    CASCADE_SELECTION(60, "级联选择"),
    // 单选框组
    RADIO(70, "单选框组"),
    // 多选框组
    CHECK_BOX(80, "多选框组"),
    // 开关
    SWITCH(90, "开关"),
    // 滑块
    SLIDER(100, "滑块"),
    // 时间选择
    TIME(110, "时间选择"),
    // 时间范围
    TIME_RANGE(120, "时间范围"),
    // 日期选择
    DATE(130, "日期选择"),
    // 日期范围
    DATE_RANGE(140, "日期范围"),
    // 评分
    RATE(170, "评分"),
    // 颜色选择
    COLOR(180, "颜色选择"),
    // 上传
    UPLOAD(190, "上传"),
    // 面板
    PANEL(200, "面板"),
    // 表格
    TABLE(210, "表格"),
    // 按钮
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
