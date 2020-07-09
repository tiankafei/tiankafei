package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.DateTimeComponentBeanInfo;

/**
 * 日期时间选择
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class DateTimeComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new DateTimeComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.DATE_TIME.getCode();
    }

}
