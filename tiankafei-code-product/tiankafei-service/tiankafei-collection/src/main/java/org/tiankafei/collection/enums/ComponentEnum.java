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
    // 单选框组
    RADIO(7),
    // 多选框组
    CHECK_BOX(8),
    // 开关
    SWITCH(9),
    // 滑块
    SLIDER(10),
    // 时间选择
    TIME(11),
    // 时间范围
    TIME_RANGE(12),
    // 日期选择
    DATE(13),
    // 日期范围
    DATE_RANGE(14),
    // 日期时间选择
    DATE_TIME(15),
    // 日期时间范围
    DATE_TIME_RANGE(16),
    // 评分
    RATE(17),
    // 颜色选择
    COLOR(18),
    // 上传
    UPLOAD(19),
    // 面板
    PANEL(20),
    // 表格
    TABLE(21),
    ;

    private Integer code;

    ComponentEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
