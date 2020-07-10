package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.RateComponentProperty;

/**
 * 评分组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class RateComponentBeanInfo extends ChooseComponentProperty implements RateComponentProperty {

    /**
     * 最大值
     */
    protected Integer maxValue;

    /**
     * 允许半选
     */
    protected Boolean showHalfSelect;

    /**
     * 辅助文字
     */
    protected String helpText;

    /**
     * 是否显示分数
     */
    protected Boolean showScore;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.RATE.getCode();
    }
}
