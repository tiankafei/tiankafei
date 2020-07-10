package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.CheckBoxComponentProperty;

/**
 * 复选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class CheckBoxComponentBeanInfo extends ChooseComponentProperty implements CheckBoxComponentProperty {

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
     * 最少选择
     */
    protected Integer minChoice;

    /**
     * 最多选择
     */
    protected Integer maxChoice;

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
     * 选项列表
     */
    protected List<CodeNameVo> codeNameList;

    /**
     * 正则表达式集合
     */
    protected List<RegularExpressionVo> regularExpressionVoList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.CHECK_BOX.getCode();
    }
}
