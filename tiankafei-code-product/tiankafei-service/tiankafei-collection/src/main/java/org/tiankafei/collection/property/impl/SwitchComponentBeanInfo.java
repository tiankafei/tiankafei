package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SwitchComponentProperty;

/**
 * 开关组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class SwitchComponentBeanInfo extends ChooseComponentProperty implements SwitchComponentProperty {

    /**
     * 开启提示消息
     */
    protected String enableMessage;

    /**
     * 关闭提示消息
     */
    protected String disableMessage;

    /**
     * 开启值
     */
    protected String enableValue;

    /**
     * 关闭值
     */
    protected String disableValue;

    /**
     * 开启颜色
     */
    protected String enableColor;

    /**
     * 关闭颜色
     */
    protected String disableColor;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SWITCH.getCode();
    }
}
