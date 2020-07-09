package org.tiankafei.collection.service.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.service.CollectionComponent;

/**
 * 下拉选择框
 *
 * @author 魏双双
 * @since 1.0
 **/
public class SelectionComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.SELECTION.getCode();
    }

}
