package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.PasswordComponentBeanInfo;

/**
 * 多行文本
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class PasswordComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new PasswordComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.PASSWORD;
    }

}
