package org.tiankafei.collection.service.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.service.CollectionComponent;

/**
 * 级联选择
 *
 * @author 魏双双
 * @since 1.0
 **/
public class CascadeSelectionComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.CASCADE_SELECTION.getCode();
    }

}
