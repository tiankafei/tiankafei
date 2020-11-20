package org.tiankafei.poi.model.impl;

import lombok.Data;
import org.tiankafei.poi.model.RowData;
import org.tiankafei.poi.model.SheetData;

import java.util.List;

/**
 * @author 甜咖啡
 */
@Data
public class SheetDataVo implements SheetData {

    private Integer index;

    private String name;

    private List<RowData> rowDataList;

    public SheetDataVo(Integer index, String name){
        this.index = index;
        this.name = name;
    }

}
