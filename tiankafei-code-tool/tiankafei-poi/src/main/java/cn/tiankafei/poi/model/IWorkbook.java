package cn.tiankafei.poi.model;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface IWorkbook {

    /**
     * 获取sheet列表
     *
     * @return
     */
    List<ISheet> getSheetList();

    /**
     * 设置sheet列表
     *
     * @param sheetList
     */
    void setSheetList(List<ISheet> sheetList);

    /**
     * 添加sheet
     *
     * @param sheet
     */
    void addSheet(ISheet sheet);

}
