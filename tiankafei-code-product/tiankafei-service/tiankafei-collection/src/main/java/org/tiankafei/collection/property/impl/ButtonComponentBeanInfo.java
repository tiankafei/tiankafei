package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ButtonComponentProperty;

/**
 * 按钮组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class ButtonComponentBeanInfo extends BaseComponentProperty implements ButtonComponentProperty {

    /**
     * 组件尺寸
     */
    protected String componentSize;

    /**
     * 按钮图标
     */
    protected String buttonIcon;

    /**
     * 按钮类型
     */
    protected String buttonType;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.BUTTON.getCode();
    }
}
