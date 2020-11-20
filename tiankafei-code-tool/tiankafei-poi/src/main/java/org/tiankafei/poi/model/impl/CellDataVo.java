package org.tiankafei.poi.model.impl;

import lombok.Data;
import org.tiankafei.poi.model.CellData;

/**
 * @author 甜咖啡
 */
@Data
public class CellDataVo implements CellData {

    private Integer colIndex;

    private String viewValue;

    private Integer styleIndex;

}
