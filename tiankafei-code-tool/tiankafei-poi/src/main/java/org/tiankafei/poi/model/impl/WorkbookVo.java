package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.ISheet;
import org.tiankafei.poi.model.IWorkbook;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
public class WorkbookVo implements IWorkbook {

    protected List<ISheet> sheetList;

    @Override
    public void addSheet(ISheet sheet) {
        if (sheetList == null) {
            sheetList = Lists.newArrayList();
        }
        sheetList.add(sheet);
    }

}
