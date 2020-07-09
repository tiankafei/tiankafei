package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.component.CollectionComponent;

/**
 * 级联选择
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class CascadeSelectionComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.CASCADE_SELECTION.getCode();
    }

}
