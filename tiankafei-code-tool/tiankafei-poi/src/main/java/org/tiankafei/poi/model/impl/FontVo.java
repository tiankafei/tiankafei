package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.IFont;
import lombok.Data;

import java.awt.Color;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class FontVo implements IFont {

    private int underline;

    private int typeOffset;

    private boolean bold;

    private int charSet;

    private Color color;

    private int fontSize;

    private String fontName;

    private boolean italic;

    private boolean strikeout;

}
