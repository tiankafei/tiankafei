package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.DateTimeRangeComponentProperty;

/**
 * 日期时间范围组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class DateTimeRangeComponentBeanInfo extends BaseComponentProperty implements DateTimeRangeComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.DATE_TIME_RANGE.getCode();
    }
}
