package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.DateRangeComponentProperty;

/**
 * 日期范围组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class DateRangeComponentBeanInfo extends BaseComponentProperty implements DateRangeComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.DATE_RANGE.getCode();
    }
}
