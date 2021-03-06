package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.ColorComponentBeanInfo;

/**
 * 颜色选择
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class ColorComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new ColorComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.COLOR;
    }

}
