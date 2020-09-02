package org.tiankafei.ui.design.againsui;

import java.util.List;
import java.util.Vector;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.ui.design.againsui.combobox.defaults.TiankafeiAutoWidthComboBoxUi;
import org.tiankafei.ui.design.againsui.combobox.defaults.TiankafeiToolTipWidthComboBoxUi;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfComboBox;

/**
 * 自定义下拉框对象
 *
 * @author tiankafei
 */
public class TiankafeiComboBox<E> extends TiankafeiDesignerVO {

    /**
     * 自定义下拉框对象
     */
    private TkfComboBox<E> tkfComboBox;

    /**
     * 自定义下拉框列表显示方式0:默认显示方式；1下拉框列表浮现，2下拉框列表面板宽度展示
     */
    private int tkfComboBoxType;

    /**
     * 自定义下拉框值列表
     */
    private List<?> valueList;

    /**
     * 构造自定义下拉框对象
     */
    public TiankafeiComboBox() {
        tkfComboBox = new TkfComboBox<E>();
        tkfComboBoxType = TiankafeiDesignerConstants.COMBO_BOX_AUTO_WIDTH_TYPE;
    }

    /**
     * 构造自定义下拉框对象
     *
     * @param items 下拉框数组集合
     */
    public TiankafeiComboBox(E[] items) {
        tkfComboBox = new TkfComboBox<E>(items);
        tkfComboBoxType = TiankafeiDesignerConstants.COMBO_BOX_AUTO_WIDTH_TYPE;
    }

    /**
     * 构造自定义下拉框对象
     *
     * @param vector 下拉框数组集合
     */
    public TiankafeiComboBox(Vector<E> vector) {
        tkfComboBox = new TkfComboBox<E>(vector);
        tkfComboBoxType = TiankafeiDesignerConstants.COMBO_BOX_AUTO_WIDTH_TYPE;
    }

    /**
     * 初始化自定义下拉框对象
     *
     * @return 自定义下拉框对象
     */
    @SuppressWarnings({"unchecked", "restriction"})
    public TkfComboBox<E> initTiankafeiComboBox() {
        tkfComboBox.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfComboBox);

        if (CollectionUtils.isNotEmpty(valueList)) {
            for (int i = 0, lem = valueList.size(); i < lem; i++) {
                tkfComboBox.addItem((E) valueList.get(i));
            }
            if (tkfComboBox.getUI() instanceof javax.swing.plaf.metal.MetalComboBoxUI) {
                if (TiankafeiDesignerConstants.COMBO_BOX_NO_TYPE == tkfComboBoxType) {

                } else if (TiankafeiDesignerConstants.COMBO_BOX_TOOL_TIP_TYPE == tkfComboBoxType) {
                    tkfComboBox.setUI(new TiankafeiToolTipWidthComboBoxUi());
                } else if (TiankafeiDesignerConstants.COMBO_BOX_AUTO_WIDTH_TYPE == tkfComboBoxType) {
                    tkfComboBox.setUI(new TiankafeiAutoWidthComboBoxUi());
                }
            } else if (tkfComboBox.getUI() instanceof com.sun.java.swing.plaf.windows.WindowsComboBoxUI) {
                if (TiankafeiDesignerConstants.COMBO_BOX_NO_TYPE == tkfComboBoxType) {

                } else if (TiankafeiDesignerConstants.COMBO_BOX_TOOL_TIP_TYPE == tkfComboBoxType) {
                    tkfComboBox.setUI(new org.tiankafei.ui.design.againsui.combobox.windows.TiankafeiToolTipWidthComboBoxUi());
                } else if (TiankafeiDesignerConstants.COMBO_BOX_AUTO_WIDTH_TYPE == tkfComboBoxType) {
                    tkfComboBox.setUI(new org.tiankafei.ui.design.againsui.combobox.windows.TiankafeiAutoWidthComboBoxUi());
                }
            }
        }

        return tkfComboBox;
    }

    /**
     * 获取自定义下拉框列表显示方式0:默认显示方式；1下拉框列表浮现，2下拉框列表面板宽度展示
     *
     * @return 自定义下拉框列表显示方式
     */
    public int getTkfComboBoxType() {
        return tkfComboBoxType;
    }

    /**
     * 设置自定义下拉框列表显示方式0:默认显示方式；1下拉框列表浮现，2下拉框列表面板宽度展示
     *
     * @param tkfComboBoxType 自定义下拉框列表显示方式
     */
    public void setTkfComboBoxType(int tkfComboBoxType) {
        this.tkfComboBoxType = tkfComboBoxType;
    }

    /**
     * 获取自定义下拉框值列表
     *
     * @return 自定义下拉框值列表
     */
    public List<?> getValueList() {
        return valueList;
    }

    /**
     * 设置自定义下拉框值列表
     *
     * @param valueList 自定义下拉框值列表
     */
    public void setValueList(List<?> valueList) {
        this.valueList = valueList;
    }

}
