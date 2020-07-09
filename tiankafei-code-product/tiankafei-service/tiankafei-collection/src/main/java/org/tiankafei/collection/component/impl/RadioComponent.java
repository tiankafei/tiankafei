package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.component.CollectionComponent;

/**
 * 单选框组
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class RadioComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.RADIO.getCode();
    }

}
