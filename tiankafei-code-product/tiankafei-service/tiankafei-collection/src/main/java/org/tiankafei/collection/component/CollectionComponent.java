package org.tiankafei.collection.component;

import org.tiankafei.collection.property.ComponentProperty;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface CollectionComponent {

    /**
     * 创建组件属性
     */
    ComponentProperty createComponentProperty();

    /**
     * 获取组件类型
     * @return
     */
    Integer getComponentType();

}
