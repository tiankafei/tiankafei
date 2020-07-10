package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.DateComponentProperety;

/**
 * 日期组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class DateComponentBeanInfo extends InputComponentProperty implements DateComponentProperety {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;

    /**
     * 占位提示
     */
    protected String placeholder;

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
     * 默认值
     */
    protected Object defaultValue;

    /**
     * 时间区间
     */
    protected String timeRange;

    /**
     * 时间类型：日，周，年，月，日期时间
     */
    protected String timeType;

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
        return ComponentTypeEnum.DATE.getCode();
    }
}
