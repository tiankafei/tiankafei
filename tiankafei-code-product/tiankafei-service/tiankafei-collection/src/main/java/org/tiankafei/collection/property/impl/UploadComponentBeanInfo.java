package org.tiankafei.collection.property.impl;

import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.UploadComponentProperty;

/**
 * 上传组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class UploadComponentBeanInfo extends BaseComponentProperty implements UploadComponentProperty {
    @Override
    public Integer getComponentType() {
        return ComponentEnum.UPLOAD.getCode();
    }
}
