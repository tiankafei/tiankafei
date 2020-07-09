package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.RadioComponentBeanInfo;

/**
 * 单选框组
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class RadioComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new RadioComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.RADIO.getCode();
    }

}
