package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.MultiLineComponentProperty;

/**
 * 多行文本组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class MultiLineComponentBeanInfo extends BaseComponentProperty implements MultiLineComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.MULTI_LINE.getCode();
    }
}
