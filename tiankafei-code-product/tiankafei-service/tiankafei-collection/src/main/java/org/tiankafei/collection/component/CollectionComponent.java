package org.tiankafei.collection.component;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.ComponentProperty;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface CollectionComponent {

    /**
     * 创建组件属性
     * @return
     */
    ComponentProperty createComponentProperty();

    /**
     * 获取组件类型
     * @return
     */
    ComponentTypeEnum getComponentType();

}
