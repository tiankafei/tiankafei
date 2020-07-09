package org.tiankafei.collection.service.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.service.CollectionComponent;

/**
 * 计数器
 *
 * @author 魏双双
 * @since 1.0
 **/
public class CounterComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.COUNTER.getCode();
    }

}
