package org.tiankafei.ui.jface.modelsui;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.JPopupMenu;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义右键菜单对象
 *
 * @author tiankafei
 */
public class TkfJfcPopupMenu extends JPopupMenu {

    private static final long serialVersionUID = -5953077651265516825L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义右键菜单对象
     */
    public TkfJfcPopupMenu() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 获取右键菜单的所有菜单项集合
     *
     * @return 右键菜单的所有菜单项集合
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
