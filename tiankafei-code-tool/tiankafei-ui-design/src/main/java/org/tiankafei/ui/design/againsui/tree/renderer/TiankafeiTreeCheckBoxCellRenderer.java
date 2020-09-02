package org.tiankafei.ui.design.againsui.tree.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfCheckBox;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树复选渲染器
 *
 * @author tiankafei1
 */
public class TiankafeiTreeCheckBoxCellRenderer extends TkfCheckBox implements TreeCellRenderer {

    private static final long serialVersionUID = 9182811326541852239L;

    /**
     * 前景色
     */
    private Color foregroundColor;

    /**
     * 构造自定义树复选渲染器
     *
     * @param foregroundColor 前景色
     */
    public TiankafeiTreeCheckBoxCellRenderer(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        setOpaque(false);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (value instanceof TkfTreeNode) {
            TkfTreeNode tkfTreeNode = (TkfTreeNode) value;
            TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tkfTreeNode.getTiankafeiTreeNodeAttributeVO();
            /** 设置CheckBox所展示的文本。*/
            setText(tiankafeiTreeNodeAttributeVO.getUserObject().toString());
            if (tiankafeiTreeNodeAttributeVO.isNodeCheckedFlag()) {
                setSelected(true);
                //设置节点选中时的前景色
                setForeground(tiankafeiTreeNodeAttributeVO.getNodeChooseColor());
            } else {
                setSelected(false);
                setForeground(foregroundColor);
            }
        }
        return this;
    }
}