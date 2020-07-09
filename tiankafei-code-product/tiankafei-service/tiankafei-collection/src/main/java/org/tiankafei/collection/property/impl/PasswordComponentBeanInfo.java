package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.PasswordComponentProperty;

/**
 * 密码组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class PasswordComponentBeanInfo extends BaseComponentProperty implements PasswordComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.PASSWORD.getCode();
    }
}
