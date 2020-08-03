package org.tiankafei.collection.property.impl;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SelectionComponentProperty;

/**
 * 下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SelectionComponentBeanInfo extends InputComponentProperty implements SelectionComponentProperty {

    /**
     * 是否可以搜索
     */
    protected Boolean searchabled;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

    /**
     * 选项列表
     */
    protected List<CodeNameVo> codeNameList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SELECTION.getCode();
    }
}
