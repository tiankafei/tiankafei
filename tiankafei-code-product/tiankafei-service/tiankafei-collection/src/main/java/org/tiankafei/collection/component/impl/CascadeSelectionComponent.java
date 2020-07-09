package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.CascadeSelectionComponentBeanInfo;

/**
 * 级联选择
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class CascadeSelectionComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new CascadeSelectionComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.CASCADE_SELECTION;
    }

}
