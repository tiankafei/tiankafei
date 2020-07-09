package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.enums.ComponentEnum;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.collection.property.impl.UploadComponentBeanInfo;

/**
 * 上传
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class UploadComponent extends BaseCollectionComponent {

    @Override
    public ComponentProperty createComponentProperty() {
        return new UploadComponentBeanInfo();
    }

    @Override
    public Integer getComponentType() {
        return ComponentEnum.UPLOAD.getCode();
    }

}
