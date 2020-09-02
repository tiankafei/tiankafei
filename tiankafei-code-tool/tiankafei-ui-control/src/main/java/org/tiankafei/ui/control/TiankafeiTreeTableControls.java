package org.tiankafei.ui.control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.EventObject;
import java.util.List;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.tabletree.ITiankafeiTreeTableModel;
import org.tiankafei.ui.control.tabletree.TiankafeiTreeTableModel;
import org.tiankafei.ui.control.tabletree.TiankafeiTreeTableModelAdapter;
import org.tiankafei.ui.control.tabletree.editor.TiankafeiTreeTableCellEditor;
import org.tiankafei.ui.control.tabletree.renderer.TiankafeiTableCellRenderer;
import org.tiankafei.ui.control.tabletree.util.TiankafeiListToTreeSelectionModel;
import org.tiankafei.ui.design.againsui.table.renderer.TiankafeiTableHeaderRenderer;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeCellRenderer;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeCheckBoxCellRenderer;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeRadioCellRenderer;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;
import org.tiankafei.ui.design.modelsui.TkfTree;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 树型表格控件对象
 *
 * @author tiankafei1
 */
public class TiankafeiTreeTableControls extends JTable {

    private static final long serialVersionUID = -97979366540149622L;

    /**
     * 自定义表格树当中的树对象
     */
    protected TkfTreeTableCellRenderer tree;

    /**
     * 自定义树属性对象
     */
    private TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 自定义树型表格数据模型
     */
    private TiankafeiTreeTableModel tiankafeiTreeTableModel;

    /**
     * 构造树型表格控件对象
     *
     * @param tiankafeiTreeAttributeVO  自定义树属性对象
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     * @throws BaseException 自定义异常
     */
    public TiankafeiTreeTableControls(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO, TiankafeiTableAttributeVO tiankafeiTableAttributeVO) throws BaseException {
        super();
        this.tiankafeiTreeAttributeVO = tiankafeiTreeAttributeVO;
        this.tiankafeiTableAttributeVO = tiankafeiTableAttributeVO;
        //验证控件参数是否足够使用返回的消息
        String message = checkControlsParam(tiankafeiTreeAttributeVO, tiankafeiTableAttributeVO);
        if (StringUtils.isNotEmpty(message)) {
            throw new BaseException(message);
        }
        tiankafeiTreeAttributeVO.setTreeRowHeight(tiankafeiTableAttributeVO.getTableRowHeight());

        //构造自定义树型表格数据模型
        tiankafeiTreeTableModel = new TiankafeiTreeTableModel(tiankafeiTreeAttributeVO, tiankafeiTableAttributeVO);
        //构造自定义表格树当中的树对象
        tree = new TkfTreeTableCellRenderer(tiankafeiTreeTableModel);
        //构造自定义树型表格模型适配器
        TiankafeiTreeTableModelAdapter tiankafeiTreeTableModelAdapter = new TiankafeiTreeTableModelAdapter(tiankafeiTreeTableModel, tree);
        this.setModel(tiankafeiTreeTableModelAdapter);
        tiankafeiTableAttributeVO.setTableDataModel(tiankafeiTreeTableModelAdapter);
        //设置表格属性
        this.setTableParam();
        //设置表格列宽
        this.seTableColumnWidth();

        //构造自定义树选择模型
        TiankafeiListToTreeSelectionModel tiankafeiListToTreeSelectionModel = new TiankafeiListToTreeSelectionModel(tree);
        tree.setSelectionModel(tiankafeiListToTreeSelectionModel);
        this.setSelectionModel(tiankafeiListToTreeSelectionModel.getListSelectionModel());

        //设置树属性
        setTreeParam();
    }

