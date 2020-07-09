package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.BorderProperty;
import org.tiankafei.poi.property.CellStyleProperty;
import org.tiankafei.poi.property.FontProperty;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class CellStyleBeanInfo implements CellStyleProperty {

    protected BorderProperty border;

    protected FontProperty font;

}
