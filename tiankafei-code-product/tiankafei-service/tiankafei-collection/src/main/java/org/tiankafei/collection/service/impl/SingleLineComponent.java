package org.tiankafei.collection.service.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.service.CollectionComponent;

/**
 * 单行文本
 *
 * @author 魏双双
 * @since 1.0
 **/
public class SingleLineComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.SINGLE_LINE.getCode();
    }

}
