package org.tiankafei.ui.design.modelsui;

import javax.swing.tree.DefaultMutableTreeNode;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;

/**
 * 自定义树节点对象
 *
 * @author tiankafei1
 */
public class TkfTreeNode extends DefaultMutableTreeNode {

    private static final long serialVersionUID = -7225085233083952071L;

    /**
     * 自定义树节点属性对象
     */
    private TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义树节点对象
     */
    public TkfTreeNode() {
        tiankafeiTreeNodeAttributeVO = new TiankafeiTreeNodeAttributeVO();
    }

    /**
     * 获取自定义树节点属性对象
     *
     * @return 自定义树节点属性对象
     */
    public TiankafeiTreeNodeAttributeVO getTiankafeiTreeNodeAttributeVO() {
        return tiankafeiTreeNodeAttributeVO;
    }

    /**
     * 设置自定义树节点属性对象
     *
     * @param tiankafeiTreeNodeAttributeVO 自定义树节点属性对象
     */
    public void setTiankafeiTreeNodeAttributeVO(TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO) {
        this.tiankafeiTreeNodeAttributeVO = tiankafeiTreeNodeAttributeVO;
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
    }

}
