package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.CascadeSelectionComponentProperty;

/**
 * 级联下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class CascadeSelectionComponentBeanInfo extends BaseComponentProperty implements CascadeSelectionComponentProperty {

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
     * 选项分隔符
     */
    protected String itemSplitSymbol;

    /**
     * 数据来源类型
     * TODO 来源
     */
    protected String dataSourceType;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

    /**
     * 是否显示完整路径
     */
    protected Boolean showIntactPath;

    /**
     * 是否可以筛选：搜索
     */
    protected Boolean searchabled;

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
        return ComponentTypeEnum.CASCADE_SELECTION.getCode();
    }

}
