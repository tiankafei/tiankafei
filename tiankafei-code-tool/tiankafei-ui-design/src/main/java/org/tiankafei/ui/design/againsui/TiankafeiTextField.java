package org.tiankafei.ui.design.againsui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义文本框对象
 *
 * @author tiankafei
 */
public class TiankafeiTextField extends TiankafeiDesignerVO {

    /**
     * 自定义文本框对象
     */
    private TkfTextField tkfTextField;

    /**
     * 构造自定义文本框对象
     */
    public TiankafeiTextField() {
        tkfTextField = new TkfTextField();
        setTopBorderWidth(1);
        setBottomBorderWidth(1);
        setLeftBorderWidth(1);
        setRightBorderWidth(1);
        setBorderColor(Color.BLACK);
    }

    /**
     * 初始化自定义文本框对象
     *
     * @return 自定义文本框对象
     */
    public TkfTextField initTiankafeiTextField() {
        tkfTextField.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfTextField);

        //初始化文本框值
        if (StringUtils.isNotEmpty(getText())) {
            tkfTextField.setText(getText());
        } else {
            if (StringUtils.isNotEmpty(getPromptInfo())) {
                tkfTextField.setText(getPromptInfo());
                tkfTextField.setForeground(getPromptForegroundColor());
            }
        }

        //焦点事件
        tkfTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String text = tkfTextField.getText();
                if (StringUtils.isEmpty(text)) {
                    tkfTextField.setText(getPromptInfo());
                    tkfTextField.setForeground(getPromptForegroundColor());
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                String text = tkfTextField.getText();
                boolean flag = false;
                if (StringUtils.isEmpty(text)) {
                    flag = true;
                } else if (StringUtils.isNotEmpty(text) && text.equalsIgnoreCase(getPromptInfo())) {
                    flag = true;
                }
                if (flag) {
                    tkfTextField.setText("");
                    tkfTextField.setForeground(getForegroundColor());
                }
            }
        });

        return tkfTextField;
    }

}
