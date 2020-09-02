package org.tiankafei.ui.design.models;

import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiAction;

/**
 * 菜单项对象
 *
 * @author tiankafei
 */
public class MenuItemVO {

    /**
     * 菜单属性对象
     */
    private TiankafeiMenuAttributeVO tiankafeiMenuAttributeVO;

    /**
     * 唯一标识
     */
    private String identifies;

    /**
     * 热键
     */
    private Integer hotKey;

    /**
     * 热键的key
     */
    private String hotKeyPrimarykey;

    /**
     * 按钮点击触发事件对象
     */
    private AbstractTiankafeiAction tiankafeiAction;

    /**
     * 构造菜单项对象
     */
    public MenuItemVO() {
        tiankafeiMenuAttributeVO = new TiankafeiMenuAttributeVO();
        hotKey = -1;
    }

    /**
     * 获取菜单属性对象
     *
     * @return 菜单属性对象
     */
    public TiankafeiMenuAttributeVO getTiankafeiMenuAttributeVO() {
        return tiankafeiMenuAttributeVO;
    }

    /**
     * 设置菜单属性对象
     *
     * @param tiankafeiMenuAttributeVO 菜单属性对象
     */
    public void setTiankafeiMenuAttributeVO(TiankafeiMenuAttributeVO tiankafeiMenuAttributeVO) {
        this.tiankafeiMenuAttributeVO = tiankafeiMenuAttributeVO;
    }

    /**
     * 获取唯一标识
     *
     * @return 唯一标识
     */
    public String getIdentifies() {
        return identifies;
    }

    /**
     * 设置唯一标识
     *
     * @param identifies 唯一标识
     */
    public void setIdentifies(String identifies) {
        this.identifies = identifies;
    }

    /**
     * 获取热键
     *
     * @return 热键
     */
    public int getHotKey() {
        return hotKey;
    }

    /**
     * 设置热键
     *
     * @param hotKey 热键
     */
    public void setHotKey(int hotKey) {
        this.hotKey = hotKey;
    }

    /**
     * 获取热键的key
     *
     * @return 热键的key
     */
    public String getHotKeyPrimarykey() {
        return hotKeyPrimarykey;
    }

    /**
     * 设置热键的key
     *
     * @param hotKeyPrimarykey 热键的key
     */
    public void setHotKeyPrimarykey(String hotKeyPrimarykey) {
        this.hotKeyPrimarykey = hotKeyPrimarykey;
    }

    /**
     * 获取按钮点击触发事件对象
     *
     * @return 按钮点击触发事件对象
     */
    public AbstractTiankafeiAction getTiankafeiAction() {
        return tiankafeiAction;
    }

    /**
     * 设置按钮点击触发事件对象
     *
     * @param tiankafeiAction 按钮点击触发事件对象
     */
    public void setTiankafeiAction(AbstractTiankafeiAction tiankafeiAction) {
        this.tiankafeiAction = tiankafeiAction;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
