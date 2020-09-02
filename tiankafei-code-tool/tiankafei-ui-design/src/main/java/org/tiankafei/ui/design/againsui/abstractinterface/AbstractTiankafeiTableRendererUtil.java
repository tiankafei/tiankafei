package org.tiankafei.ui.design.againsui.abstractinterface;

import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.ControlsVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格渲染工具类
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiTableRendererUtil {

    /**
     * 表格支持选择列时的渲染工具
     *
     * @param tkfTable                  表格对象
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     * @param currentRowIndex           当前行
     * @param currentColumnIndex        当前列
     * @return 控件属性对象
     */
    public abstract ControlsVO getTiankafeiTableChooseRenderer(TkfTable tkfTable, TiankafeiTableAttributeVO tiankafeiTableAttributeVO, int currentRowIndex, int currentColumnIndex);

    /**
     * 表格不支持选择列时的渲染工具
     *
     * @param tkfTable       表格对象
     * @param tableDataModel 表格数据模型对象
     * @param tableColumnDTO 当前表格列对象
     * @param isSelected     当前行选中标识
     * @param hasFocus       当前列选中标识
     * @param row            当前行
     * @param column         当前列
     * @return 控件属性对象
     */
    public abstract ControlsVO getTiankafeiTableNoChooseRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                                 TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column);

    /**
     * 当前表格列是选择序号列时的渲染工具
     *
     * @param tkfTable       表格对象
     * @param tableDataModel 表格数据模型对象
     * @param tableColumnDTO 当前表格列对象
     * @param isSelected     当前行选中标识
     * @param hasFocus       当前列选中标识
     * @param row            当前行
     * @param column         当前列
     * @return 控件属性对象
     */
    public abstract ControlsVO getTiankafeiTableColumnNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                                     TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column);

    /**
     * 当前表格列不是选择序号列时的渲染工具
     *
     * @param tkfTable       表格对象
     * @param tableDataModel 表格数据模型对象
     * @param tableColumnDTO 当前表格列对象
     * @param isSelected     当前行选中标识
     * @param hasFocus       当前列选中标识
     * @param row            当前行
     * @param column         当前列
     * @return 控件属性对象
     */
    public abstract ControlsVO getTiankafeiTableColumnNoNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                                       TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column);

}
