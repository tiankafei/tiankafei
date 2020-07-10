package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.CheckBoxComponentProperty;

import java.util.List;

/**
 * 复选框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class CheckBoxComponentBeanInfo extends ChooseComponentProperty implements CheckBoxComponentProperty {

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
    protected List<CodeNameVo> codeNameList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.CHECK_BOX.getCode();
    }
}
