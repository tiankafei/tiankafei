package org.tiankafei.collection.component.impl;

import org.springframework.stereotype.Component;
import org.tiankafei.collection.component.CollectionComponent;
import org.tiankafei.collection.enums.ComponentEnum;

/**
 * 上传
 *
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class UploadComponent implements CollectionComponent {

    @Override
    public Integer getComponentType() {
        return ComponentEnum.UPLOAD.getCode();
    }

}
