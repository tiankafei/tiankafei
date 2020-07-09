package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CheckBoxComponentProperty;
import org.tiankafei.collection.property.EditComponentProperty;

/**
 * 编辑器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class EditComponentBeanInfo extends BaseComponentProperty implements EditComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.EDIT.getCode();
    }
}
