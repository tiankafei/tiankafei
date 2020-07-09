package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.component.CollectionComponent;
import org.tiankafei.collection.enums.ComponentEnum;

/**
 * 颜色选择
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class ColorComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.COLOR.getCode();
    }

}
