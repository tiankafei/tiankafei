package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.MultiLineComponentProperty;

import java.util.List;

/**
 * 多行文本组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class MultiLineComponentBeanInfo extends InputComponentProperty implements MultiLineComponentProperty {

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
     * 最小行数
     */
    protected Integer minRowCount;

    /**
     * 最大行数
     */
    protected Integer maxRowCount;

//    /**
//     * 前缀
//     */
//    protected String prefixText;
//
//    /**
//     * 后缀
//     */
//    protected String suffixText;
//
//    /**
//     * 前缀图标
//     */
//    protected String prefixIcon;
//
//    /**
//     * 后缀图标
//     */
//    protected String suffixIcon;

    /**
     * 最大长度
     */
    protected Integer maxLength;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 是否输入统计
     */
    protected Boolean showWordLimit;

//    /**
//     * 能否清空
//     */
//    protected Boolean clearable;

    /**
     * 是否只读
     */
    protected Boolean readonly;

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
        return ComponentTypeEnum.MULTI_LINE.getCode();
    }
}
