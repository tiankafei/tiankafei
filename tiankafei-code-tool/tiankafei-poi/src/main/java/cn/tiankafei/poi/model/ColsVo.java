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
public class ColsVo {

    private Integer length;

    private List<ColVo> colList;

}
