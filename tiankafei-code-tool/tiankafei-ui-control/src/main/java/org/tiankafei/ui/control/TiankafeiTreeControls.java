package org.tiankafei.ui.control;

import com.google.common.collect.Lists;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.UuidUtil;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiAction;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiMouseAction;
import org.tiankafei.ui.design.againsui.TiankafeiPopupMenu;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTree;
import org.tiankafei.ui.design.againsui.tree.drag.TiankafeiTreeDragSource;
import org.tiankafei.ui.design.againsui.tree.drag.TiankafeiTreeDropTarget;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiMenuAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfMenuItem;
import org.tiankafei.ui.design.modelsui.TkfPopupMenu;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;
import org.tiankafei.ui.design.modelsui.TkfTree;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树控件
 *
 * @author tiankafei1
 */
public class TiankafeiTreeControls {

    /**
     * 自定义树对象
     */
    private TiankafeiTree tiankafeiTree;

    /**
     * 自定义树节点属性对象
     */
    private TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO;

    /**
     * 自定义树对象
     */
    private TkfTree tkfTree;

    /**
     * 自定义右键菜单对象
     */
    private TiankafeiPopupMenu tiankafeiPopupMenu;

    /**
     * 自定义右键菜单对象
     */
    private TkfPopupMenu tkfPopupMenu;

    /**
     * 本级菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 下级菜单集合
     */
    private List<MenuItemVO> menuItemList;

    /**
     * 菜单项集合
     */
    private List<TkfMenuItem> tkfMenuItemList;

    /**
     * 上移置顶唯一标识
     */
    private String moveTopIdentifies;

    /**
     * 上移唯一标识
     */
    private String moveUpIdentifies;

    /**
     * 下移唯一标识
     */
    private String moveDownIdentifies;

    /**
     * 下移置底唯一标识
     */
    private String moveBottomIdentifies;

    /**
     * 构造自定义树控件
     */
    public TiankafeiTreeControls() {
        tiankafeiTree = new TiankafeiTree();
        tiankafeiTreeAttributeVO = new TiankafeiTreeAttributeVO();
        tiankafeiPopupMenu = new TiankafeiPopupMenu();
        menuList = Lists.newArrayList();
        menuItemList = Lists.newArrayList();
    }

    /**
     * 初始化树控件面板
     *
     * @return 树控件面板
     * @throws BaseException 自定义异常
     */
    public TkfScrollPane initTiankafeiTreeControls() throws BaseException {
        tiankafeiPopupMenu.setMenuList(menuList);
        tiankafeiPopupMenu.setMenuItemList(menuItemList);
        //设置树对象属性
        tiankafeiTree.setTiankafeiTreeAttributeVO(tiankafeiTreeAttributeVO);
        //初始化树对象
        tkfTree = tiankafeiTree.initTiankafeiTree();
        //设置树的拖拽类型
        setDragTree(tiankafeiTreeAttributeVO.getTreeDragType());
        //设置右键菜单
        setRightMenu(tiankafeiTreeAttributeVO.isTreeMoveFlag());

        TiankafeiScrollPane tiankafeiScrollPane = new TiankafeiScrollPane(tkfTree);
        TkfScrollPane tkfScrollPane = tiankafeiScrollPane.initTiankafeiScrollPane();
        return tkfScrollPane;
    }

    /**
     * 设置树的拖拽类型
     *
     * @param treeDragType 树拖拽类型
     */
    public void setDragTree(int treeDragType) {
        if (TiankafeiDesignerConstants.TREE_DRAG_ALL == treeDragType) {
            new TiankafeiTreeDragSource(tkfTree);
            new TiankafeiTreeDropTarget(tkfTree);
        } else if (TiankafeiDesignerConstants.TREE_DRAG_SOURCE == treeDragType) {
            new TiankafeiTreeDragSource(tkfTree);
        } else if (TiankafeiDesignerConstants.TREE_DRAG_TARGET == treeDragType) {
            new TiankafeiTreeDropTarget(tkfTree);
        }
    }

