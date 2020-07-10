package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.DateComponentProperety;

/**
 * 日期组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class DateComponentBeanInfo extends InputComponentProperty implements DateComponentProperety {

    /**
     * 时间区间
     */
    protected String timeRange;

    /**
     * 时间类型：日，周，年，月，日期时间
     */
    protected String timeType;

    /**
     * 时间格式
     */
    protected String timeFormat;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.DATE.getCode();
    }
}
