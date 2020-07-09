package org.tiankafei.collection.property.impl;

import lombok.Setter;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.TableFormDataProperty;

import java.util.List;

/**
 * 表单属性
 *
 * @author tiankafei
 * @since 1.0
 */
@Setter
public class TableFormDataBeanInfo implements TableFormDataProperty {

    /**
     * 表单名称
     */
    protected String tableFormName;

    /**
     * 组件集合
     */
    protected List<ComponentProperty> componentPropertyList;

    @Override
    public void addComponentProperty(ComponentProperty componentProperty) {
        componentPropertyList.add(componentProperty);
    }
}
