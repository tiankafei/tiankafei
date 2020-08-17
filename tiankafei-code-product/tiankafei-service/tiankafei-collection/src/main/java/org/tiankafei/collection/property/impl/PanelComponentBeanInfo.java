package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.PanelComponentProperty;

/**
 * 面板组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PanelComponentBeanInfo extends BaseLayoutComponentProperty implements PanelComponentProperty {

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

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.PANEL.getCode();
    }
}
