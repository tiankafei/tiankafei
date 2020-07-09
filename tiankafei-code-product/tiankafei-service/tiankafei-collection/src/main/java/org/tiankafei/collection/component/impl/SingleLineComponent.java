package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.SingleLineComponentBeanInfo;

/**
 * 单行文本
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class SingleLineComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new SingleLineComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.SINGLE_LINE.getCode();
    }

}
