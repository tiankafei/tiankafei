package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.TimeComponentProperty;

/**
 * 时间组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class TimeComponentBeanInfo extends BaseComponentProperty implements TimeComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.TIME.getCode();
    }
}
