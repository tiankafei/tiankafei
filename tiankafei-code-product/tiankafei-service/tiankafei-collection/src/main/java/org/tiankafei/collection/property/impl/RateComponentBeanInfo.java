package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.RateComponentProperty;

/**
 * 评分组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class RateComponentBeanInfo extends BaseComponentProperty implements RateComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.RATE.getCode();
    }
}
