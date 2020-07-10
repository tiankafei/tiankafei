package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.NumberComponentProperty;

/**
 * 数字组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class NumberComponentBeanInfo extends InputComponentProperty implements NumberComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.NUMBER.getCode();
    }
}
