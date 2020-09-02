package org.tiankafei.ui.design.againsui.combobox.windows;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 * 下拉框自适应宽度UI
 *
 * @author tiankafei1
 */
public class TiankafeiAutoWidthComboBoxUi extends com.sun.java.swing.plaf.windows.WindowsComboBoxUI {

    @Override
    @SuppressWarnings("unchecked")
    protected ComboPopup createPopup() {
        return new LargerComboPopup(comboBox);
    }

    public class LargerComboPopup extends BasicComboPopup {
        private static final long serialVersionUID = -4554658423678539503L;

        public LargerComboPopup(JComboBox<Object> comboBox) {
            super(comboBox);
        }

        @Override
        public void show() {
            int selectedIndex = comboBox.getSelectedIndex();
            if (selectedIndex == -1) {
                list.clearSelection();
            } else {
                list.setSelectedIndex(selectedIndex);
                list.ensureIndexIsVisible(selectedIndex);
            }

            Insets insets = getInsets();
            Dimension listDim = list.getPreferredSize();
            boolean hasScrollBar = scroller.getViewport().getViewSize().height != listDim.height;
            if (hasScrollBar) {
                JScrollBar scrollBar = scroller.getVerticalScrollBar();
                listDim.width += scrollBar.getPreferredSize().getWidth();
            }

            int width = Math.max(listDim.width, comboBox.getWidth() - (insets.right + insets.left));
            int height = getPopupHeightForRowCount(comboBox.getMaximumRowCount());
            Rectangle popupBounds = computePopupBounds(0, comboBox.getHeight(), width, height);

            Dimension scrollSize = popupBounds.getSize();
            scroller.setMaximumSize(scrollSize);
            scroller.setPreferredSize(scrollSize);
            scroller.setMinimumSize(scrollSize);

            list.revalidate();
            show(comboBox, popupBounds.x, popupBounds.y);
        }
    }

}
