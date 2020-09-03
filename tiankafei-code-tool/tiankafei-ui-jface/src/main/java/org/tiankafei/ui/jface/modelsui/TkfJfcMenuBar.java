package org.tiankafei.ui.jface.modelsui;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.JMenuBar;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义菜单栏对象
 *
 * @author tiankafei
 */
public class TkfJfcMenuBar extends JMenuBar {

    private static final long serialVersionUID = -6508131688509092929L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义菜单栏对象
     */
    public TkfJfcMenuBar() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 获取菜单的所有菜单项集合
     *
     * @return 菜单的所有菜单项集合
     */
    public List<TkfJfcMenuItem> getTkfMenuItemList() {
        List<TkfJfcMenuItem> tkfJfcMenuItemList = Lists.newArrayList();

        return tkfJfcMenuItemList;
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
