package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CounterComponentProperty;

/**
 * 计数器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class CounterComponentBeanInfo extends BaseComponentProperty implements CounterComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.COUNTER.getCode();
    }
}
