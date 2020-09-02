package org.tiankafei.ui.report.panel.actions;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiMenuBar;
import org.tiankafei.ui.design.againsui.TiankafeiPopupMenu;
import org.tiankafei.ui.design.againsui.TiankafeiToolBar;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfMenuBar;
import org.tiankafei.ui.design.modelsui.TkfPopupMenu;
import org.tiankafei.ui.design.modelsui.TkfToolBar;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表设计器事件管理类
 *
 * @author 甜咖啡
 */
public class TiankafeiReportActionsManager {

    /**
     * excel面板对象
     */
    private TiankafeiExcelPanel tiankafeiExcelPanel;

    /**
     * 报表事件集合
     */
    private Map<String, AbstractTiankafeiReportAction> tiankafeiReportActionMap;

    /**
     * 工具栏显示集合
     */
    private List<String> toolBarsList;

    /**
     * 菜单栏显示集合
     */
    private List<MenuVO> menuList;

    /**
     * 右键菜单栏显示集合
     */
    private List<MenuVO> popupMenuList;

    /**
     * 新增报表对象事件
     */
    private TiankafeiAddReportAction tiankafeiAddReportAction;

    /**
     * 打开报表对象事件
     */
    private TiankafeiOpenReportAction tiankafeiOpenReportAction;

    /**
     * 保存报表对象事件
     */
    private TiankafeiSaveReportAction tiankafeiSaveReportAction;

    /**
     * 另存报表对象事件
     */
    private TiankafeiSaveAsReportAction tiankafeiSaveAsReportAction;

    /**
     * 复制报表对象事件
     */
    private TiankafeiCopyReportAction tiankafeiCopyReportAction;

    /**
     * 剪切报表对象事件
     */
    private TiankafeiCutReportAction tiankafeiCutReportAction;

    /**
     * 粘贴报表对象事件
     */
    private TiankafeiPasteReportAction tiankafeiPasteReportAction;

    /**
     * 回退报表对象事件
     */
    private TiankafeiGoBackReportAction tiankafeiGoBackReportAction;

    /**
     * 撤销回退报表对象事件
     */
    private TiankafeiUnGoBackReportAction tiankafeiUnGoBackReportAction;

    /**
     * 删除报表对象事件
     */
    private TiankafeiDeleteReportAction tiankafeiDeleteReportAction;

    /**
     * 重置报表对象事件
     */
    private TiankafeiResetReportAction tiankafeiResetReportAction;

    /**
     * 报表对象插入行事件
     */
    private TiankafeiInsertRowReportAction tiankafeiInsertRowReportAction;

    /**
     * 报表对象插入列事件
     */
    private TiankafeiInsertColReportAction tiankafeiInsertColReportAction;

    /**
     * 报表对象删除行事件
     */
    private TiankafeiDeleteRowReportAction tiankafeiDeleteRowReportAction;

    /**
     * 报表对象删除列事件
     */
    private TiankafeiDeleteColReportAction tiankafeiDeleteColReportAction;

    /**
     * 合并单元格报表对象事件
     */
    private TiankafeiMergeReportAction tiankafeiMergeReportAction;

    /**
     * 拆分单元格报表对象事件
     */
    private TiankafeiUnMergeReportAction tiankafeiUnMergeReportAction;

    /**
     * 加粗单元格报表对象事件
     */
    private TiankafeiBoldReportAction tiankafeiBoldReportAction;

    /**
     * 倾斜文字报表对象事件
     */
    private TiankafeiBeveledReportAction tiankafeiBeveledReportAction;

    /**
     * 下户线报表对象事件
     */
    private TiankafeiUnderlinedReportAction tiankafeiUnderlinedReportAction;

    /**
     * 单元格格式报表对象事件
     */
    private TiankafeiCellStypeReportAction tiankafeiCellStypeReportAction;

    /**
     * 边框报表对象事件
     */
    private TiankafeiBorderReportAction tiankafeiBorderReportAction;

    /**
     * 背景色报表对象事件
     */
    private TiankafeiBackgroundReportAction tiankafeiBackgroundReportAction;

    /**
     * 前景色报表对象事件
     */
    private TiankafeiForegroundReportAction tiankafeiForegroundReportAction;

    /**
     * 普通对齐
     */
    private TiankafeiGeneralReportAction tiankafeiGeneralReportAction;

    /**
     * 左对齐报表对象事件
     */
    private TiankafeiLeftReportAction tiankafeiLeftReportAction;

