package org.tiankafei.ui.design.againsui.table.renderer;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.base.enums.DataTypeEnum;
import org.tiankafei.base.util.LogUtil;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTiankafeiTableRendererUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableRendererUtil;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义的表格的渲染对象
 *
 * @author tiankafei
 */
public class TiankafeiTableCellRenderer extends DefaultTableCellRenderer implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -6676811971000202769L;

    /**
     * 传入的自定义表格对象
     */
    private TkfTable tkfTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 鼠标移动时落在的当前行
     */
    private int currentRow = -1;

    /**
     * 之前选择的行
     */
    private int beforeSelectRow = -1;

    /**
     * 构造自定义的表格的渲染对象
     *
     * @param tkfTable 自定义表格对象
     */
    public TiankafeiTableCellRenderer(TkfTable tkfTable) {
        this.tkfTable = tkfTable;
        this.tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row == this.currentRow) {
            setBackground(tiankafeiTableAttributeVO.getTableMoveBackgroundColor());
        } else {
            int number = 2;
            if (row % number == 0) {
                setBackground(tiankafeiTableAttributeVO.getTableDoubleRowBackgroundColor());
            } else {
                setBackground(tiankafeiTableAttributeVO.getTableSingleRowBackgroundColor());
            }
        }
        //表格中的所有列集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        if (column < tableColumnList.size()) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(column);
            if (tableColumnDTO.getNumberFlag()) {
                //选择序号列居中对齐
                setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
            } else {
                //当前表格列没有绑定控件类型的时候，不做任何处理(因为控件有单独的表格渲染器)
                if (tableColumnDTO.getControlsType() == TiankafeiDesignerConstants.CHOOSE_TYPE_NO) {
                    int tableColumnDataType = tableColumnDTO.getDataType();
                    if (DataTypeEnum.DATA_TYPE_STRING.getCode() == tableColumnDataType) {
                        //文本左对齐
                        setHorizontalAlignment(TiankafeiDesignerConstants.SWING_LEFT);
                    } else if (DataTypeEnum.DATA_TYPE_DATE.getCode() == tableColumnDataType || DataTypeEnum.DATA_TYPE_BOOLEAN.getCode() == tableColumnDataType) {
                        //时间，真假居中对齐
                        setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
                    } else if (DataTypeEnum.DATA_TYPE_INT.getCode() == tableColumnDataType || DataTypeEnum.DATA_TYPE_DOUBE.getCode() == tableColumnDataType) {
                        //数值右对齐
                        setHorizontalAlignment(TiankafeiDesignerConstants.SWING_RIGHT);
                    }
                } else if (tableColumnDTO.getControlsType() == TiankafeiDesignerConstants.CHOOSE_TYPE_COMBOBOX) {
                    setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
                }
            }
        } else {
            LogUtil.error("表格渲染失败，原因是:当前列号大于表格中的列的总数量！");
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (TiankafeiDesignerConstants.MOUSE_CLICK_LEFT == e.getButton()) {
            Point point = e.getPoint();
            int currentRowIndex = tkfTable.rowAtPoint(point);
            int currentColumnIndex = tkfTable.columnAtPoint(point);

            //表格再次点击取消选择的标识
            if (tiankafeiTableAttributeVO.isTableClickCancelSelectFlag()) {
                if (beforeSelectRow == currentRowIndex) {
                    tkfTable.getSelectionModel().removeSelectionInterval(currentRowIndex, currentRowIndex);
                    List<TkfTable> tkfTableList = tkfTable.getTkfTableList();
                    for (int i = 0, lem = tkfTableList.size(); i < lem; i++) {
                        tkfTableList.get(i).getSelectionModel().removeSelectionInterval(currentRowIndex, currentColumnIndex);
                    }
                    beforeSelectRow = -1;
                } else {
                    beforeSelectRow = currentRowIndex;
                }
            }

            AbstractTiankafeiTableRendererUtil abstractTiankafeiTableRendererUtil = new TiankafeiTableRendererUtil();
            abstractTiankafeiTableRendererUtil.getTiankafeiTableChooseRenderer(tkfTable, tiankafeiTableAttributeVO, currentRowIndex, currentColumnIndex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (tiankafeiTableAttributeVO.isTableMoveFlag()) {
            if (CollectionUtils.isEmpty(tkfTable.getTkfTableList())) {
                mouseMoved(e);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (tiankafeiTableAttributeVO.isTableMoveFlag()) {
            if (CollectionUtils.isEmpty(tkfTable.getTkfTableList())) {
                //鼠标移动的过程中上一行
                int previousRow = currentRow;
                repaint(previousRow);

                Point point = e.getPoint();
                currentRow = tkfTable.rowAtPoint(point);
                repaint(currentRow);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (tiankafeiTableAttributeVO.isTableMoveFlag()) {
            if (CollectionUtils.isEmpty(tkfTable.getTkfTableList())) {
                int previousRow = currentRow;
                repaint(previousRow);
                //还原鼠标所在的行
                currentRow = -1;
            }
        }
    }

    /**
     * 重绘
     *
     * @param previousRow 重绘的行
     */
    private void repaint(int previousRow) {
        if (previousRow != -1) {
            for (int i = 0; i < tkfTable.getColumnCount(); i++) {
                Rectangle rectangle = tkfTable.getCellRect(previousRow, i, false);
                tkfTable.repaint(rectangle);
            }
        }
    }

}