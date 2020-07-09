package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CheckBoxComponentProperty;

/**
 * 复选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class CheckBoxComponentBeanInfo extends BaseComponentProperty implements CheckBoxComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.CHECK_BOX.getCode();
    }
}
