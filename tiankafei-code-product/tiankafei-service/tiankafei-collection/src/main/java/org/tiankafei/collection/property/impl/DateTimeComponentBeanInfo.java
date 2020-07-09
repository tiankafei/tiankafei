package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.DateTimeComponentProperty;

/**
 * 日期时间组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class DateTimeComponentBeanInfo extends BaseComponentProperty implements DateTimeComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.DATE_TIME.getCode();
    }
}
