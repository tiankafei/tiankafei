package org.tiankafei.ui.design.modelsui;

import java.awt.Component;
import javax.swing.Icon;
import org.tiankafei.ui.design.models.TiankafeiTabbedAttributeVO;

/**
 * 自定义可关闭的标签面板对象
 *
 * @author tiankafei1
 */
public class TkfTabbedClosedPane extends TkfTabbedPane {

    private static final long serialVersionUID = 3365650115366563730L;

    /**
     * 自定义标签面板属性对象
     */
    private TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO;

    /**
     * 构造自定义可关闭的标签面板对象
     *
     * @param tiankafeiTabbedAttributeVO 自定义标签面板属性对象
     */
    public TkfTabbedClosedPane(TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO) {
        this.tiankafeiTabbedAttributeVO = tiankafeiTabbedAttributeVO;
    }

    /**
     * 新增标签面板
     *
     * @param title     标签文本
     * @param icon      标签左侧图标
     * @param component 控件
     * @param tip       控件浮现文字
     * @param closable  为true，显示关闭图标，为false不现实关闭图标
     */
    public void addTab(String title, Icon icon, Component component, String tip, boolean closable) {
        super.addTab(title + "  ", icon, component, tip);
        tiankafeiTabbedAttributeVO.getClosableVector().add(closable);
    }

    /**
     * 新增标签面板
     *
     * @param title     标签文本
     * @param icon      标签左侧图标
     * @param component 控件
     * @param closable  为true，显示关闭图标，为false不现实关闭图标
     */
    public void addTab(String title, Icon icon, Component component, boolean closable) {
        addTab(title, icon, component, null, closable);
    }

    /**
     * 新增标签面板
     *
     * @param title     标签文本
     * @param component 控件
     * @param closable  为true，显示关闭图标，为false不现实关闭图标
     */
    public void addTab(String title, Component component, boolean closable) {
        addTab(title, null, component, closable);
    }

    @Override
    public void addTab(String title, Icon icon, Component component, String tip) {
        addTab(title, icon, component, tip, false);
    }

    @Override
    public void addTab(String title, Icon icon, Component component) {
        addTab(title, icon, component, null);
    }

    @Override
    public void addTab(String title, Component component) {
        addTab(title, null, component);
    }

    /**
     * 移除组件
     *
     * @param index 组件序号
     */
    public void removeTab(int index) {
        super.removeTabAt(index);
        tiankafeiTabbedAttributeVO.getClosableVector().remove(index);
    }

    /**
     * 获取自定义标签面板属性对象
     *
     * @return 自定义标签面板属性对象
     */
    public TiankafeiTabbedAttributeVO getTiankafeiTabbedAttributeVO() {
        return tiankafeiTabbedAttributeVO;
    }

    /**
     * 设置自定义标签面板属性对象
     *
     * @param tiankafeiTabbedAttributeVO 自定义标签面板属性对象
     */
    public void setTiankafeiTabbedAttributeVO(TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO) {
        this.tiankafeiTabbedAttributeVO = tiankafeiTabbedAttributeVO;
    }

}