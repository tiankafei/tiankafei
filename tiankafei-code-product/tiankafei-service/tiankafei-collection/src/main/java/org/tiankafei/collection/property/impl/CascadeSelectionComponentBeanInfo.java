package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.CascadeSelectionComponentProperty;

import java.util.List;

/**
 * 级联下拉框组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class CascadeSelectionComponentBeanInfo extends InputComponentProperty implements CascadeSelectionComponentProperty {

    /**
     * 选项分隔符
     */
    protected String itemSplitSymbol;

    /**
     * 数据来源类型
     * TODO 来源
     */
    protected String dataSourceType;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

    /**
     * 是否显示完整路径
     */
    protected Boolean showIntactPath;

    /**
     * 是否可以筛选：搜索
     */
    protected Boolean searchabled;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.CASCADE_SELECTION.getCode();
    }

}
