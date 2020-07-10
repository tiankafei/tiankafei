package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ColorComponentProperty;

/**
 * 颜色选择器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class ColorComponentBeanInfo extends ChooseComponentProperty implements ColorComponentProperty {

    /**
     * 颜色格式
     */
    protected String colorFormat;

    /**
     * 组件尺寸
     */
    protected String componentSize;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.COLOR.getCode();
    }
}
