package org.tiankafei.collection.service.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.service.CollectionComponent;

/**
 * 单选按钮组
 *
 * @author 魏双双
 * @since 1.0
 **/
public class RadioComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.RADIO.getCode();
    }

}
