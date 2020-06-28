package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.IBorder;
import lombok.Data;

import java.awt.Color;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class BorderVo implements IBorder {

    private String borderBottomStyle;

    private String borderTopStyle;

    private String borderLeftStyle;

    private String borderRightStyle;

    private Color borderBottomColor;

    private Color borderTopColor;

    private Color borderLeftColor;

    private Color borderRightColor;

}
