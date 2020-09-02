package org.tiankafei.ui.design.modelsui;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;

/**
 * 自定义树对象
 *
 * @author tiankafei
 */
public class TkfTree extends JTree {

    private static final long serialVersionUID = 6604850748374946166L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 自定义树节点属性对象
     */
    private TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO;

    /**
     * 构造自定义树对象
     */
    public TkfTree() {
        this(null);
    }

    /**
     * 构造自定义树对象
     *
     * @param model 树数据模型
     */
    public TkfTree(TreeModel model) {
        super(model);
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
        tiankafeiTreeAttributeVO = new TiankafeiTreeAttributeVO();
    }

    public void expandTreePath(TkfTreeNode tkfTreeNode) {
        expandPath(new TreePath(tkfTreeNode.getPath()));
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

    /**
     * 获取自定义树节点属性对象
     *
     * @return 自定义树节点属性对象
     */
    public TiankafeiTreeAttributeVO getTiankafeiTreeAttributeVO() {
        return tiankafeiTreeAttributeVO;
    }

    /**
     * 设置自定义树节点属性对象
     *
     * @param tiankafeiTreeAttributeVO 自定义树节点属性对象
     */
    public void setTiankafeiTreeAttributeVO(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO) {
        this.tiankafeiTreeAttributeVO = tiankafeiTreeAttributeVO;
    }

}
