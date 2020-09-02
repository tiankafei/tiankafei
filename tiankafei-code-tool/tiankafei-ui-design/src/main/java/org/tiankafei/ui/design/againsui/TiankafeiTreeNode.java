package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树节点对象
 *
 * @author tiankafei1
 */
public class TiankafeiTreeNode extends TiankafeiDesignerVO {

    /**
     * 自定义树节点对象
     */
    private TkfTreeNode tkfTreeNode;

    /**
     * 自定义树节点属性对象
     */
    private TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO;

    /**
     * 构造自定义树节点对象
     */
    public TiankafeiTreeNode() {
        tkfTreeNode = new TkfTreeNode();
        tiankafeiTreeNodeAttributeVO = new TiankafeiTreeNodeAttributeVO();
    }

    /**
     * 初始化自定义树节点对象
     *
     * @return 自定义树节点对象
     */
    public TkfTreeNode initTiankafeiTreeNode() {
        tkfTreeNode.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        tkfTreeNode.setTiankafeiTreeNodeAttributeVO(tiankafeiTreeNodeAttributeVO);
        tkfTreeNode.setUserObject(tiankafeiTreeNodeAttributeVO.getUserObject());

        return tkfTreeNode;
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

}
