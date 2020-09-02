package org.tiankafei.ui.design.againsui.table.editor;

import javax.swing.DefaultCellEditor;
import org.tiankafei.ui.design.modelsui.TkfComboBox;

/**
 * 实现自己的下拉框单元格编辑器
 *
 * @author tiankafei
 */
public class TiankafeiTableComboBoxCellEditor extends DefaultCellEditor {

    private static final long serialVersionUID = 7136076044487239035L;

    public TiankafeiTableComboBoxCellEditor(Object[] items) {
        super(new TkfComboBox<Object>(items));
    }

}
