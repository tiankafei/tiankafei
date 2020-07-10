package org.tiankafei.collection.property.impl;

import java.util.List;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.EditComponentProperty;

/**
 * 编辑器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class EditComponentBeanInfo extends BaseComponentProperty implements EditComponentProperty {

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
     * 组件高度
     */
    protected Integer componentHeight;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 水印，可以是字符串，也可以是logo图片的地址
     */
    protected String watermark;

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
        return ComponentTypeEnum.EDIT.getCode();
    }
}
