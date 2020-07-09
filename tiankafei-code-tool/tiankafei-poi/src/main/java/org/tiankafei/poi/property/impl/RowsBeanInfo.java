package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.RowProperty;
import org.tiankafei.poi.property.RowsProperty;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class RowsBeanInfo implements RowsProperty {

    protected Integer rowCount;

    protected List<RowProperty> rowList;

    @Override
    public void addRow(RowProperty row) {
        if (rowList == null) {
            rowList = Lists.newArrayList();
        }
        rowList.add(row);
    }
}
