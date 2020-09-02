package org.tiankafei.ui.design.constant;

import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * 设计器参数配置
 *
 * @author tiankafei
 */
public class TiankafeiDesignerConstants {

    /**
     * 默认主题
     */
    public static final int SWING_THEME_DEFAULT = 0;

    /**
     * windows主题
     */
    public static final int SWING_THEME_WINDOWS = 1;

    /**
     * mac主题
     */
    public static final int SWING_THEME_MAC = 2;

    /**
     * 居中对齐
     */
    public static final int SWING_CENTER = SwingConstants.CENTER;

    /**
     * 左对齐
     */
    public static final int SWING_LEFT = SwingConstants.LEFT;

    /**
     * 右对齐
     */
    public static final int SWING_RIGHT = SwingConstants.RIGHT;

    /**
     * 选取方式无
     */
    public static final int CHOOSE_TYPE_NO = 0;

    /**
     * 单选
     */
    public static final int CHOOSE_TYPE_RADIO = 1;

    /**
     * 复选
     */
    public static final int CHOOSE_TYPE_CHECKBOX = 2;

    /**
     * 下拉框
     */
    public static final int CHOOSE_TYPE_COMBOBOX = 3;

    /**
     * table单选
     */
    public static final int CHOOSE_TABLE_RADIO = ListSelectionModel.SINGLE_SELECTION;

    /**
     * table连续多选
     */
    public static final int CHOOSE_TABLE_MORE_CONTINUOUS = ListSelectionModel.SINGLE_INTERVAL_SELECTION;

    /**
     * table不连续多选
     */
    public static final int CHOOSE_TABLE_MORE_NO_CONTINUOUS = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;

    /**
     * 鼠标左键点击
     */
    public static final int MOUSE_CLICK_LEFT = MouseEvent.BUTTON1;

    /**
     * 鼠标右键点击
     */
    public static final int MOUSE_CLICK_RIGHT = MouseEvent.BUTTON3;

    /**
     * 下拉框默认显示方式
     */
    public static final int COMBO_BOX_NO_TYPE = 0;

    /**
     * 下拉框下拉框值浮现
     */
    public static final int COMBO_BOX_TOOL_TIP_TYPE = 1;

    /**
     * 下拉框下拉框值自适应宽度
     */
    public static final int COMBO_BOX_AUTO_WIDTH_TYPE = 2;

    /**
     * 树不拖拽
     */
    public static final int TREE_DRAG_NO = 0;

    /**
     * 源树
     */
    public static final int TREE_DRAG_SOURCE = 1;

    /**
     * 目标树
     */
    public static final int TREE_DRAG_TARGET = 2;

    /**
     * 目标树和源树
     */
    public static final int TREE_DRAG_ALL = 3;

    public static final String HOUR = "Hour";

    public static final String MINUTE = "Minute";

    public static final String SECOND = "Second";

    public static final String YEAR = "Year";

    public static final String MONTH = "Month";

}
