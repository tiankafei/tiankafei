package org.tiankafei.ui.design.againsui.table.editor;

import javax.swing.DefaultCellEditor;
import org.tiankafei.ui.design.modelsui.TkfCheckBox;
import org.tiankafei.ui.design.modelsui.TkfRadioButton;

/**
 * 实现自己的单元格编辑器
 *
 * @author tiankafei
 */
public class TiankafeiTableCellEditor extends DefaultCellEditor {

    private static final long serialVersionUID = 2116107781318324905L;

    /**
     * 构造单元格编辑器
     *
     * @param tkfCheckBox 自定义复选框
     */
    public TiankafeiTableCellEditor(TkfCheckBox tkfCheckBox) {
        super(tkfCheckBox);
    }

    /**
     * 构造单元格编辑器
     *
     * @param tkfRadioButton 自定义单选按钮
     * @param tkfCheckBox    自定义复选框
     */
    public TiankafeiTableCellEditor(final TkfRadioButton tkfRadioButton, TkfCheckBox tkfCheckBox) {
        super(tkfCheckBox);

        editorComponent = tkfRadioButton;
        delegate = new EditorDelegate() {

            private static final long serialVersionUID = 2039539459147069845L;

            @Override
            public void setValue(Object value) {
                boolean selected = false;
                if (value instanceof Boolean) {
                    selected = ((Boolean) value).booleanValue();
                } else if (value instanceof String) {
                    selected = "true".equals(value);
                }
                tkfRadioButton.setSelected(selected);
            }

            @Override
            public Object getCellEditorValue() {
                return Boolean.valueOf(tkfRadioButton.isSelected());
            }
        };

        tkfRadioButton.addActionListener(delegate);
        tkfRadioButton.setRequestFocusEnabled(false);
    }

}
