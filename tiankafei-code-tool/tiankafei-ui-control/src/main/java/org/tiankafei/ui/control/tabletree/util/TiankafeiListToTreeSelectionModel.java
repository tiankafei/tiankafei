package org.tiankafei.ui.control.tabletree.util;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import org.tiankafei.ui.control.TiankafeiTreeTableControls;

/**
 * 自定义树选择模型
 *
 * @author tiankafei1
 */
public class TiankafeiListToTreeSelectionModel extends DefaultTreeSelectionModel {

    private static final long serialVersionUID = 5698388480790983918L;

    protected boolean updatingListSelectionModel;

    /**
     * 自定义表格树当中的树对象
     */
    private TiankafeiTreeTableControls.TkfTreeTableCellRenderer tree;

    /**
     * 构造自定义树选择模型
     *
     * @param tree 自定义表格树当中的树对象
     */
    public TiankafeiListToTreeSelectionModel(TiankafeiTreeTableControls.TkfTreeTableCellRenderer tree) {
        super();
        this.tree = tree;
        getListSelectionModel().addListSelectionListener(createListSelectionListener());
    }

    /**
     * 获取树选择模型
     *
     * @return 树选择模型
     */
    public ListSelectionModel getListSelectionModel() {
        return listSelectionModel;
    }

    @Override
    public void resetRowSelection() {
        if (!updatingListSelectionModel) {
            updatingListSelectionModel = true;
            try {
                super.resetRowSelection();
            } finally {
                updatingListSelectionModel = false;
            }
        }
    }

    /**
     * 创建树选择模型监听类
     *
     * @return 树选择模型监听类
     */
    protected ListSelectionListener createListSelectionListener() {
        return new ListSelectionHandler();
    }

    protected void updateSelectedPathsFromSelectedRows() {
        if (!updatingListSelectionModel) {
            updatingListSelectionModel = true;
            try {
                int min = listSelectionModel.getMinSelectionIndex();
                int max = listSelectionModel.getMaxSelectionIndex();

                clearSelection();
                if (min != -1 && max != -1) {
                    for (int counter = min; counter <= max; counter++) {
                        if (listSelectionModel.isSelectedIndex(counter)) {
                            TreePath selPath = tree.getPathForRow(counter);

                            if (selPath != null) {
                                addSelectionPath(selPath);
                            }
                        }
                    }
                }
            } finally {
                updatingListSelectionModel = false;
            }
        }
    }

    /**
     * 树选择模型监听类
     *
     * @author tiankafei1
     */
    class ListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            updateSelectedPathsFromSelectedRows();
        }
    }

}
