package cn.tiankafei.poi.model.impl;

import cn.tiankafei.poi.model.ICell;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class CellVo implements ICell {

    private Integer colIndex;

    private Integer styleIndex;

    private Object value;

}
