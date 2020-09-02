package org.tiankafei.ui.design.example.moretabletitle;

interface GridSplit {

    /**
     * 合并列的单元格数
     *
     * @param row
     * @param column
     * @return
     */
    int spanCol(int row, int column);

    /**
     * 显示合并列的单元格数
     *
     * @param row
     * @param column
     * @return
     */
    int visibleColCell(int row, int column);

    /**
     * 合并行的单元格数
     *
     * @param row
     * @param column
     * @return
     */
    int spanRow(int row, int column);

    /**
     * 显示合并行的单元格数
     *
     * @param row
     * @param column
     * @return
     */
    int visibleRowCell(int row, int column);

    /**
     * 是否显示
     *
     * @param row
     * @param column
     * @return
     */
    boolean isVisible(int row, int column);
}