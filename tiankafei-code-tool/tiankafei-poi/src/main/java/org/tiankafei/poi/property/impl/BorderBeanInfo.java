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

    private String borderBottomStyle;

    private String borderTopStyle;

    private String borderLeftStyle;

    private String borderRightStyle;

    private Color borderBottomColor;

    private Color borderTopColor;

    private Color borderLeftColor;

    private Color borderRightColor;

}
