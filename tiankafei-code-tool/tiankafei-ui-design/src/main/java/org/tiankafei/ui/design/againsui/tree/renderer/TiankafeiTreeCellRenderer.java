package org.tiankafei.ui.design.againsui.tree.renderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;
import org.tiankafei.ui.design.util.ImageIconUtil;

/**
 * 自定义树渲染器
 *
 * @author tiankafei1
 */
public class TiankafeiTreeCellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = 9182811326541852239L;

    /**
     * 自定义树属性对象
     */
    private TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO;

    /**
     * 构造自定义树渲染器
     *
     * @param tiankafeiTreeAttributeVO 自定义树属性对象
     */
    public TiankafeiTreeCellRenderer(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO) {
        this.tiankafeiTreeAttributeVO = tiankafeiTreeAttributeVO;
        setOpaque(false);
//		//设置非选定节点的背景色
//		setBackgroundNonSelectionColor(Color.WHITE);
//		//设置节点在选中状态下的背景色
//		setBackgroundSelectionColor(Color.lightGray);
//		//设置选中状态下节点边框的颜色
//		setBorderSelectionColor(Color.MAGENTA);
//		//设置绘制选中状态下节点文本的颜色
//		setTextSelectionColor(Color.MAGENTA);
        ImageIcon expandImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getExpandIconFilePath(), tiankafeiTreeAttributeVO.getExpandIconWidth(), tiankafeiTreeAttributeVO.getExpandIconHeight());
        setOpenIcon(expandImageIcon);

        ImageIcon closedImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getClosedIconFilePath(), tiankafeiTreeAttributeVO.getClosedIconWidth(), tiankafeiTreeAttributeVO.getClosedIconHeight());
        setClosedIcon(closedImageIcon);

        ImageIcon leafImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getLeafIconFilePath(), tiankafeiTreeAttributeVO.getLeafIconWidth(), tiankafeiTreeAttributeVO.getLeafIconHeight());
        setLeafIcon(leafImageIcon);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component component = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof TkfTreeNode) {
            TkfTreeNode tkfTreeNode = (TkfTreeNode) value;
            TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tkfTreeNode.getTiankafeiTreeNodeAttributeVO();
            /**设置CheckBox所展示的文本。*/
            setText(tiankafeiTreeNodeAttributeVO.getUserObject().toString());
            setOpaque(false);
            if (StringUtils.isNotEmpty(tiankafeiTreeNodeAttributeVO.getNodeIconFilePath())
                    && tiankafeiTreeNodeAttributeVO.getNodeIconHeight() != 0
                    && tiankafeiTreeNodeAttributeVO.getNodeIconWidth() != 0) {
                ImageIcon imageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeNodeAttributeVO.getNodeIconFilePath(), tiankafeiTreeNodeAttributeVO.getNodeIconWidth(), tiankafeiTreeNodeAttributeVO.getNodeIconHeight());
                //自定义的图标
                setIcon(imageIcon);
            } else {
                if (leaf) {
                    //叶节点的图标
                    ImageIcon leafImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getLeafIconFilePath(), tiankafeiTreeAttributeVO.getLeafIconWidth(), tiankafeiTreeAttributeVO.getLeafIconHeight());
                    setIcon(leafImageIcon);
                } else {
                    if (expanded) {
                        //展开时的图标
                        ImageIcon expandImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getExpandIconFilePath(), tiankafeiTreeAttributeVO.getExpandIconWidth(), tiankafeiTreeAttributeVO.getExpandIconHeight());
                        setIcon(expandImageIcon);
                    } else {
                        //关闭时的图标
                        ImageIcon closedImageIcon = ImageIconUtil.getScaledImageIcon(tiankafeiTreeAttributeVO.getClosedIconFilePath(), tiankafeiTreeAttributeVO.getClosedIconWidth(), tiankafeiTreeAttributeVO.getClosedIconHeight());
                        setIcon(closedImageIcon);
                    }
                }
            }
        }
        return component;
    }

}