    /**
     * 设置右键菜单
     *
     * @param treeMoveFlag 树节点移动标识
     * @throws BaseException 自定义异常
     */
    public void setRightMenu(boolean treeMoveFlag) throws BaseException {
        if (treeMoveFlag) {
            //初始化移动的菜单事件
            initMenuItemAction();
            tkfPopupMenu = tiankafeiPopupMenu.initTiankafeiPopupMenu();
            //获取右键菜单的所有菜单项集合
            tkfMenuItemList = tkfPopupMenu.getTkfMenuItemList();

            InputMap inputMap = tkfTree.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            ActionMap actionMap = tkfTree.getActionMap();

            TkfMenuItem moveUpTkfMenuItem = getTkfMenuItem(moveUpIdentifies);
            KeyStroke moveUpKeyStroke = moveUpTkfMenuItem.getAccelerator();
            inputMap.put(moveUpKeyStroke, moveUpTkfMenuItem.getMenuItemVO().getHotKeyPrimarykey());
            actionMap.put(moveUpTkfMenuItem.getMenuItemVO().getHotKeyPrimarykey(), moveUpTkfMenuItem.getMenuItemVO().getTiankafeiAction());

            TkfMenuItem moveDownTkfMenuItem = getTkfMenuItem(moveDownIdentifies);
            KeyStroke moveDownKeyStroke = moveDownTkfMenuItem.getAccelerator();
            inputMap.put(moveDownKeyStroke, moveDownTkfMenuItem.getMenuItemVO().getHotKeyPrimarykey());
            actionMap.put(moveDownTkfMenuItem.getMenuItemVO().getHotKeyPrimarykey(), moveDownTkfMenuItem.getMenuItemVO().getTiankafeiAction());

            tkfTree.addMouseListener(new TiankafeiTreeRightPopupMenuMouseAction());
        }
    }

    /**
     * 自定义树右键菜单鼠标点击事件
     *
     * @author tiankafei1
     */
    class TiankafeiTreeRightPopupMenuMouseAction extends AbstractTiankafeiMouseAction {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (MouseEvent.BUTTON3 == e.getButton()) {
                int row = tkfTree.getRowForLocation(e.getX(), e.getY());
                if (row == -1) {
                    return;
                }
                TreePath treePath = tkfTree.getPathForRow(row);
                tkfTree.setSelectionPath(treePath);
                TkfTreeNode tkfTreeNode = (TkfTreeNode) treePath.getLastPathComponent();
                if (tkfTreeNode.isRoot()) {
                    return;
                }
                int index = tkfTreeNode.getParent().getIndex(tkfTreeNode);
                int childCount = tkfTreeNode.getParent().getChildCount();