    /**
     * 验证控件参数是否足够使用
     *
     * @param tiankafeiTreeAttributeVO  自定义树属性对象
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     * @return 返回验证的错误信息
     */
    private String checkControlsParam(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO, TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        StringBuffer checkBuffer = new StringBuffer();
        if (tiankafeiTreeAttributeVO.getTreeTableRootDTO() == null) {
            checkBuffer.append("表格树控件根节点不能为空\n");
        }
        if (CollectionUtils.isEmpty(tiankafeiTreeAttributeVO.getTreeList())) {
            checkBuffer.append("表格树控件数据集合不能为空\n");
        }
        if (CollectionUtils.isEmpty(tiankafeiTableAttributeVO.getTableColumnList())) {
            checkBuffer.append("表格树控件表格列集合不能为空\n");
        }
        if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
            checkBuffer.append("表格树控件表格属性不支持可选择\n");
        }
        if (tiankafeiTreeAttributeVO.isTreeChooseFlag()) {
            checkBuffer.append("表格树控件树属性不支持可选择\n");
        }
        return checkBuffer.toString();
    }

    /**
     * 设置表格属性
     */
    private void setTableParam() {
        //设置表格选定方式
        setSelectionMode(tiankafeiTableAttributeVO.getTableSelectionMode());
        //设置表格行高
        setRowHeight(tiankafeiTableAttributeVO.getTableRowHeight());
        //设置表格行间距
        setRowMargin(tiankafeiTableAttributeVO.getTableRowMargin());
        //设置表格水平线
        setShowHorizontalLines(tiankafeiTableAttributeVO.isTableShowHorizontalLineFlag());
        //设置表格垂直线
        setShowVerticalLines(tiankafeiTableAttributeVO.isTableShowVerticalLineFlag());
        //不自动调整列的宽度；使用滚动条
        setAutoResizeMode(TkfTable.AUTO_RESIZE_OFF);
        //设置点击时的背景色
        setSelectionBackground(tiankafeiTableAttributeVO.getTableClickBackgroundColor());
        //获取表格头部对象
        JTableHeader tkfTableHeader = getTableHeader();
        //表格头部设置背景色
        tkfTableHeader.setBackground(tiankafeiTableAttributeVO.getTableHeaderBackgroundColor());
        //表格头部设置前景色
        tkfTableHeader.setForeground(tiankafeiTableAttributeVO.getTableHeaderForegroundColor());
        //不可整列移动
        tkfTableHeader.setReorderingAllowed(false);
        //表格头部居中显示
        DefaultTableCellRenderer tableCellRenderer = (DefaultTableCellRenderer) tkfTableHeader.getDefaultRenderer();
        tableCellRenderer.setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        //设置表格渲染
        TiankafeiTableCellRenderer tiankafeiTableCellRenderer = new TiankafeiTableCellRenderer(this, tiankafeiTableAttributeVO);
        setDefaultRenderer(Object.class, tiankafeiTableCellRenderer);
        addMouseListener(tiankafeiTableCellRenderer);
        addMouseMotionListener(tiankafeiTableCellRenderer);

        this.setDefaultRenderer(ITiankafeiTreeTableModel.class, tree);
        this.setDefaultEditor(ITiankafeiTreeTableModel.class, new TiankafeiTreeTableCellEditor(tree, this));
        this.setIntercellSpacing(new Dimension(0, 0));
    }

    /**
     * 设置表格列宽
     */
    private void seTableColumnWidth() {
        TableColumnModel tableColumnModel = getColumnModel();
        //自定义表格列对象集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        for (int tableColumnIndex = 0, tableColumnLength = tableColumnList.size(); tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(tableColumnIndex);
            //当前列对象
            TableColumn tableColumn = tableColumnModel.getColumn(tableColumnIndex);
            //表格列是否隐藏
            boolean tableColumnHiddenFlag = tableColumnDTO.getHiddenFlag();
            if (tableColumnHiddenFlag) {
                //需要隐藏
                tableColumn.setWidth(0);
                tableColumn.setPreferredWidth(0);
                tableColumn.setMinWidth(0);
                tableColumn.setMaxWidth(0);
            } else {
                //表格最大列宽
                int tableColumnMaxWidth = tableColumnDTO.getMaxWidth();
                //表格最小列宽
                int tableColumnMinWidth = tableColumnDTO.getMinWidth();
                //表格列宽
                int tableColumnWidth = tableColumnDTO.getWidth();
                if (tableColumnWidth != 0) {
                    //设置列宽
                    tableColumn.setWidth(tableColumnWidth);
                    tableColumn.setPreferredWidth(tableColumnWidth);
                    //设置最大列
                    if (tableColumnMaxWidth != 0) {
                        if (tableColumnMaxWidth > tableColumnWidth) {
                            tableColumn.setMaxWidth(tableColumnMaxWidth);
                        }
                    }
                    //设置最小列
                    if (tableColumnMinWidth < tableColumnWidth) {
                        tableColumn.setMinWidth(tableColumnMinWidth);
                    }
                }
            }

            TiankafeiTableHeaderRenderer tiankafeiTableHeaderRenderer = new TiankafeiTableHeaderRenderer(tiankafeiTableAttributeVO);
            tableColumn.setHeaderRenderer(tiankafeiTableHeaderRenderer);
        }
    }

    /**
     * 设置树属性
     */
    private void setTreeParam() {
        tree.setRowHeight(tiankafeiTreeAttributeVO.getTreeRowHeight());
        //设置树渲染
        if (tiankafeiTreeAttributeVO.isTreeChooseFlag()) {
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tree.setCellRenderer(new TiankafeiTreeCheckBoxCellRenderer(Color.BLACK));
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tree.setCellRenderer(new TiankafeiTreeRadioCellRenderer(Color.BLACK));
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_NO == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tree.setCellRenderer(new TiankafeiTreeCellRenderer(tiankafeiTreeAttributeVO));
            }
        } else {
            tree.setCellRenderer(new TiankafeiTreeCellRenderer(tiankafeiTreeAttributeVO));
        }

        TkfTreeNode rootTkfTreeNode = (TkfTreeNode) tiankafeiTreeTableModel.getRoot();
        expandTreePath(rootTkfTreeNode);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0) {
            return true;
        } else {
            //数据列
            return false;
        }
    }

    /**
     * 展开树节点
     *
     * @param tkfTreeNode 自定义树节点对象
     */
    private void expandTreePath(TkfTreeNode tkfTreeNode) {
        int childCount = tkfTreeNode.getChildCount();
        if (childCount > 0) {
            TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tkfTreeNode.getTiankafeiTreeNodeAttributeVO();
            if (tiankafeiTreeNodeAttributeVO.isExpandPathFlag()) {
                tree.expandPath(new TreePath(tkfTreeNode.getPath()));
            }
            for (int i = 0; i < childCount; i++) {
                TkfTreeNode tempTkfTreeNode = (TkfTreeNode) tkfTreeNode.getChildAt(i);
                //展开子节点
                expandTreePath(tempTkfTreeNode);
            }
        }
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (tree != null) {
            tree.updateUI();
            setDefaultEditor(ITiankafeiTreeTableModel.class, new TiankafeiTreeTableCellEditor(tree, this));
        }
    }

    @Override
    public int getEditingRow() {
        return (getColumnClass(editingColumn) == ITiankafeiTreeTableModel.class) ? -1 : editingRow;
    }

    /**
     * 获取真实编辑的行
     *
     * @return 真实编辑的行
     */
    private int realEditingRow() {
        return editingRow;
    }

    @Override
    public void sizeColumnsToFit(int resizingColumn) {
        super.sizeColumnsToFit(resizingColumn);
        if (getEditingColumn() != -1 && getColumnClass(editingColumn) == ITiankafeiTreeTableModel.class) {
            Rectangle cellRect = getCellRect(realEditingRow(), getEditingColumn(), false);
            Component component = getEditorComponent();
            component.setBounds(cellRect);
            component.validate();
        }
    }

    @Override
    public void setRowHeight(int rowHeight) {
        super.setRowHeight(rowHeight);
        if (tree != null && tree.getRowHeight() != rowHeight) {
            tree.setRowHeight(getRowHeight());
        }
    }

    @Override
    public boolean editCellAt(int row, int column, EventObject e) {
        boolean retValue = super.editCellAt(row, column, e);
        if (retValue && getColumnClass(column) == ITiankafeiTreeTableModel.class) {
            repaint(getCellRect(row, column, false));
        }
        return retValue;
    }

    /**
     * 自定义表格树当中的树对象
     *
     * @author tiankafei1
     */
    public class TkfTreeTableCellRenderer extends TkfTree implements TableCellRenderer {

        private static final long serialVersionUID = -6798039492228262353L;

        /**
         * 可见行
         */
        protected int visibleRow;

        /**
         * 树边框
         */
        protected Border treeBorder;

        /**
         * 构造自定义表格树当中的树对象
         *
         * @param model 表格树中树的数据模型
         */
        public TkfTreeTableCellRenderer(TreeModel model) {
            super(model);
        }

        @Override
        public void updateUI() {
            super.updateUI();
            TreeCellRenderer tcr = getCellRenderer();
            if (tcr instanceof DefaultTreeCellRenderer) {
                DefaultTreeCellRenderer dtcr = ((DefaultTreeCellRenderer) tcr);
                dtcr.setTextSelectionColor(getSelectionForeground());
                dtcr.setBackgroundSelectionColor(getSelectionBackground());
            }
        }

        @Override
        public void setRowHeight(int rowHeight) {
            if (rowHeight > 0) {
                super.setRowHeight(rowHeight);
                if (TiankafeiTreeTableControls.this != null && getRowHeight() != rowHeight) {
                    setRowHeight(getRowHeight());
                }
            }
        }

        @Override
        public void setBounds(int x, int y, int w, int h) {
            super.setBounds(x, 0, w, TiankafeiTreeTableControls.this.getHeight());
        }

        @Override
        public void paint(Graphics g) {
            g.translate(0, -visibleRow * getRowHeight());
            super.paint(g);
            if (treeBorder != null) {
                treeBorder.paintBorder(this, g, 0, visibleRow * getRowHeight(), getWidth(), getRowHeight());
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Color background = null;
            Color foreground = null;

            if (isSelected) {
                background = table.getSelectionBackground();
                foreground = table.getSelectionForeground();
            } else {
                background = table.getBackground();
                foreground = table.getForeground();
            }
            treeBorder = null;
            if (realEditingRow() == row && getEditingColumn() == column) {
                background = table.getBackground();
                foreground = table.getForeground();
            } else if (hasFocus) {
                treeBorder = UIManager.getBorder("Table.focusCellHighlightBorder");
                if (isCellEditable(row, column)) {
                    background = table.getBackground();
                    foreground = table.getForeground();
                }
            }

            visibleRow = row;
            setBackground(background);

            TreeCellRenderer tcr = getCellRenderer();
            if (tcr instanceof DefaultTreeCellRenderer) {
                DefaultTreeCellRenderer dtcr = ((DefaultTreeCellRenderer) tcr);
                if (isSelected) {
                    dtcr.setTextSelectionColor(foreground);
                    dtcr.setBackgroundSelectionColor(background);
                } else {
                    dtcr.setTextNonSelectionColor(foreground);
                    dtcr.setBackgroundNonSelectionColor(background);
                }
            }
            return this;
        }

    }

}
