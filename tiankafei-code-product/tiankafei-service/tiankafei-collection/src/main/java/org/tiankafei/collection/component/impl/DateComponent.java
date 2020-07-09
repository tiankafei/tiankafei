package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.DateComponentBeanInfo;

/**
 * 日期选择
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class DateComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new DateComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.DATE;
    }

}
