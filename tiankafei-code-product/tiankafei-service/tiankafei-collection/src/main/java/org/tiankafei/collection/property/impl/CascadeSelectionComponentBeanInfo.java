package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.CascadeSelectionComponentProperty;

/**
 * 级联下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class CascadeSelectionComponentBeanInfo extends BaseComponentProperty implements CascadeSelectionComponentProperty {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.CASCADE_SELECTION.getCode();
    }

}
