package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.EditComponentBeanInfo;
import org.tiankafei.collection.property.impl.NumberComponentBeanInfo;

/**
 * 数字
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class NumberComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new NumberComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.NUMBER;
    }

}
