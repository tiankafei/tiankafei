package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.SingleLineComponentBeanInfo;

/**
 * 单行文本
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class SingleLineComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new SingleLineComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.SINGLE_LINE;
    }

}
