package org.tiankafei.collection.property.impl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.property.SingleLineComponentProperty;

/**
 * 单行文本组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class SingleLineComponentBeanInfo extends InputComponentProperty implements SingleLineComponentProperty {

    /**
     * 前缀
     */
    protected String prefixText;

    /**
     * 后缀
     */
    protected String suffixText;

    /**
     * 前缀图标
     */
    protected String prefixIcon;

    /**
     * 后缀图标
     */
    protected String suffixIcon;

    /**
     * 最大长度
     */
    protected Integer maxLength;

    /**
     * 是否输入统计
     */
    protected Boolean showWordLimit;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.SINGLE_LINE.getCode();
    }
}
