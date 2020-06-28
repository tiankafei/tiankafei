package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.ICell;
import org.tiankafei.poi.model.IRow;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class RowVo implements IRow {

    private Integer rowIndex;

    private List<ICell> cellList;

    @Override
    public void addCell(ICell cell) {
        if (cellList == null) {
            cellList = Lists.newArrayList();
        }
        cellList.add(cell);
    }
}
