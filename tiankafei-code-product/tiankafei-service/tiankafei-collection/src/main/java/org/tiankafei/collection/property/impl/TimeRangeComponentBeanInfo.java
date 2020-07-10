package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.TimeRangeComponentProperty;

/**
 * 时间范围组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class TimeRangeComponentBeanInfo extends BaseComponentProperty implements TimeRangeComponentProperty {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;

    /**
     * 开始占位提示
     */
    protected String startPlaceholder;

    /**
     * 结束占位提示
     */
    protected String endPlaceholder;

    /**
     * 表单栅格
     */
    protected Integer formGrid;

    /**
     * 标签宽度
     */
    protected Integer labelWidth;

    /**
     * 组件宽度
     */
    protected Double componentWidth;

    /**
     * 开始默认值
     */
    protected Object startDefaultValue;

    /**
     * 结束默认值
     */
    protected Object endDefaultValue;

    /**
     * 分隔符
     */
    protected String splitSymbol;

    /**
     * 开始时间
     */
    protected String startTime;

    /**
     * 截止时间
     */
    protected String endTime;

    /**
     * 时间格式
     */
    protected String timeFormat;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 能否清空
     */
    protected Boolean clearable;

    /**
     * 是否只读
     */
    protected Boolean readonly;

    /**
     * 是否禁用
     */
    protected Boolean disabled;

    /**
     * 是否必填
     */
    protected Boolean required;

    /**
     * 正则表达式集合
     */
    protected List<RegularExpressionVo> regularExpressionVoList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.TIME_RANGE.getCode();
    }
}
