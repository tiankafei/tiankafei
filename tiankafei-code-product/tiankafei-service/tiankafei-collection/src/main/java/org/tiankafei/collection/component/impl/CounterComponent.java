package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.CounterComponentBeanInfo;

/**
 * 计数器
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class CounterComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new CounterComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.COUNTER.getCode();
    }

}
