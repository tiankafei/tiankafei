package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ButtonComponentProperty;
import org.tiankafei.collection.property.EditComponentProperty;

/**
 * 按钮组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class ButtonComponentBeanInfo extends BaseComponentProperty implements ButtonComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.BUTTON.getCode();
    }
}
