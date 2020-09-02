package org.tiankafei.ui.design.example.moretabletitle;

import java.util.List;

class GridSplitImpl implements GridSplit {
    List<CellData>[] listData;
    CellData[][] cover;

    public GridSplitImpl(List<CellData>[] listData, CellData[][] cover) {
        this.listData = listData;
        this.cover = cover;
    }

    @Override
    public boolean isVisible(int row, int column) {
        if (row >= listData.length || row < 0) {
            return true;
        }
        return cover[row][column] == null;
    }

    @Override
    public int spanCol(int row, int column) {
        if (listData[row].size() < column + 1
                || listData[row].get(column) == null) {
            return 1;
        }
        return listData[row].get(column).getColSpan();
    }

    @Override
    public int spanRow(int row, int column) {
        if (listData[row].size() < column + 1
                || listData[row].get(column) == null) {
            return 1;
        }
        return listData[row].get(column).getRowSpan();
    }

    @Override
    public int visibleColCell(int row, int column) {
        if (row >= listData.length || row < 0) {
            return -1;
        }
        return isVisible(row, column) ? column : cover[row][column].getPosCol();
    }

    @Override
    public int visibleRowCell(int row, int column) {
        if (row >= listData.length || row < 0) {
            return -1;
        }
        return isVisible(row, column) ? row : cover[row][column].getPosRow();
    }
}
