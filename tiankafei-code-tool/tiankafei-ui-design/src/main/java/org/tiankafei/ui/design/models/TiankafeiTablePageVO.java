package org.tiankafei.ui.design.models;

import java.io.Serializable;
import org.tiankafei.common.dto.PaginatedDTO;

/**
 * 自定义表格分页对象
 *
 * @author tiankafei1
 */
public class TiankafeiTablePageVO implements Serializable {

    private static final long serialVersionUID = -8054341419853994927L;

    /**
     * 分页对象
     */
    private PaginatedDTO tablePaginatedDTO;

    /**
     * 首页图标路径
     */
    private String tableFirstButtonIconPath;

    /**
     * 上一页图标路径
     */
    private String tablePreviousButtonIconPath;

    /**
     * 下一页图标路径
     */
    private String tableNextButtonIconPath;

    /**
     * 最后一页页图标路径
     */
    private String tableLastButtonIconPath;

    /**
     * 构造自定义表格分页对象
     */
    public TiankafeiTablePageVO() {
        tablePaginatedDTO = new PaginatedDTO();
        tableFirstButtonIconPath = "/images/first.png";
        tablePreviousButtonIconPath = "/images/previous.png";
        tableNextButtonIconPath = "/images/next.png";
        tableLastButtonIconPath = "/images/last.png";
    }

    /**
     * 获取分页对象
     *
     * @return 分页对象
     */
    public PaginatedDTO getTablePaginatedDTO() {
        return tablePaginatedDTO;
    }

    /**
     * 设置分页对象
     *
     * @param tablePaginatedDTO 分页对象
     */
    public void setTablePaginatedDTO(PaginatedDTO tablePaginatedDTO) {
        this.tablePaginatedDTO = tablePaginatedDTO;
    }

    /**
     * 获取首页图标路径
     *
     * @return 首页图标路径
     */
    public String getTableFirstButtonIconPath() {
        return tableFirstButtonIconPath;
    }

    /**
     * 设置首页图标路径
     *
     * @param tableFirstButtonIconPath 首页图标路径
     */
    public void setTableFirstButtonIconPath(String tableFirstButtonIconPath) {
        this.tableFirstButtonIconPath = tableFirstButtonIconPath;
    }

    /**
     * 获取上一页图标路径
     *
     * @return 上一页图标路径
     */
    public String getTablePreviousButtonIconPath() {
        return tablePreviousButtonIconPath;
    }

    /**
     * 设置上一页图标路径
     *
     * @param tablePreviousButtonIconPath 上一页图标路径
     */
    public void setTablePreviousButtonIconPath(String tablePreviousButtonIconPath) {
        this.tablePreviousButtonIconPath = tablePreviousButtonIconPath;
    }

    /**
     * 获取下一页图标路径
     *
     * @return 下一页图标路径
     */
    public String getTableNextButtonIconPath() {
        return tableNextButtonIconPath;
    }

    /**
     * 设置下一页图标路径
     *
     * @param tableNextButtonIconPath 下一页图标路径
     */
    public void setTableNextButtonIconPath(String tableNextButtonIconPath) {
        this.tableNextButtonIconPath = tableNextButtonIconPath;
    }

    /**
     * 获取最后一页页图标路径
     *
     * @return 最后一页页图标路径
     */
    public String getTableLastButtonIconPath() {
        return tableLastButtonIconPath;
    }

    /**
     * 设置最后一页页图标路径
     *
     * @param tableLastButtonIconPath 最后一页页图标路径
     */
    public void setTableLastButtonIconPath(String tableLastButtonIconPath) {
        this.tableLastButtonIconPath = tableLastButtonIconPath;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