                TkfMenuItem moveTopTkfMenuItem = getTkfMenuItem(moveTopIdentifies);
                TkfMenuItem moveUpTkfMenuItem = getTkfMenuItem(moveUpIdentifies);
                TkfMenuItem moveDownTkfMenuItem = getTkfMenuItem(moveDownIdentifies);
                TkfMenuItem moveBottomTkfMenuItem = getTkfMenuItem(moveBottomIdentifies);
                if (index == 0) {
                    moveTopTkfMenuItem.setEnabled(false);
                    moveUpTkfMenuItem.setEnabled(false);
                    moveDownTkfMenuItem.setEnabled(true);
                    moveBottomTkfMenuItem.setEnabled(true);
                } else if (index == childCount - 1) {
                    moveTopTkfMenuItem.setEnabled(true);
                    moveUpTkfMenuItem.setEnabled(true);
                    moveDownTkfMenuItem.setEnabled(false);
                    moveBottomTkfMenuItem.setEnabled(false);
                } else {
                    moveTopTkfMenuItem.setEnabled(true);
                    moveUpTkfMenuItem.setEnabled(true);
                    moveDownTkfMenuItem.setEnabled(true);
                    moveBottomTkfMenuItem.setEnabled(true);
                }
                tkfPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    /**
     * 初始化移动的菜单事件
     *
     * @throws BaseException
     */
    private void initMenuItemAction() {
        MenuItemVO moveTopMenuItemVO = new MenuItemVO();
        TiankafeiMenuAttributeVO moveTopTiankafeiMenuAttributeVO = moveTopMenuItemVO.getTiankafeiMenuAttributeVO();
        moveTopTiankafeiMenuAttributeVO.setText("上移置顶");
        moveTopMenuItemVO.setTiankafeiAction(new TiankafeiTreeMoveTopAction());
        moveTopIdentifies = UuidUtil.getUuid();
        moveTopMenuItemVO.setIdentifies(moveTopIdentifies);
        menuItemList.add(moveTopMenuItemVO);

        MenuItemVO moveUpMenuItemVO = new MenuItemVO();
        TiankafeiMenuAttributeVO moveUpTiankafeiMenuAttributeVO = moveUpMenuItemVO.getTiankafeiMenuAttributeVO();
        moveUpTiankafeiMenuAttributeVO.setText("上移");
        moveUpMenuItemVO.setTiankafeiAction(new TiankafeiTreeMoveUpAction());
        moveUpIdentifies = UuidUtil.getUuid();
        moveUpMenuItemVO.setIdentifies(moveUpIdentifies);
        moveUpMenuItemVO.setHotKey(KeyEvent.VK_UP);
        moveUpMenuItemVO.setHotKeyPrimarykey("moveUp");
        menuItemList.add(moveUpMenuItemVO);

        MenuItemVO moveDownMenuItemVO = new MenuItemVO();
        TiankafeiMenuAttributeVO moveDownTiankafeiMenuAttributeVO = moveDownMenuItemVO.getTiankafeiMenuAttributeVO();
        moveDownTiankafeiMenuAttributeVO.setText("下移");
        moveDownMenuItemVO.setTiankafeiAction(new TiankafeiTreeMoveDownAction());
        moveDownIdentifies = UuidUtil.getUuid();
        moveDownMenuItemVO.setIdentifies(moveDownIdentifies);
        moveDownMenuItemVO.setHotKey(KeyEvent.VK_DOWN);
        moveDownMenuItemVO.setHotKeyPrimarykey("moveDown");
        menuItemList.add(moveDownMenuItemVO);

        MenuItemVO moveBottomMenuItemVO = new MenuItemVO();
        TiankafeiMenuAttributeVO moveBottomTiankafeiMenuAttributeVO = moveBottomMenuItemVO.getTiankafeiMenuAttributeVO();
        moveBottomTiankafeiMenuAttributeVO.setText("下移置底");
        moveBottomMenuItemVO.setTiankafeiAction(new TiankafeiTreeMoveBottomAction());
        moveBottomIdentifies = UuidUtil.getUuid();
        moveBottomMenuItemVO.setIdentifies(moveBottomIdentifies);
        menuItemList.add(moveBottomMenuItemVO);
    }

    /**
     * 自定义树上移置顶鼠标事件
     *
     * @author tiankafei1
     */
    class TiankafeiTreeMoveTopAction extends AbstractTiankafeiAction {
        private static final long serialVersionUID = -1487090845290349527L;

        @Override
        public void actionPerformed(ActionEvent e) {
            moveTreeNode(1);
        }
    }

    /**
     * 自定义树上移鼠标事件
     *
     * @author tiankafei1
     */
    class TiankafeiTreeMoveUpAction extends AbstractTiankafeiAction {
        private static final long serialVersionUID = 1824863209925991494L;

        @Override
        public void actionPerformed(ActionEvent e) {
            moveTreeNode(2);
        }
    }

    /**
     * 自定义树下移鼠标事件
     *
     * @author tiankafei1
     */
    class TiankafeiTreeMoveDownAction extends AbstractTiankafeiAction {
        private static final long serialVersionUID = -4385120047021800539L;

        @Override
        public void actionPerformed(ActionEvent e) {
            moveTreeNode(3);
        }
    }

    /**
     * 自定义树下移置底鼠标事件
     *
     * @author tiankafei1
     */
    class TiankafeiTreeMoveBottomAction extends AbstractTiankafeiAction {
        private static final long serialVersionUID = -2917327802733136278L;

        @Override
        public void actionPerformed(ActionEvent e) {
            moveTreeNode(4);
        }
    }

