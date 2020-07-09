package org.tiankafei.collection.enums;

/**
 * @author 魏双双
 * @since 1.0
 **/
public enum ComponentTypeEnum {

    // 单行文本
    SINGLE_LINE(1, "单行文本"),
    // 多行文本
    MULTI_LINE(2, "多行文本"),
    // 密码
    PASSWORD(3, "密码"),
    // 计数器
    COUNTER(4, "计数器"),
    // 下拉选择
    SELECTION(5, "下拉选择"),
    // 级联选择
    CASCADE_SELECTION(6, "级联选择"),
    // 单选框组
    RADIO(7, "单选框组"),
    // 多选框组
    CHECK_BOX(8, "多选框组"),
    // 开关
    SWITCH(9, "开关"),
    // 滑块
    SLIDER(10, "滑块"),
    // 时间选择
    TIME(11, "时间选择"),
    // 时间范围
    TIME_RANGE(12, "时间范围"),
    // 日期选择
    DATE(13, "日期选择"),
    // 日期范围
    DATE_RANGE(14, "日期范围"),
    // 日期时间选择
    DATE_TIME(15, "日期时间选择"),
    // 日期时间范围
    DATE_TIME_RANGE(16, "日期时间范围"),
    // 评分
    RATE(17, "评分"),
    // 颜色选择
    COLOR(18, "颜色选择"),
    // 上传
    UPLOAD(19, "上传"),
    // 面板
    PANEL(20, "面板"),
    // 表格
    TABLE(21, "表格"),
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
