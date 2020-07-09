package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.TableComponentProperty;

/**
 * 表格组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class TableComponentBeanInfo extends BaseComponentProperty implements TableComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.TABLE.getCode();
    }
}
