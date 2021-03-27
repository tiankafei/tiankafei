package org.tiankafei.collection.property.impl;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.RadioComponentProperty;

/**
 * 单选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RadioComponentBeanInfo extends BaseChooseComponentProperty implements RadioComponentProperty {

    /**
     * 选项列表
     */
    protected List<CodeNameDTO> codeNameList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.RADIO.getCode();
    }
}
