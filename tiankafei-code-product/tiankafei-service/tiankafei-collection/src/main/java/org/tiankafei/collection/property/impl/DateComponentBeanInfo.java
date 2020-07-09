package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.DateComponentProperety;

/**
 * 日期组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class DateComponentBeanInfo extends BaseComponentProperty implements DateComponentProperety {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.DATE.getCode();
    }
}
