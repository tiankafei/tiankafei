package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.FontProperty;
import lombok.Data;

import java.awt.Color;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class FontBeanInfo implements FontProperty {

    protected int underline;

    protected int typeOffset;

    protected boolean bold;

    protected int charSet;

    protected Color color;

    protected int fontSize;

    protected String fontName;

    protected boolean italic;

    protected boolean strikeout;

}
