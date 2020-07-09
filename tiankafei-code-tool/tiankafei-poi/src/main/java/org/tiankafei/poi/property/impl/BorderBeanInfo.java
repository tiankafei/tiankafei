package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.BorderProperty;
import lombok.Data;

import java.awt.Color;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class BorderBeanInfo implements BorderProperty {

    protected String borderBottomStyle;

    protected String borderTopStyle;

    protected String borderLeftStyle;

    protected String borderRightStyle;

    protected Color borderBottomColor;

    protected Color borderTopColor;

    protected Color borderLeftColor;

    protected Color borderRightColor;

}
