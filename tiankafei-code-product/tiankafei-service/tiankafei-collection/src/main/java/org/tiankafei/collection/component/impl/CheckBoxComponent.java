package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.CheckBoxComponentBeanInfo;

/**
 * 多选框组
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class CheckBoxComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new CheckBoxComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.CHECK_BOX;
    }

}
