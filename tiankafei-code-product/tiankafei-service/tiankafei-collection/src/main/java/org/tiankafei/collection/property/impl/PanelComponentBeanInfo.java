package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.PanelComponentProperty;

import java.util.List;

/**
 * 面板组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class PanelComponentBeanInfo implements PanelComponentProperty {

    /**
     * 面板模式
     */
    protected String panelName;

    /**
     * 布局模式
     */
    protected String layoutModel;

    /**
     * 水平排列
     */
    protected String horizontal;

    /**
     * 垂直排列
     */
    protected String vertical;

    /**
     * 面板中的组件集合
     */
    protected List<ComponentProperty> componentPropertyList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.PANEL.getCode();
    }
}
