package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.PanelComponentProperty;

/**
 * 面板组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class PanelComponentBeanInfo extends BaseComponentProperty implements PanelComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.PANEL.getCode();
    }
}
