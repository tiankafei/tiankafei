package org.tiankafei.ui.design.againsui;

import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.models.TiankafeiButtonAttributeDTO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfButton;

/**
 * 自定义按钮对象
 *
 * @author tiankafei
 */
public class TiankafeiButton extends TiankafeiDesignerVO {

    /**
     * 自定义按钮对象
     */
    private TkfButton tkfButton;

    /**
     * 自定义按钮属性对象
     */
    private TiankafeiButtonAttributeDTO tiankafeiButtonAttributeDTO;

    /**
     * 构造自定义按钮对象
     */
    public TiankafeiButton() {
        tiankafeiButtonAttributeDTO = new TiankafeiButtonAttributeDTO();
    }

    /**
     * 初始化自定义按钮对象
     *
     * @return 自定义按钮对象
     * @throws BaseException 自定义异常
     */
    public TkfButton initTiankafeiButton() throws BaseException {
        tkfButton = new TkfButton();
        tkfButton.setTiankafeiButtonAttributeDTO(getTiankafeiButtonAttributeDTO());
        //设置控件属性
        setComponentParam(tkfButton);
        //设置图标
        setImageIcon(tkfButton);
        //设置按钮文本
        tkfButton.setText(getText());
        return tkfButton;
    }

    /**
     * 初始化重新绘制的自定义按钮对象
     *
     * @return 自定义按钮对象
     * @throws BaseException 自定义异常
     */
    public TkfButton initFreshDrawTiankafeiButton() throws BaseException {
        //初始化自定义按钮对象
        initTiankafeiButton();
        //重绘按钮
        tkfButton.setTiankafeiButtonAttributeDTO(tiankafeiButtonAttributeDTO);
        tkfButton.paintcolor();
        return tkfButton;
    }

    /**
     * 设置图标
     *
     * @throws BaseException 自定义异常
     */
    public void setImageIcon() throws BaseException {
        super.setImageIcon(tkfButton);
        setEnabled(true);
    }

    /**
     * 获取自定义按钮属性对象
     *
     * @return 自定义按钮属性对象
     */
    public TiankafeiButtonAttributeDTO getTiankafeiButtonAttributeDTO() {
        return tiankafeiButtonAttributeDTO;
    }

    /**
     * 设置自定义按钮属性对象
     *
     * @param tiankafeiButtonAttributeDTO 自定义按钮属性对象
     */
    public void setTiankafeiButtonAttributeDTO(TiankafeiButtonAttributeDTO tiankafeiButtonAttributeDTO) {
        this.tiankafeiButtonAttributeDTO = tiankafeiButtonAttributeDTO;
    }

    /**
     * 设置控件是否禁用
     *
     * @param b 控件禁用标识
     */
    public void setEnabled(boolean b) {
        tkfButton.setEnabled(b);
    }

}