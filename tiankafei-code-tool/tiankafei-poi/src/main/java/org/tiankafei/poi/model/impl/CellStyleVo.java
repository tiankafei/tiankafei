package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.IBorder;
import org.tiankafei.poi.model.ICellStyle;
import org.tiankafei.poi.model.IFont;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class CellStyleVo implements ICellStyle {

    private IBorder border;

    private IFont font;

}
