package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SliderComponentProperty;

/**
 * 滑块组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SliderComponentBeanInfo extends BaseComponentProperty implements SliderComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SLIDER.getCode();
    }
}
