package org.tiankafei.ui.design.againsui.combobox.windows;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 * 下拉框列表值浮现UI
 *
 * @author tiankafei1
 */
@SuppressWarnings("restriction")
public class TiankafeiToolTipWidthComboBoxUi extends com.sun.java.swing.plaf.windows.WindowsComboBoxUI {

    @Override
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
            private static final long serialVersionUID = 3270495043597561512L;

            @Override
            @SuppressWarnings("unchecked")
            protected JList<Object> createList() {
                return new JList<Object>(comboBox.getModel()) {
                    private static final long serialVersionUID = 850657943967619412L;

                    @Override
                    public void processMouseEvent(MouseEvent e) {
                        if (e.isControlDown()) {
                            e = new MouseEvent((Component) e.getSource(), e.getID(), e.getWhen(),
                                    e.getModifiers() ^ InputEvent.CTRL_MASK, e.getX(), e.getY(),
                                    e.getClickCount(), e.isPopupTrigger());
                        }
                        super.processMouseEvent(e);
                    }

                    @Override
                    @SuppressWarnings("rawtypes")
                    public String getToolTipText(MouseEvent event) {
                        int index = locationToIndex(event.getPoint());
                        if (index != -1) {
                            Object value = getModel().getElementAt(index);
                            ListCellRenderer renderer = getCellRenderer();
                            Component rendererComp = renderer.getListCellRendererComponent(this, value, index, true, false);
                            if (rendererComp.getPreferredSize().width > getVisibleRect().width) {
                                return value == null ? null : value.toString();
                            } else {
                                return null;
                            }
                        }
                        return null;
                    }

                    @Override
                    public Point getToolTipLocation(MouseEvent event) {
                        int index = locationToIndex(event.getPoint());
                        if (index != -1) {
                            Rectangle cellBounds = getCellBounds(index, index);
                            return new Point(cellBounds.x, cellBounds.y);
                        }
                        return null;
                    }
                };
            }
        };
    }

}