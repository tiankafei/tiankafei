package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.PasswordComponentProperty;

/**
 * 密码组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PasswordComponentBeanInfo extends SingleLineComponentBeanInfo implements PasswordComponentProperty {

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.PASSWORD.getCode();
    }
}
