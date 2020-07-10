package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.MultiLineComponentProperty;

/**
 * 多行文本组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class MultiLineComponentBeanInfo extends InputComponentProperty implements MultiLineComponentProperty {

    /**
     * 最小行数
     */
    protected Integer minRowCount;

    /**
     * 最大行数
     */
    protected Integer maxRowCount;

    /**
     * 最大长度
     */
    protected Integer maxLength;

    /**
     * 是否输入统计
     */
    protected Boolean showWordLimit;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.MULTI_LINE.getCode();
    }
}
