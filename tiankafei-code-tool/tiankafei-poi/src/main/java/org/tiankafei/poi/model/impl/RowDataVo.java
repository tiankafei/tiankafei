package org.tiankafei.poi.model.impl;

import lombok.Data;
import org.tiankafei.poi.model.CellData;
import org.tiankafei.poi.model.RowData;

import java.util.List;

/**
 * @author 甜咖啡
 */
@Data
public class RowDataVo implements RowData {

    private Integer rowIndex;

    private List<CellData> cellDataList;

}
