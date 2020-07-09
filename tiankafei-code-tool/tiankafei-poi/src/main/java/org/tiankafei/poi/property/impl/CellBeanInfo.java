package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.CellProperty;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class CellBeanInfo implements CellProperty {

    private Integer colIndex;

    private Integer styleIndex;

    private Object value;

}
