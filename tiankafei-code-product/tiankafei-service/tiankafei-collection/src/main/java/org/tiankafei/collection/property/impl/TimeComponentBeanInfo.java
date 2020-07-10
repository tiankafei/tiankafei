package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.TimeComponentProperty;

/**
 * 时间组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class TimeComponentBeanInfo extends InputComponentProperty implements TimeComponentProperty {

    /**
     * 时间区间
     */
    protected String timeRange;

    /**
     * 时间格式
     */
    protected String timeFormat;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.TIME.getCode();
    }
}
