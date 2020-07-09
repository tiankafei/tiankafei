package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.RateComponentBeanInfo;

/**
 * 评分
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class RateComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new RateComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.RATE;
    }

}
