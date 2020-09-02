package org.tiankafei.ui.design.example.moretabletitle;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author 甜咖啡
 */
public class GroupHeader {
    public static final String EMPTY_LABEL = "EMPTY";

    public static boolean isEmpty(TableColumn tableColumn) {
        return EMPTY_LABEL.equals(tableColumn.getHeaderValue());
    }

    private String name;
    private int begin = -1;
    private int end = -1;
    private List<GroupHeader> subHeaders = Lists.newArrayList();

    public GroupHeader(String name) {
        this.name = name;
    }

    public GroupHeader(String name, int index) {
        this(name, index, index);
    }

    public GroupHeader(String name, int begin, int end) {
        this.name = name;
        setSpan(begin, end);
    }

    public int getBeginColumn() {
        return begin;
    }

    public GroupHeader setSpan(int begin, int end) {
        this.begin = begin;
        this.end = end;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    public GroupHeader setName(String name) {
        this.name = name;
        return this;
    }

    public GroupHeader addSubHeader(GroupHeader subHeader) {
        subHeaders.add(subHeader);
        return this;
    }

    public ColumnGroup createColumnGroup(TableColumnModel tableColumnModel) {
        ColumnGroup columnGroup = new ColumnGroup(name);
        if (begin > 0) {
            for (int i = begin; i <= end; i++) {
                columnGroup.add(tableColumnModel.getColumn(i));
            }
        }

        for (GroupHeader groupHeader : subHeaders) {
            columnGroup.add(groupHeader.createColumnGroup(tableColumnModel));
        }
        return columnGroup;
    }
}