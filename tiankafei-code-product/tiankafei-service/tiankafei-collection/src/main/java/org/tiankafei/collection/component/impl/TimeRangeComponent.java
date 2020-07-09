package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.TimeRangeComponentBeanInfo;

/**
 * 时间范围选择
 *
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class TimeRangeComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new TimeRangeComponentBeanInfo();
    }

    @Override
    public ComponentTypeEnum getComponentType() {
        return ComponentTypeEnum.TIME_RANGE;
    }

}
