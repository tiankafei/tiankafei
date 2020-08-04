package org.tiankafei.collection.property.impl;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.ComponentProperty;

/**
 * 抽象组件属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public abstract class BaseComponentProperty implements ComponentProperty {

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
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 是否禁用
     */
    protected Boolean disabled;

    /**
     * 正则表达式集合
     */
    protected List<RegularExpressionVo> regularExpressionVoList;

}
