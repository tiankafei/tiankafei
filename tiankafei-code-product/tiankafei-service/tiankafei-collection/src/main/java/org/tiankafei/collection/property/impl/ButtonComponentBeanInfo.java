package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ButtonComponentProperty;

/**
 * 按钮组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class ButtonComponentBeanInfo extends LayoutComponentProperty implements ButtonComponentProperty {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;

    /**
     * 表单栅格
     */
    protected Integer formGrid;

    /**
     * 标签宽度
     */
    protected Integer labelWidth;

    /**
     * 组件尺寸
     */
    protected String componentSize;

    /**
     * 默认值
     */
    protected Object defaultValue;

    /**
     * 按钮图标
     */
    protected String buttonIcon;

    /**
     * 按钮类型
     */
    protected String buttonType;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 是否禁用
     */
    protected Boolean disabled;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.BUTTON.getCode();
    }
}