    /**
     * 居中对象报表对象事件
     */
    private TiankafeiCenterReportAction tiankafeiCenterReportAction;

    /**
     * 右对齐报表对象事件
     */
    private TiankafeiRightReportAction tiankafeiRightReportAction;

    /**
     * 分散对齐报表对象事件
     */
    private TiankafeiDistributeReportAction tiankafeiDistributeReportAction;

    /**
     * 搜索报表对象事件
     */
    private TiankafeiSearchReportAction tiankafeiSearchReportAction;

    /**
     * 全屏编辑报表对象事件
     */
    private TiankafeiFullscreenReportAction tiankafeiFullscreenReportAction;

    /**
     * 规则管理报表对象事件
     */
    private TiankafeiRuleManageReportAction tiankafeiRuleManageReportAction;

    /**
     * 冻结报表对象事件
     */
    private TiankafeiFreezeReportAction tiankafeiFreezeReportAction;

    /**
     * 取消冻结报表对象事件
     */
    private TiankafeiUnFreezeReportAction tiankafeiUnFreezeReportAction;

    /**
     * 报表对象向后新增事件
     */
    private ReportStyleAfterAddAction reportStyleAfterAddAction;

    /**
     * 报表对象向后复制新增事件
     */
    private ReportStyleAfterCopyAddAction reportStyleAfterCopyAddAction;

    /**
     * 报表对象向前新增事件
     */
    private ReportStyleBeforeAddAction reportStyleBeforeAddAction;

    /**
     * 报表对象向前复制新增事件
     */
    private ReportStyleBeforeCopyAddAction reportStyleBeforeCopyAddAction;

    /**
     * 报表对象左侧刀型事件
     */
    private ReportStyleLeftKnifeTypeAction reportStyleLeftKnifeTypeAction;

    /**
     * 报表对象右侧刀型事件
     */
    private ReportStyleRightKnifeTypeAction reportStyleRightKnifeTypeAction;

    /**
     * 报表对象刀型直接节点事件
     */
    private ReportStyleKnifeDirectNodeAction reportStyleKnifeDirectNodeAction;

    /**
     * 报表对象父子级事件
     */
    private ReportStyleParentAndSubAction reportStyleParentAndSubAction;

    /**
     * 构造报表设计器事件管理对象
     *
     * @param tiankafeiExcelPanel excel面板
     */
    public TiankafeiReportActionsManager(TiankafeiExcelPanel tiankafeiExcelPanel) {
        this.tiankafeiExcelPanel = tiankafeiExcelPanel;

        //初始化报表设计器事件管理
        initTiankafeiReportActions();

        //初始化工具栏集合
        initToolBarsList();
        //初始化菜单栏
        initMenuList();
        //初始化右键菜单
        initPopupMenuList();
    }

    /**
     * 初始化工具栏集合
     */
    private void initToolBarsList() {
        this.toolBarsList = Lists.newArrayList();
        this.toolBarsList.add(ActionIdentificationEnum.ADD_REPORT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.OPEN_REPORT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.SAVE_REPORT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.SAVEAS_REPORT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.COPY.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.CUT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.PASTE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.UN_GO_BACK.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.GO_BACK.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.DELETE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.RESET.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.INSERT_ROW.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.DELETE_ROW.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.INSERT_COL.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.DELETE_COL.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.MERGE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.UN_MERGE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.CELL_STYPE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.BORDER.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.GENERAL.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.LEFT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.CENTER.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.RIGHT.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.DISTRIBUTE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.BOLD.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.BEVELED.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.UNDERLINED.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.FOREGROUND.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.BACKGROUND.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.SEARCH.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.FREEZE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.UN_FREEZE.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.FULL_SCREEN.getCode());
        this.toolBarsList.add(ActionIdentificationEnum.RULE_MANAGE.getCode());
    }

    /**
     * 初始化菜单栏
     */
    private void initMenuList() {
        this.menuList = Lists.newArrayList();
        //初始化单元格操作
        initMenuCellList();
        //初始化单元格行列
        initMenuCellRowColList();
        //初始化单元格格式
        initMenuCellStyleList();
        //初始化快速形成表格区域
        initMenuCellAreaList();
    }

