package org.tiankafei.ui.design.againsui;

import javax.swing.ImageIcon;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.util.ImageIconUtil;

/**
 * 自定义标签对象
 *
 * @author tiankafei
 */
public class TiankafeiLabel extends TiankafeiDesignerVO {

    /**
     * 自定义标签对象
     */
    private TkfLabel tkfLabel;

    /**
     * 构造自定义标签对象
     */
    public TiankafeiLabel() {
        tkfLabel = new TkfLabel();
        setTopBorderWidth(0);
        setBottomBorderWidth(0);
        setLeftBorderWidth(0);
        setRightBorderWidth(0);
    }

    /**
     * 初始化自定义标签对象
     *
     * @return 自定义标签对象
     * @throws BaseException 自定义异常
     */
    public TkfLabel initTiankafeiLabel() throws BaseException {
        //设置自定义控件模型UI对象
        tkfLabel.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfLabel);
        //设置图标
        setImageIcon();
        //设置文本水平显示方式
        tkfLabel.setHorizontalAlignment(getTextHorizontalAlignment());
        //设置文本显示内容
        tkfLabel.setText(getText());
        return tkfLabel;
    }

    /**
     * 设置图标
     *
     * @throws BaseException 自定义异常
     */
    public void setImageIcon() throws BaseException {
        if (StringUtils.isNotEmpty(getIconFilePath())) {
            ImageIcon imageIcon = null;
            if (getIconHeight() == 0 || getIconWidth() == 0) {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath());
            } else {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath(), getIconWidth(), getIconHeight());
            }
            tkfLabel.setIcon(imageIcon);
        }
    }

}
