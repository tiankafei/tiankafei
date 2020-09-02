package org.tiankafei.ui.control;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 层次控件
 *
 * @author 甜咖啡
 */
public class TiankafeiLayeredControls {

    /**
     * 层级面板控件
     */
    private TkfPanel tkfPanel;

    /**
     * 窗口的层级控件
     */
    private JLayeredPane layeredPane;

    /**
     * 窗口的层级控件里面的面板是否显示
     */
    private Map<String, Boolean> visibleMap;

    /**
     * 构造层次控件
     *
     * @param layeredPane 层次控件
     */
    public TiankafeiLayeredControls(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        tkfPanel = tiankafeiPanel.initTiankafeiPanel();

        visibleMap = new HashMap<String, Boolean>();
    }

    /**
     * 初始化层级面板控件
     *
     * @return 层级面板控件
     */
    public TkfPanel initTiankafeiLayeredControls() {

        return tkfPanel;
    }

    /**
     * 添加层级控件里面的面板
     *
     * @param width     面板宽度
     * @param height    面板高度
     * @param paramCode 面板唯一标识
     * @return 返回层次面板
     */
    public TkfPanel addLayeredPane(int width, int height, String paramCode) {
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        tiankafeiPanel.setWidth(width);
        tiankafeiPanel.setHeight(height);
        tiankafeiPanel.setTopBorderWidth(1);
        tiankafeiPanel.setLeftBorderWidth(1);
        tiankafeiPanel.setBottomBorderWidth(1);
        tiankafeiPanel.setRightBorderWidth(1);
        tiankafeiPanel.getTiankafeiModelUiVO().setParamCode(paramCode);
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfPanel.setBorder(BorderFactory.createTitledBorder(paramCode));

        visibleMap.put(paramCode, false);
        layeredPane.add(tkfPanel, JLayeredPane.DRAG_LAYER);
        tkfPanel.setVisible(false);

        return tkfPanel;
    }

    /**
     * 设置层次面板是否显示
     *
     * @param layeredPanel 面板
     * @return 返回是否需要显示
     */
    public boolean setLayeredPanelVisible(TkfPanel layeredPanel) {
        String paramCode = null;
        if (layeredPanel != null) {
            paramCode = layeredPanel.getTiankafeiModelUiVO().getParamCode();
        }

        boolean result = true;
        Component[] components = layeredPane.getComponents();
        for (int index = 0, length = components.length; index < length; index++) {
            Component component = components[index];
            if (!(component instanceof TkfPanel)) {
                continue;
            }
            TkfPanel tkfPanel = (TkfPanel) component;
            String key = tkfPanel.getTiankafeiModelUiVO().getParamCode();
            if (!visibleMap.containsKey(key)) {
                continue;
            }
            boolean visibleFlag = true;
            if (StringUtils.isNotEmpty(paramCode)) {
                if (paramCode.equals(key)) {
                    if (visibleMap.get(key)) {
                        //当前是显示的，再次点击时需要隐藏
                        visibleFlag = false;
                        result = false;
                    }
                } else {
                    visibleFlag = false;
                }
            } else {
                visibleFlag = false;
            }
            if (!visibleFlag) {
                visibleMap.put(key, Boolean.FALSE);
                tkfPanel.setVisible(false);
            }
        }
        return result;
    }

    /**
     * 设置层次面板是否显示
     *
     * @param startx       面板显示其实x坐标
     * @param starty       面板显示其实y坐标
     * @param layeredPanel 面板
     */
    public void setLayeredPanelVisible(int startx, int starty, TkfPanel layeredPanel) {
        if (!setLayeredPanelVisible(layeredPanel)) {
            return;
        }
        String key = layeredPanel.getTiankafeiModelUiVO().getParamCode();
        if (visibleMap.containsKey(key)) {
            if (visibleMap.get(key)) {
                visibleMap.put(key, Boolean.FALSE);
                layeredPanel.setVisible(false);
                return;
            }
            int width = (int) layeredPanel.getPreferredSize().getWidth();
            int height = (int) layeredPanel.getPreferredSize().getHeight();
            layeredPanel.setBounds(startx, starty, width, height);
            visibleMap.put(key, Boolean.TRUE);
            layeredPanel.setVisible(true);
        }
    }

}
