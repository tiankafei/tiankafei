package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.ButtonComponentBeanInfo;

/**
 * 按钮
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class ButtonComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new ButtonComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.BUTTON;
    }

}
