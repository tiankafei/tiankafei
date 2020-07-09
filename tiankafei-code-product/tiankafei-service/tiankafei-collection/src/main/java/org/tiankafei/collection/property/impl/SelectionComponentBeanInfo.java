package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SelectionComponentProperty;

/**
 * 下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SelectionComponentBeanInfo extends BaseComponentProperty implements SelectionComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SELECTION.getCode();
    }
}
