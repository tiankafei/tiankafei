package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.property.ComponentProperty;

/**
 * 选择型组件
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public abstract class BaseLayoutComponentProperty implements ComponentProperty {
}
