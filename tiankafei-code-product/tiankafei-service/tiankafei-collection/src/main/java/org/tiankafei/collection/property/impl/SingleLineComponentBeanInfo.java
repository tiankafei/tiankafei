package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SingleLineComponentProperty;

/**
 * 单行文本组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SingleLineComponentBeanInfo extends BaseComponentProperty implements SingleLineComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SINGLE_LINE.getCode();
    }
}
