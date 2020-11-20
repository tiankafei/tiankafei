package org.tiankafei.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.model.SheetData;
import org.tiankafei.poi.model.WorkbookData;
import org.tiankafei.poi.model.impl.SheetDataVo;
import org.tiankafei.poi.model.impl.WorkbookDataVo;

/**
 * @author tiankafei
 */
public interface ExcelImport<T> extends Import {

    /**
     * 导入excel
     * @param workbook
     * @return
     */
    T importExcel(Workbook workbook);

    /**
     * 创建workbook数据对象
     * @return
     */
    default WorkbookData createWorkbookData() {
        return new WorkbookDataVo();
    }

    /**
     * 创建execk工作薄数据对象
     * @param index
     * @param name
     * @return
     */
    default SheetData createSheetData(Integer index, String name) {
        return new SheetDataVo(index, name);
    }

}
