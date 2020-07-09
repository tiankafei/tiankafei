package org.tiankafei.collection.property.impl;

import lombok.Setter;
import org.tiankafei.collection.property.ComponentProperty;

/**
 * 抽象组件属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Setter
public abstract class BaseComponentProperty implements ComponentProperty {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;


}
