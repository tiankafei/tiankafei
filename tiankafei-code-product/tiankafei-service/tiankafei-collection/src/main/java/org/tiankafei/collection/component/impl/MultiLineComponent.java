package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.MultiLineComponentBeanInfo;

/**
 * 多行文本
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class MultiLineComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new MultiLineComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.MULTI_LINE;
    }

}
