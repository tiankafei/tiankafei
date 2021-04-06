package org.tiankafei.ui.control.tabletree.renderer;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.tiankafei.common.enums.DataTypeEnum;
import org.tiankafei.common.util.LogUtil;
import org.tiankafei.ui.control.TiankafeiTreeTableControls;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;

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
    private TiankafeiTreeTableControls tkfTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 鼠标移动时落在的当前行
     */
    private int currentRow = -1;

    /**
     * 构造自定义的表格的渲染对象
     *
     * @param tkfTable                  自定义表格对象
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     */
    public TiankafeiTableCellRenderer(TiankafeiTreeTableControls tkfTable, TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        this.tkfTable = tkfTable;
        this.tiankafeiTableAttributeVO = tiankafeiTableAttributeVO;
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
            //当前表格列没有绑定控件类型的时候，不做任何处理(因为控件有单独的表格渲染器)
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_NO == tableColumnDTO.getControlsType()) {
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
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_COMBOBOX == tableColumnDTO.getControlsType()) {
                setHorizontalAlignment(TiankafeiDesignerConstants.SWING_LEFT);
            }
        } else {
            LogUtil.error("表格渲染失败，原因是:当前列号大于表格中的列的总数量！");
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //鼠标移动的过程中上一行
        int previousRow = currentRow;
        repaint(previousRow);

        Point point = e.getPoint();
        currentRow = tkfTable.rowAtPoint(point);
        repaint(currentRow);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int previousRow = currentRow;
        repaint(previousRow);
        //还原鼠标所在的行
        currentRow = -1;
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