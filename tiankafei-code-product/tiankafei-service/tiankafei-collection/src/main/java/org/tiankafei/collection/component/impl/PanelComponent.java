package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.PanelComponentBeanInfo;

/**
 * 面板
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class PanelComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new PanelComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.PANEL;
    }

}
