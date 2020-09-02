package org.tiankafei.ui.design.models;

/**
 * 自定义分割面板参数对象
 *
 * @author 甜咖啡
 */
public class TiankafeiSplitPanelAttributeVO {

    /**
     * 分割线上显示折叠图标的标识
     */
    private Boolean splitBorderFoldFlag;

    /**
     * 分割线大小
     */
    private Integer splitBordeSize;

    /**
     * 构造自定义分割面板参数对象
     */
    public TiankafeiSplitPanelAttributeVO() {
        splitBorderFoldFlag = true;
        splitBordeSize = 10;
    }

    /**
     * 获取分割线上显示折叠图标的标识
     *
     * @return 分割线上显示折叠图标的标识
     */
    public boolean isSplitBorderFoldFlag() {
        return splitBorderFoldFlag;
    }

    /**
     * 设置分割线上显示折叠图标的标识
     *
     * @param splitBorderFoldFlag 分割线上显示折叠图标的标识
     */
    public void setSplitBorderFoldFlag(boolean splitBorderFoldFlag) {
        this.splitBorderFoldFlag = splitBorderFoldFlag;
    }

    /**
     * 获取分割线大小
     *
     * @return 分割线大小
     */
    public int getSplitBordeSize() {
        return splitBordeSize;
    }

    /**
     * 设置分割线大小
     *
     * @param splitBordeSize 分割线大小
     */
    public void setSplitBordeSize(int splitBordeSize) {
        this.splitBordeSize = splitBordeSize;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
