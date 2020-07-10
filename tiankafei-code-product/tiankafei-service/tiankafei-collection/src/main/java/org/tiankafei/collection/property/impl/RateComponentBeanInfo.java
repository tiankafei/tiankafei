package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.RateComponentProperty;

/**
 * 评分组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class RateComponentBeanInfo extends BaseComponentProperty implements RateComponentProperty {

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
     * 最大值
     */
    protected Integer maxValue;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 允许半选
     */
    protected Boolean showHalfSelect;

    /**
     * 辅助文字
     */
    protected String helpText;

    /**
     * 是否显示分数
     */
    protected Boolean showScore;

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
        return ComponentTypeEnum.RATE.getCode();
    }
}
