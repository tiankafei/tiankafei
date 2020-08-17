package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 选择型组件
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public abstract class BaseChooseComponentProperty extends BaseComponentProperty {

    /**
     * 能否清空
     */
    protected Boolean clearable;

    /**
     * 是否必填
     */
    protected Boolean required;

    /**
     * 是否只读
     */
    protected Boolean readonly;

}
