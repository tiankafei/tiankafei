package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.TimeRangeComponentProperty;

/**
 * 时间范围组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class TimeRangeComponentBeanInfo extends BaseComponentProperty implements TimeRangeComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.TIME_RANGE.getCode();
    }
}
