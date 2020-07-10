package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 输入型组件
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public abstract class InputComponentProperty extends BaseComponentProperty {

    /**
     * 占位提示
     */
    protected String placeholder;

    /**
     * 是否只读
     */
    protected Boolean readonly;

    /**
     * 能否清空
     */
    protected Boolean clearable;

    /**
     * 是否必填
     */
    protected Boolean required;

}
