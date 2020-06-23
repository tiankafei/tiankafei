package cn.tiankafei.poi.model.impl;

import cn.tiankafei.poi.model.IBorder;
import cn.tiankafei.poi.model.ICellStyle;
import cn.tiankafei.poi.model.IFont;
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
