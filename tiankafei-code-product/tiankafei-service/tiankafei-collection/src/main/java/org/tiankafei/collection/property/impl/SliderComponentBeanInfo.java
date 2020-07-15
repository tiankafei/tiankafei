package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SliderComponentProperty;

/**
 * 滑块组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SliderComponentBeanInfo extends ChooseComponentProperty implements SliderComponentProperty {

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
    protected Integer step;

    /**
     * 显示间隔断点
     */
    protected Boolean showInterval;

    /**
     * 是否范围选择
     */
    protected Boolean showRangeSelection;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SLIDER.getCode();
    }
}
