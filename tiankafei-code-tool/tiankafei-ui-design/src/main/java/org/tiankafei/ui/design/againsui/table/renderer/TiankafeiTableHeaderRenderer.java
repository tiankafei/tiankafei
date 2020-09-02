package org.tiankafei.ui.design.againsui.table.renderer;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;

/**
 * 表格头部渲染器
 *
 * @author 甜咖啡
 */
public class TiankafeiTableHeaderRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 2647729037720314565L;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 构造表格头部渲染器
     *
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     */
    public TiankafeiTableHeaderRenderer(TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        this.tiankafeiTableAttributeVO = tiankafeiTableAttributeVO;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBackground(tiankafeiTableAttributeVO.getTableHeaderBackgroundColor());
        this.setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);

        Dimension dimension = getPreferredSize();
        dimension.height = tiankafeiTableAttributeVO.getTableHeaderHeight();
        setPreferredSize(dimension);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, tiankafeiTableAttributeVO.getTableHeaderBorderBackgroundColor()));
        return component;
    }

}
