package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.SwitchComponentBeanInfo;

/**
 * 开关
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class SwitchComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new SwitchComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.SWITCH.getCode();
    }

}
