package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.IRow;
import org.tiankafei.poi.model.IRows;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class RowsVo implements IRows {

    private Integer rowCount;

    private List<IRow> rowList;

    @Override
    public void addRow(IRow row) {
        if (rowList == null) {
            rowList = Lists.newArrayList();
        }
        rowList.add(row);
    }
}
