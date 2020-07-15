package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CounterComponentProperty;

/**
 * 计数器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CounterComponentBeanInfo extends InputComponentProperty implements CounterComponentProperty {

    /**
     * 最小值
     */
    protected Integer minValue;

    /**
     * 最大值
     */
    protected Integer maxValue;

    /**
     * 步长
     */
    private Integer step;

    /**
     * 精度
     */
    protected Integer accuracy;

    /**
     * 按钮位置
     */
    protected String buttonLocation;

    /**
     * 严格步数
     */
    protected Boolean strictStep;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.COUNTER.getCode();
    }
}
