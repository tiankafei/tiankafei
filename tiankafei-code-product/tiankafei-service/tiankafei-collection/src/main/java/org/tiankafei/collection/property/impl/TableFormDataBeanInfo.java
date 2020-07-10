package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.TableFormDataProperty;

import java.util.List;

/**
 * 表单属性
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class TableFormDataBeanInfo implements TableFormDataProperty {

    /**
     * 表单名称
     */
    protected String tableFormName;

    public void setTableFormName(String tableFormName) {
        this.tableFormName = tableFormName;
    }

    /**
     * 组件集合
     */
    protected List<ComponentProperty> componentPropertyList;

    @Override
    public void addComponentProperty(ComponentProperty componentProperty) {
        componentPropertyList.add(componentProperty);
    }
}
