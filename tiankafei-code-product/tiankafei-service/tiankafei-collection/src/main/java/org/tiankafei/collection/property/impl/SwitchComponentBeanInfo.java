package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.SwitchComponentProperty;

/**
 * 开关组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SwitchComponentBeanInfo extends ChooseComponentProperty implements SwitchComponentProperty {

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
     * 组件宽度
     */
    protected Double componentWidth;

    /**
     * 默认值
     */
    protected Object defaultValue;

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

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 能否清空
     */
    protected Boolean clearable;

    /**
     * 是否禁用
     */
    protected Boolean disabled;

    /**
     * 是否必填
     */
    protected Boolean required;

    /**
     * 正则表达式集合
     */
    protected List<RegularExpressionVo> regularExpressionVoList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SWITCH.getCode();
    }
}
