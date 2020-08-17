package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.EditComponentProperty;

/**
 * 编辑器组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class EditComponentBeanInfo extends BaseInputComponentProperty implements EditComponentProperty {

    /**
     * 组件高度
     */
    protected Integer componentHeight;

    /**
     * 水印，可以是字符串，也可以是logo图片的地址
     */
    protected String watermark;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.EDIT.getCode();
    }
}
