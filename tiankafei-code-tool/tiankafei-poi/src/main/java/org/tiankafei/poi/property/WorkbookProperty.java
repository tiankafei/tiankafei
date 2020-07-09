package org.tiankafei.poi.property;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface WorkbookProperty {

    /**
     * 获取sheet列表
     *
     * @return
     */
    List<SheetProperty> getSheetList();

    /**
     * 设置sheet列表
     *
     * @param sheetList
     */
    void setSheetList(List<SheetProperty> sheetList);

    /**
     * 添加sheet
     *
     * @param sheet
     */
    void addSheet(SheetProperty sheet);

}
