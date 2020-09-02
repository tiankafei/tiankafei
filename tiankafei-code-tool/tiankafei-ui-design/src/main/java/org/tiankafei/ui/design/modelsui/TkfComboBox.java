package org.tiankafei.ui.design.modelsui;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义下拉框对象
 *
 * @param <E> 控件里面放置的对象
 * @param <E> 控件里面放置的对象
 * @author tiankafei
 */
public class TkfComboBox<E> extends JComboBox<E> {

    private static final long serialVersionUID = -3811801075155746489L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义下拉框对象
     */
    public TkfComboBox() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 构造自定义下拉框对象
     *
     * @param items 下拉框数组项
     */
    public TkfComboBox(E[] items) {
        super(items);
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    public TkfComboBox(ComboBoxModel<E> model) {
        super(model);
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 构造自定义下拉框对象
     *
     * @param vector 下拉框值参数
     */
    public TkfComboBox(Vector<E> vector) {
        super(vector);
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
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