    /**
     * 初始化单元格操作
     */
    private void initMenuCellList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格操作");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.COPY.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CUT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.PASTE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.MERGE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_MERGE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_GO_BACK.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.GO_BACK.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RESET.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.FREEZE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_FREEZE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.menuList.add(menuVO);
    }

    /**
     * 初始化单元格行列
     */
    private void initMenuCellRowColList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格行列");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.INSERT_ROW.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE_ROW.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.INSERT_COL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE_COL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.menuList.add(menuVO);
    }

    /**
     * 初始化单元格格式
     */
    private void initMenuCellStyleList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格格式");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CELL_STYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BORDER.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.GENERAL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.LEFT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CENTER.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RIGHT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DISTRIBUTE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BOLD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEVELED.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UNDERLINED.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.FOREGROUND.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BACKGROUND.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.menuList.add(menuVO);
    }

    /**
     * 初始化快速形成表格区域
     */
    private void initMenuCellAreaList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("快速形成表格区域");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.PARENT_AND_SUB.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.LEFT_KNIFE_TYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RIGHT_KNIFE_TYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.KNIFE_DIRECT_NODE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.AFTER_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.AFTER_COPY_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEFORE_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEFORE_COPY_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.menuList.add(menuVO);
    }

    /**
     * 初始化右键菜单
     */
    private void initPopupMenuList() {
        this.popupMenuList = Lists.newArrayList();
        //初始化单元格操作
        initPopupCellList();
        //初始化单元格行列
        initPopupCellRowColList();
        //初始化单元格格式
        initPopupCellStyleList();
        //初始化快速形成表格区域
        initPopupCellAreaList();
    }

    /**
     * 初始化单元格操作
     */
    private void initPopupCellList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格操作");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.COPY.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CUT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.PASTE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.MERGE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_MERGE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_GO_BACK.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.GO_BACK.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RESET.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.FREEZE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UN_FREEZE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.popupMenuList.add(menuVO);
    }

    /**
     * 初始化单元格行列
     */
    private void initPopupCellRowColList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格行列");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.INSERT_ROW.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE_ROW.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.INSERT_COL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DELETE_COL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.popupMenuList.add(menuVO);
    }

    /**
     * 初始化单元格格式
     */
    private void initPopupCellStyleList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("单元格格式");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CELL_STYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BORDER.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.GENERAL.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.LEFT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.CENTER.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RIGHT.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.DISTRIBUTE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BOLD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEVELED.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.UNDERLINED.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.FOREGROUND.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BACKGROUND.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.popupMenuList.add(menuVO);
    }

    /**
     * 初始化快速形成表格区域
     */
    private void initPopupCellAreaList() {
        MenuVO menuVO = new MenuVO();
        menuVO.getTiankafeiMenuAttributeVO().setText("快速形成表格区域");
        MenuItemVO menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.PARENT_AND_SUB.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.LEFT_KNIFE_TYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.RIGHT_KNIFE_TYPE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.KNIFE_DIRECT_NODE.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.AFTER_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.AFTER_COPY_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuItemVO.getTiankafeiMenuAttributeVO().setSeparatorFlag(true);
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEFORE_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        menuItemVO = new MenuItemVO();
        menuItemVO.setIdentifies(ActionIdentificationEnum.BEFORE_COPY_ADD.getCode());
        menuItemVO.setTiankafeiAction(getTiankafeiReportActionMap().get(menuItemVO.getIdentifies()));
        menuVO.getMenuItemList().add(menuItemVO);
        this.popupMenuList.add(menuVO);
    }

    /**
     * 初始化报表设计器事件管理
     */
    private void initTiankafeiReportActions() {
        //初始化报表事件
        initReportActions();
        tiankafeiReportActionMap = new HashMap<String, AbstractTiankafeiReportAction>(42);
        tiankafeiCopyReportAction = new TiankafeiCopyReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiCopyReportAction.getIdentification(), tiankafeiCopyReportAction);
        tiankafeiCutReportAction = new TiankafeiCutReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiCutReportAction.getIdentification(), tiankafeiCutReportAction);
        tiankafeiPasteReportAction = new TiankafeiPasteReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiPasteReportAction.getIdentification(), tiankafeiPasteReportAction);
        tiankafeiGoBackReportAction = new TiankafeiGoBackReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiGoBackReportAction.getIdentification(), tiankafeiGoBackReportAction);
        tiankafeiUnGoBackReportAction = new TiankafeiUnGoBackReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiUnGoBackReportAction.getIdentification(), tiankafeiUnGoBackReportAction);
        tiankafeiDeleteReportAction = new TiankafeiDeleteReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiDeleteReportAction.getIdentification(), tiankafeiDeleteReportAction);
        tiankafeiResetReportAction = new TiankafeiResetReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiResetReportAction.getIdentification(), tiankafeiResetReportAction);
        tiankafeiInsertRowReportAction = new TiankafeiInsertRowReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiInsertRowReportAction.getIdentification(), tiankafeiInsertRowReportAction);
        tiankafeiInsertColReportAction = new TiankafeiInsertColReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiInsertColReportAction.getIdentification(), tiankafeiInsertColReportAction);
        tiankafeiDeleteRowReportAction = new TiankafeiDeleteRowReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiDeleteRowReportAction.getIdentification(), tiankafeiDeleteRowReportAction);
        tiankafeiDeleteColReportAction = new TiankafeiDeleteColReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiDeleteColReportAction.getIdentification(), tiankafeiDeleteColReportAction);
        tiankafeiMergeReportAction = new TiankafeiMergeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiMergeReportAction.getIdentification(), tiankafeiMergeReportAction);
        tiankafeiUnMergeReportAction = new TiankafeiUnMergeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiUnMergeReportAction.getIdentification(), tiankafeiUnMergeReportAction);
        tiankafeiBoldReportAction = new TiankafeiBoldReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiBoldReportAction.getIdentification(), tiankafeiBoldReportAction);
        tiankafeiBeveledReportAction = new TiankafeiBeveledReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiBeveledReportAction.getIdentification(), tiankafeiBeveledReportAction);
        tiankafeiUnderlinedReportAction = new TiankafeiUnderlinedReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiUnderlinedReportAction.getIdentification(), tiankafeiUnderlinedReportAction);
        tiankafeiCellStypeReportAction = new TiankafeiCellStypeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiCellStypeReportAction.getIdentification(), tiankafeiCellStypeReportAction);
        tiankafeiBorderReportAction = new TiankafeiBorderReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiBorderReportAction.getIdentification(), tiankafeiBorderReportAction);
        tiankafeiBackgroundReportAction = new TiankafeiBackgroundReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiBackgroundReportAction.getIdentification(), tiankafeiBackgroundReportAction);
        tiankafeiForegroundReportAction = new TiankafeiForegroundReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiForegroundReportAction.getIdentification(), tiankafeiForegroundReportAction);
        tiankafeiGeneralReportAction = new TiankafeiGeneralReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiGeneralReportAction.getIdentification(), tiankafeiGeneralReportAction);
        tiankafeiLeftReportAction = new TiankafeiLeftReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiLeftReportAction.getIdentification(), tiankafeiLeftReportAction);
        tiankafeiCenterReportAction = new TiankafeiCenterReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiCenterReportAction.getIdentification(), tiankafeiCenterReportAction);
        tiankafeiRightReportAction = new TiankafeiRightReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiRightReportAction.getIdentification(), tiankafeiRightReportAction);
        tiankafeiDistributeReportAction = new TiankafeiDistributeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiDistributeReportAction.getIdentification(), tiankafeiDistributeReportAction);
        tiankafeiSearchReportAction = new TiankafeiSearchReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiSearchReportAction.getIdentification(), tiankafeiSearchReportAction);
        tiankafeiFullscreenReportAction = new TiankafeiFullscreenReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiFullscreenReportAction.getIdentification(), tiankafeiFullscreenReportAction);
        tiankafeiRuleManageReportAction = new TiankafeiRuleManageReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiRuleManageReportAction.getIdentification(), tiankafeiRuleManageReportAction);
        tiankafeiFreezeReportAction = new TiankafeiFreezeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiFreezeReportAction.getIdentification(), tiankafeiFreezeReportAction);
        tiankafeiUnFreezeReportAction = new TiankafeiUnFreezeReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiUnFreezeReportAction.getIdentification(), tiankafeiUnFreezeReportAction);
        reportStyleAfterAddAction = new ReportStyleAfterAddAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleAfterAddAction.getIdentification(), reportStyleAfterAddAction);
        reportStyleAfterCopyAddAction = new ReportStyleAfterCopyAddAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleAfterCopyAddAction.getIdentification(), reportStyleAfterCopyAddAction);
        reportStyleBeforeAddAction = new ReportStyleBeforeAddAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleBeforeAddAction.getIdentification(), reportStyleBeforeAddAction);
        reportStyleBeforeCopyAddAction = new ReportStyleBeforeCopyAddAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleBeforeCopyAddAction.getIdentification(), reportStyleBeforeCopyAddAction);
        //初始化报表形状事件
        initReportShapeActions();
    }

    /**
     * 初始化报表形状事件
     */
    private void initReportShapeActions() {
        reportStyleLeftKnifeTypeAction = new ReportStyleLeftKnifeTypeAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleLeftKnifeTypeAction.getIdentification(), reportStyleLeftKnifeTypeAction);
        reportStyleRightKnifeTypeAction = new ReportStyleRightKnifeTypeAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleRightKnifeTypeAction.getIdentification(), reportStyleRightKnifeTypeAction);
        reportStyleKnifeDirectNodeAction = new ReportStyleKnifeDirectNodeAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleKnifeDirectNodeAction.getIdentification(), reportStyleKnifeDirectNodeAction);
        reportStyleParentAndSubAction = new ReportStyleParentAndSubAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(reportStyleParentAndSubAction.getIdentification(), reportStyleParentAndSubAction);
    }

    /**
     * 初始化报表事件
     */
    private void initReportActions() {
        tiankafeiAddReportAction = new TiankafeiAddReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiAddReportAction.getIdentification(), tiankafeiAddReportAction);
        tiankafeiOpenReportAction = new TiankafeiOpenReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiOpenReportAction.getIdentification(), tiankafeiOpenReportAction);
        tiankafeiSaveReportAction = new TiankafeiSaveReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiSaveReportAction.getIdentification(), tiankafeiSaveReportAction);
        tiankafeiSaveAsReportAction = new TiankafeiSaveAsReportAction(tiankafeiExcelPanel);
        tiankafeiReportActionMap.put(tiankafeiSaveAsReportAction.getIdentification(), tiankafeiSaveAsReportAction);
    }

    /**
     * 初始化工具栏面板
     *
     * @return 工具栏面板
     * @throws BaseException 自定义异常
     */
    public TkfToolBar initTkfToolBar() throws BaseException {
        try {
            //工具栏面板
            TiankafeiToolBar tiankafeiToolBar = new TiankafeiToolBar();
            TkfToolBar tkfToolBar = tiankafeiToolBar.initTiankafeiToolBar();
            for (int index = 0, length = toolBarsList.size(); index < length; index++) {
                String toolBars = toolBarsList.get(index);
                AbstractTiankafeiReportAction tiankafeiReportAction = getTiankafeiReportActionMap().get(toolBars);
                TkfButton tkfButton = tiankafeiReportAction.initTiankafeiButton();
                tkfButton.setText("");
                KeyStroke[] keyStrokeArray = tiankafeiReportAction.getKeyStrokeArray();
                if (keyStrokeArray != null && keyStrokeArray.length != 0) {
                    for (int keyIndex = 0, keyLength = keyStrokeArray.length; keyIndex < keyLength; keyIndex++) {
                        KeyStroke keyStroke = keyStrokeArray[keyIndex];
                        tkfButton.registerKeyboardAction(tiankafeiReportAction, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
                    }
                }
                tkfToolBar.add(tkfButton);
            }
            return tkfToolBar;
        } catch (BaseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 初始化菜单栏面板
     *
     * @return 菜单栏面板
     * @throws BaseException 自定义异常
     */
    public TkfMenuBar initTkfMenuBar() throws BaseException {
        try {
            //菜单栏面板
            TiankafeiMenuBar tiankafeiMenuBar = new TiankafeiMenuBar();
            tiankafeiMenuBar.setMenuList(menuList);
            TkfMenuBar tkfMenuBar = tiankafeiMenuBar.initTiankafeiMenuBar();
            return tkfMenuBar;
        } catch (BaseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 初始化右键菜单栏面板
     *
     * @return 右键菜单栏面板
     * @throws BaseException 自定义异常
     */
    public TkfPopupMenu initTkfPopupMenu() throws BaseException {
        try {
            //右键菜单栏面板
            TiankafeiPopupMenu tiankafeiPopupMenu = new TiankafeiPopupMenu();
            tiankafeiPopupMenu.setMenuList(popupMenuList);
            TkfPopupMenu tkfPopupMenu = tiankafeiPopupMenu.initTiankafeiPopupMenu();
            return tkfPopupMenu;
        } catch (BaseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Map<String, AbstractTiankafeiReportAction> getTiankafeiReportActionMap() {
        return tiankafeiReportActionMap;
    }

    public void setToolBarsList(List<String> toolBarsList) {
        this.toolBarsList = toolBarsList;
    }

    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    public void setPopupMenuList(List<MenuVO> popupMenuList) {
        this.popupMenuList = popupMenuList;
    }

    public TiankafeiAddReportAction getTiankafeiAddReportAction() {
        return tiankafeiAddReportAction;
    }

    public TiankafeiOpenReportAction getTiankafeiOpenReportAction() {
        return tiankafeiOpenReportAction;
    }

    public TiankafeiSaveReportAction getTiankafeiSaveReportAction() {
        return tiankafeiSaveReportAction;
    }

    public TiankafeiSaveAsReportAction getTiankafeiSaveAsReportAction() {
        return tiankafeiSaveAsReportAction;
    }

    public TiankafeiCopyReportAction getTiankafeiCopyReportAction() {
        return tiankafeiCopyReportAction;
    }

    public TiankafeiCutReportAction getTiankafeiCutReportAction() {
        return tiankafeiCutReportAction;
    }

    public TiankafeiPasteReportAction getTiankafeiPasteReportAction() {
        return tiankafeiPasteReportAction;
    }

    public TiankafeiGoBackReportAction getTiankafeiGoBackReportAction() {
        return tiankafeiGoBackReportAction;
    }

    public TiankafeiUnGoBackReportAction getTiankafeiUnGoBackReportAction() {
        return tiankafeiUnGoBackReportAction;
    }

    public TiankafeiDeleteReportAction getTiankafeiDeleteReportAction() {
        return tiankafeiDeleteReportAction;
    }

    public TiankafeiResetReportAction getTiankafeiResetReportAction() {
        return tiankafeiResetReportAction;
    }

    public TiankafeiInsertRowReportAction getTiankafeiInsertRowReportAction() {
        return tiankafeiInsertRowReportAction;
    }

    public TiankafeiInsertColReportAction getTiankafeiInsertColReportAction() {
        return tiankafeiInsertColReportAction;
    }

    public TiankafeiDeleteRowReportAction getTiankafeiDeleteRowReportAction() {
        return tiankafeiDeleteRowReportAction;
    }

    public TiankafeiDeleteColReportAction getTiankafeiDeleteColReportAction() {
        return tiankafeiDeleteColReportAction;
    }

    public TiankafeiMergeReportAction getTiankafeiMergeReportAction() {
        return tiankafeiMergeReportAction;
    }

    public TiankafeiUnMergeReportAction getTiankafeiUnMergeReportAction() {
        return tiankafeiUnMergeReportAction;
    }

    public TiankafeiBoldReportAction getTiankafeiBoldReportAction() {
        return tiankafeiBoldReportAction;
    }

    public TiankafeiBeveledReportAction getTiankafeiBeveledReportAction() {
        return tiankafeiBeveledReportAction;
    }

    public TiankafeiUnderlinedReportAction getTiankafeiUnderlinedReportAction() {
        return tiankafeiUnderlinedReportAction;
    }

    public TiankafeiCellStypeReportAction getTiankafeiCellStypeReportAction() {
        return tiankafeiCellStypeReportAction;
    }

    public TiankafeiBorderReportAction getTiankafeiBorderReportAction() {
        return tiankafeiBorderReportAction;
    }

    public TiankafeiBackgroundReportAction getTiankafeiBackgroundReportAction() {
        return tiankafeiBackgroundReportAction;
    }

    public TiankafeiForegroundReportAction getTiankafeiForegroundReportAction() {
        return tiankafeiForegroundReportAction;
    }

    public TiankafeiGeneralReportAction getTiankafeiGeneralReportAction() {
        return tiankafeiGeneralReportAction;
    }

    public TiankafeiLeftReportAction getTiankafeiLeftReportAction() {
        return tiankafeiLeftReportAction;
    }

    public TiankafeiCenterReportAction getTiankafeiCenterReportAction() {
        return tiankafeiCenterReportAction;
    }

    public TiankafeiRightReportAction getTiankafeiRightReportAction() {
        return tiankafeiRightReportAction;
    }

    public TiankafeiDistributeReportAction getTiankafeiDistributeReportAction() {
        return tiankafeiDistributeReportAction;
    }

    public TiankafeiSearchReportAction getTiankafeiSearchReportAction() {
        return tiankafeiSearchReportAction;
    }

    public TiankafeiFullscreenReportAction getTiankafeiFullscreenReportAction() {
        return tiankafeiFullscreenReportAction;
    }

    public TiankafeiRuleManageReportAction getTiankafeiRuleManageReportAction() {
        return tiankafeiRuleManageReportAction;
    }

    public TiankafeiFreezeReportAction getTiankafeiFreezeReportAction() {
        return tiankafeiFreezeReportAction;
    }

    public TiankafeiUnFreezeReportAction getTiankafeiUnFreezeReportAction() {
        return tiankafeiUnFreezeReportAction;
    }
}
