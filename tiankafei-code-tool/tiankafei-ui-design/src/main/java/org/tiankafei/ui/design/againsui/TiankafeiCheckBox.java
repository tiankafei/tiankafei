package org.tiankafei.ui.design.againsui;

import javax.swing.ImageIcon;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfCheckBox;
import org.tiankafei.ui.design.util.ImageIconUtil;

/**
 * 自定义复选按钮
 *
 * @author tiankafei
 */
public class TiankafeiCheckBox extends TiankafeiDesignerVO {

    /**
     * 自定义复选按钮
     */
    private TkfCheckBox tkfCheckBox;

    /**
     * 构造自定义复选按钮
     */
    public TiankafeiCheckBox() {
        tkfCheckBox = new TkfCheckBox();
    }

    /**
     * 初始化自定义复选按钮
     *
     * @return 自定义复选按钮
     * @throws BaseException 自定义异常
     */
    public TkfCheckBox initTiankafeiCheckBox() throws BaseException {
        tkfCheckBox.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfCheckBox);
        //设置图标
        if (StringUtils.isNotEmpty(getIconFilePath())) {
            ImageIcon imageIcon = null;
            if (getIconHeight() == 0 || getIconWidth() == 0) {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath());
            } else {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath(), getIconWidth(), getIconHeight());
            }
            tkfCheckBox.setIcon(imageIcon);
        }
        return tkfCheckBox;
    }

}
