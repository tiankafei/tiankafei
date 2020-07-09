package org.tiankafei.poi.property.impl;

import org.tiankafei.poi.property.SheetProperty;
import org.tiankafei.poi.property.WorkbookProperty;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class WorkbookBeanInfo implements WorkbookProperty {

    protected List<SheetProperty> sheetList;

    @Override
    public void addSheet(SheetProperty sheet) {
        if (sheetList == null) {
            sheetList = Lists.newArrayList();
        }
        sheetList.add(sheet);
    }

}
