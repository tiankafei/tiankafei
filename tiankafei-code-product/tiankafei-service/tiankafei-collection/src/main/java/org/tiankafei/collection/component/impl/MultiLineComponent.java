package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.MultiLineComponentBeanInfo;

/**
 * 多行文本
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class MultiLineComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new MultiLineComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.MULTI_LINE.getCode();
    }

}
