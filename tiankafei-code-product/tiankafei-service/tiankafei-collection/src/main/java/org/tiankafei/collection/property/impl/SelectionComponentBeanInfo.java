package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.SelectionComponentProperty;

/**
 * 下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class SelectionComponentBeanInfo extends ChooseComponentProperty implements SelectionComponentProperty {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;

    /**
     * 占位提示
     */
    protected String placeholder;

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
     * 是否可以搜索
     */
    protected Boolean searchabled;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

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
        return ComponentTypeEnum.SELECTION.getCode();
    }
}
