package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.RadioComponentProperty;

import java.util.List;

/**
 * 单选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RadioComponentBeanInfo extends ChooseComponentProperty implements RadioComponentProperty {

    /**
     * 选项列表
     */
    protected List<CodeNameVo> codeNameList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.RADIO.getCode();
    }
}
