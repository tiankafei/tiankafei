package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.DateRangeComponentProperty;

/**
 * 日期范围组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DateRangeComponentBeanInfo extends BaseInputComponentProperty implements DateRangeComponentProperty {

    /**
     * 结束占位提示
     */
    protected String endPlaceholder;

    /**
     * 结束默认值
     */
    protected Object endDefaultValue;

    /**
     * 开始时间
     */
    protected String startTime;

    /**
     * 截止时间
     */
    protected String endTime;

    /**
     * 时间类型：日，周，年，月，日期时间
     */
    protected String timeType;

    /**
     * 分隔符
     */
    protected String splitSymbol;

    /**
     * 时间格式
     */
    protected String timeFormat;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.DATE_RANGE.getCode();
    }
}
