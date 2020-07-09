package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.ColProperty;
import org.tiankafei.poi.property.ColsProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class ColsBeanInfo implements ColsProperty {

    private Integer length;

    private List<ColProperty> colList;

}
