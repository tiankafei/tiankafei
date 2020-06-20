package cn.tiankafei.poi.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class SheetVo {

    private RowsVo rows;

    private ColsVo cols;

    private List<CellStyleVo> cellStyleList;

}
