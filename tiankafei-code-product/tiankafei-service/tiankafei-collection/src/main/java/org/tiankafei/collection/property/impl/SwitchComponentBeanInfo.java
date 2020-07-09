package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.SwitchComponentProperty;

/**
 * 开关组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SwitchComponentBeanInfo extends BaseComponentProperty implements SwitchComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.SWITCH.getCode();
    }
}
