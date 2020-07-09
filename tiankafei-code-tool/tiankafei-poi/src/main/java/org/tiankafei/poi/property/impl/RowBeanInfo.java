package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.CellProperty;
import org.tiankafei.poi.property.RowProperty;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class RowBeanInfo implements RowProperty {

    protected Integer rowIndex;

    protected List<CellProperty> cellList;

    @Override
    public void addCell(CellProperty cell) {
        if (cellList == null) {
            cellList = Lists.newArrayList();
        }
        cellList.add(cell);
    }

}
