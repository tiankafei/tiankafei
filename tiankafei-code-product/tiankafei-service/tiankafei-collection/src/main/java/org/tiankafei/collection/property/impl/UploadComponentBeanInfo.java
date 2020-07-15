package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.UploadComponentProperty;

/**
 * 上传组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UploadComponentBeanInfo extends ChooseComponentProperty implements UploadComponentProperty {

    /**
     * 文件字段名
     */
    protected String fileFieldName;

    /**
     * 文件类型
     */
    protected String fileType;

    /**
     * 上传地址
     */
    protected String uploadAddress;

    /**
     * 列表类型
     */
    protected String listType;

    /**
     * 自动上传
     */
    protected Boolean autoUpload;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.UPLOAD.getCode();
    }
}