    /**
     * 移动树节点
     *
     * @param moveType 移动类型
     */
    private void moveTreeNode(int moveType) {
        TreePath treeSelectedPath = tkfTree.getSelectionPath();
        TkfTreeNode tkfSelectedTreeNode = (TkfTreeNode) treeSelectedPath.getLastPathComponent();
        if (tkfSelectedTreeNode.isRoot()) {
            return;
        }
        TkfTreeNode parentTkfTreeNode = (TkfTreeNode) tkfSelectedTreeNode.getParent();

        int index = parentTkfTreeNode.getIndex(tkfSelectedTreeNode);
        int childCount = parentTkfTreeNode.getChildCount();

        int moveIndex = -1;
        int moveUp = 2;
        int moveDown = 3;
        int moveBottom = 4;
        if (moveType == 1) {
            //上移置顶
            moveIndex = 0;
        } else if (moveType == moveUp) {
            //上移
            if (index == 0) {
                return;
            }
            moveIndex = index - 1;
        } else if (moveType == moveDown) {
            //下移
            if (childCount - 1 == index) {
                return;
            }
            moveIndex = index + 1;
        } else if (moveType == moveBottom) {
            //下移置低
            moveIndex = childCount - 1;
        }
        if (moveIndex == -1) {
            return;
        }
        DefaultTreeModel treeDataModel = tkfTree.getTiankafeiTreeAttributeVO().getTreeDataModel();
        treeDataModel.removeNodeFromParent(tkfSelectedTreeNode);
        treeDataModel.insertNodeInto(tkfSelectedTreeNode, parentTkfTreeNode, moveIndex);
        tkfTree.setSelectionPath(treeSelectedPath);
    }

    /**
     * 获取唯一标识的菜单项
     *
     * @param identifies 唯一标识
     * @return 菜单项
     */
    public TkfMenuItem getTkfMenuItem(String identifies) {
        TkfMenuItem tkfMenuItem = null;
        for (int i = 0, lem = tkfMenuItemList.size(); i < lem; i++) {
            TkfMenuItem tempTkfMenuItem = tkfMenuItemList.get(i);
            if (identifies.equals(tempTkfMenuItem.getTiankafeiModelUiVO().getParamCode())) {
                tkfMenuItem = tempTkfMenuItem;
                break;
            }
        }
        return tkfMenuItem;
    }

    /**
     * 获取当前选中的树节点对象
     *
     * @param tkfTree 自定义树对象
     * @return 当前选中的树节点对象
     */
    public TkfTreeNode getChooseNode(TkfTree tkfTree) {
        TreePath treePath = tkfTree.getSelectionPath();
        TkfTreeNode tkfTreeNode = (TkfTreeNode) treePath.getLastPathComponent();
        return tkfTreeNode;
    }

    /**
     * 获取选中的节点集合
     *
     * @return 节点集合
     */
    public List<TiankafeiTreeDTO> getChooseNodeList() {
        List<TiankafeiTreeDTO> tiankafeiTreeDtoList = Lists.newArrayList();
        getChooseChildTreeNodeList(tiankafeiTree.getRootTkfTreeNode(), tiankafeiTreeDtoList);
        return tiankafeiTreeDtoList;
    }

    /**
     * 获取选中子节点集合
     *
     * @param tkfTreeNode          树节点
     * @param tiankafeiTreeDtoList 选中的子节点集合
     */
    private void getChooseChildTreeNodeList(TkfTreeNode tkfTreeNode, List<TiankafeiTreeDTO> tiankafeiTreeDtoList) {
        int childCount = tkfTreeNode.getChildCount();
        for (int i = 0, lem = childCount; i < lem; i++) {
            TkfTreeNode tempTkfTreeNode = (TkfTreeNode) tkfTreeNode.getChildAt(i);
            if (tempTkfTreeNode.getTiankafeiTreeNodeAttributeVO().isNodeCheckedFlag()) {
                tiankafeiTreeDtoList.add((TiankafeiTreeDTO) tempTkfTreeNode.getUserObject());
            }
            getChooseChildTreeNodeList(tempTkfTreeNode, tiankafeiTreeDtoList);
        }
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

    /**
     * 获取本级菜单集合
     *
     * @return 本级菜单集合
     */
    public List<MenuVO> getMenuList() {
        return menuList;
    }

    /**
     * 设置本级菜单集合
     *
     * @param menuList 本级菜单集合
     */
    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    /**
     * 获取下级菜单集合
     *
     * @return 下级菜单集合
     */
    public List<MenuItemVO> getMenuItemList() {
        return menuItemList;
    }

    /**
     * 设置下级菜单集合
     *
     * @param menuItemList 下级菜单集合
     */
    public void setMenuItemList(List<MenuItemVO> menuItemList) {
        this.menuItemList = menuItemList;
    }

}
