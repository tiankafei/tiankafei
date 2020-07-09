package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.CellStyleProperty;
import org.tiankafei.poi.property.ColsProperty;
import org.tiankafei.poi.property.RowsProperty;
import org.tiankafei.poi.property.SheetProperty;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class SheetBeanInfo implements SheetProperty {

    private RowsProperty rows;

    private ColsProperty cols;

    private List<CellStyleProperty> cellStyleList;

    @Override
    public void addCellStyle(CellStyleProperty cellStyle) {
        if (cellStyleList == null) {
            cellStyleList = Lists.newArrayList();
        }
        cellStyleList.add(cellStyle);
    }
}
