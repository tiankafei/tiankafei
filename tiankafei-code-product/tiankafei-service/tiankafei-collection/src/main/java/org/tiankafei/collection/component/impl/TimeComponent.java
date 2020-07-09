package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.TimeComponentBeanInfo;

/**
 * 时间选择
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class TimeComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new TimeComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.TIME.getCode();
    }

}
