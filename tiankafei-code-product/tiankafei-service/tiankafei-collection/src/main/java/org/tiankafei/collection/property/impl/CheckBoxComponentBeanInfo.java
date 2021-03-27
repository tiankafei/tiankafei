package org.tiankafei.collection.property.impl;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CheckBoxComponentProperty;

/**
 * 复选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CheckBoxComponentBeanInfo extends BaseChooseComponentProperty implements CheckBoxComponentProperty {

    /**
     * 最少选择
     */
    protected Integer minChoice;

    /**
     * 最多选择
     */
    protected Integer maxChoice;


    /**
     * 选项列表
     */
    protected List<CodeNameDTO> codeNameList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.CHECK_BOX.getCode();
    }
}
