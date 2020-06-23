package cn.tiankafei.poi.model.impl;

import cn.tiankafei.poi.model.ICellStyle;
import cn.tiankafei.poi.model.ICols;
import cn.tiankafei.poi.model.IRows;
import cn.tiankafei.poi.model.ISheet;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class SheetVo implements ISheet {

    private IRows rows;

    private ICols cols;

    private List<ICellStyle> cellStyleList;

    @Override
    public void addCellStyle(ICellStyle cellStyle) {
        if (cellStyleList == null) {
            cellStyleList = Lists.newArrayList();
        }
        cellStyleList.add(cellStyle);
    }
}
