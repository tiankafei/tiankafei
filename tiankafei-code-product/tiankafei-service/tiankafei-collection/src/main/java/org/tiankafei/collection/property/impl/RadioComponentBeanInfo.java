package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.RadioComponentProperty;

/**
 * 单选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class RadioComponentBeanInfo extends BaseComponentProperty implements RadioComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.RADIO.getCode();
    }
}
