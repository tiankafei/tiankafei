package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.SelectionComponentBeanInfo;

/**
 * 下拉选择框
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class SelectionComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new SelectionComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.SELECTION.getCode();
    }

}
