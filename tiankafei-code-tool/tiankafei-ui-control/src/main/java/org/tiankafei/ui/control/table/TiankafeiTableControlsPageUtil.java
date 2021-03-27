package org.tiankafei.ui.control.table;

import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;
import org.tiankafei.common.dto.PaginatedDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsFirstPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsJumpPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsLastPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsNextPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsNumberPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsPreviousPageAction;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 表格控件分页抽象类
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsPageUtil extends AbstractTiankafeiTableControlsPageUtil {

    /**
     * 表格分页按钮
     */
    private TkfButton[] tablePageTkfButton;

    /**
     * 跳转下拉框
     */
    private TkfComboBox<Integer> jumpPageTkfComboBox;

    /**
     * 首页按钮、上一页按钮、下一页按钮、最后一页按钮
     */
    private TiankafeiButton firstTiankafeiButton, previousTiankafeiButton, nextTiankafeiButton, lastTiankafeiButton;

    @Override
    public void initTiankafeiTablePagePanel(TiankafeiTablePageVO tiankafeiTablePageVO, TkfPanel pageTkfPanel, List<TiankafeiTable> tiankafeiTableList) {
        //初始化中间分页按钮面板
        TkfPanel pageButtonTkfPanel = initPageButtonTiankafeiPanel(tiankafeiTablePageVO, tiankafeiTableList);
        pageTkfPanel.add(pageButtonTkfPanel, BorderLayout.CENTER);

        //初始化右侧跳转面板
        TkfPanel pageJumpTkfPanel = initPageJumpTiankafeiPanel(tiankafeiTablePageVO, tiankafeiTableList);
        pageTkfPanel.add(pageJumpTkfPanel, BorderLayout.EAST);
    }

    @Override
    public void initTiankafeiTablePageData(TiankafeiTablePageVO tiankafeiTablePageVO) {
        PaginatedDTO tablePaginatedDTO = tiankafeiTablePageVO.getTablePaginatedDTO();
        int currentPage = tablePaginatedDTO.getCurrentPage();
        jumpPageTkfComboBox.setSelectedIndex(currentPage - 1);

        int pageCount = tablePaginatedDTO.getPageCount();
        int number5 = 5;
        int number2 = 2;
        if (pageCount > number5) {
            if (currentPage == 1 || currentPage == number2) {
                tablePageTkfButton[0].setText(1 + "");
                tablePageTkfButton[1].setText(2 + "");
                tablePageTkfButton[2].setText(3 + "");
                tablePageTkfButton[3].setText(4 + "");
                tablePageTkfButton[4].setText(5 + "");
            } else if (currentPage == pageCount || currentPage == pageCount - 1) {
                tablePageTkfButton[0].setText((pageCount - 4) + "");
                tablePageTkfButton[1].setText((pageCount - 3) + "");
                tablePageTkfButton[2].setText((pageCount - 2) + "");
                tablePageTkfButton[3].setText((pageCount - 1) + "");
                tablePageTkfButton[4].setText(pageCount + "");
            } else {
                tablePageTkfButton[0].setText((currentPage - 2) + "");
                tablePageTkfButton[1].setText((currentPage - 1) + "");
                tablePageTkfButton[2].setText(currentPage + "");
                tablePageTkfButton[3].setText((currentPage + 1) + "");
                tablePageTkfButton[4].setText((currentPage + 2) + "");
            }
        }
        for (int i = 0, lem = tablePageTkfButton.length; i < lem; i++) {
            int tempCurrentPage = Integer.parseInt(tablePageTkfButton[i].getText());
            if (tempCurrentPage == currentPage) {
                tablePageTkfButton[i].setForeground(Color.RED);
            } else {
                tablePageTkfButton[i].setForeground(Color.BLACK);
            }
        }

        if (currentPage == 1) {
            firstTiankafeiButton.setEnabled(false);
            previousTiankafeiButton.setEnabled(false);

            nextTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableNextButtonIconPath());
            nextTiankafeiButton.setImageIcon();

            lastTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableLastButtonIconPath());
            lastTiankafeiButton.setImageIcon();
        } else if (currentPage == pageCount) {
            firstTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableFirstButtonIconPath());
            firstTiankafeiButton.setImageIcon();

            previousTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTablePreviousButtonIconPath());
            previousTiankafeiButton.setImageIcon();

            nextTiankafeiButton.setEnabled(false);
            lastTiankafeiButton.setEnabled(false);
        } else {
            firstTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableFirstButtonIconPath());
            firstTiankafeiButton.setImageIcon();

            previousTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTablePreviousButtonIconPath());
            previousTiankafeiButton.setImageIcon();

            nextTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableNextButtonIconPath());
            nextTiankafeiButton.setImageIcon();

            lastTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableLastButtonIconPath());
            lastTiankafeiButton.setImageIcon();
        }
    }

    @Override
    public String initTiankafeiTablePageTkfLabel(PaginatedDTO tablePaginatedDTO) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(tablePaginatedDTO.getCurrentPage()).append("页").append("/").append("共").append(tablePaginatedDTO.getPageCount()).append("页,").append(tablePaginatedDTO.getRecordCount()).append("条记录");
        return buffer.toString();
    }

    @Override
    public List<List<Object>> initTiankafeiTablePageDataList(PaginatedDTO tablePaginatedDTO, List<List<Object>> dataListList) {
        List<List<Object>> endDataListList = Lists.newArrayList();
        int index = tablePaginatedDTO.getBeginRecordIndex();
        int length = tablePaginatedDTO.getEndRecordIndex();
        for (int i = index; i < length; i++) {
            endDataListList.add(dataListList.get(i));
        }
        return endDataListList;
    }

    /**
     * 初始化分页按钮面板
     *
     * @param tiankafeiTablePageVO 自定义表格分页对象
     * @return 分页按钮面板
     */
    private TkfPanel initPageButtonTiankafeiPanel(TiankafeiTablePageVO tiankafeiTablePageVO, List<TiankafeiTable> tiankafeiTableList) {
        PaginatedDTO tablePaginatedDTO = tiankafeiTablePageVO.getTablePaginatedDTO();

        TiankafeiPanel pageButtonTiankafeiPanel = new TiankafeiPanel();
        TkfPanel pageButtonTkfPanel = pageButtonTiankafeiPanel.initTiankafeiPanel();
        pageButtonTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //首页按钮
        firstTiankafeiButton = new TiankafeiButton();
        firstTiankafeiButton.setWidth(40);
        firstTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableFirstButtonIconPath());
        firstTiankafeiButton.setIconHeight(15);
        firstTiankafeiButton.setIconWidth(15);
        TkfButton firstTkfButton = firstTiankafeiButton.initTiankafeiButton();
        pageButtonTkfPanel.add(firstTkfButton);
        firstTkfButton.addActionListener(new TiankafeiTableControlsFirstPageAction(this, tiankafeiTableList, tiankafeiTablePageVO));

        //上一页按钮
        previousTiankafeiButton = new TiankafeiButton();
        previousTiankafeiButton.setWidth(40);
        previousTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTablePreviousButtonIconPath());
        previousTiankafeiButton.setIconHeight(15);
        previousTiankafeiButton.setIconWidth(15);
        TkfButton previousTkfButton = previousTiankafeiButton.initTiankafeiButton();
        pageButtonTkfPanel.add(previousTkfButton);
        previousTkfButton.addActionListener(new TiankafeiTableControlsPreviousPageAction(this, tiankafeiTableList, tiankafeiTablePageVO));

        //中间页数按钮
        TiankafeiButton[] tablePageTiankafeiButton = null;
        int pageCount = tablePaginatedDTO.getPageCount();
        int number5 = 5;
        if (pageCount >= number5) {
            tablePageTiankafeiButton = new TiankafeiButton[5];
        } else {
            tablePageTiankafeiButton = new TiankafeiButton[pageCount];
        }
        int tablePageButtonLength = tablePageTiankafeiButton.length;
        tablePageTkfButton = new TkfButton[tablePageButtonLength];
        for (int pageButtonIndex = 0; pageButtonIndex < tablePageButtonLength; pageButtonIndex++) {
            tablePageTiankafeiButton[pageButtonIndex] = new TiankafeiButton();
            tablePageTiankafeiButton[pageButtonIndex].setWidth(40);
            tablePageTiankafeiButton[pageButtonIndex].setText(String.valueOf((pageButtonIndex + 1)));
            tablePageTkfButton[pageButtonIndex] = tablePageTiankafeiButton[pageButtonIndex].initTiankafeiButton();
            pageButtonTkfPanel.add(tablePageTkfButton[pageButtonIndex]);
            tablePageTkfButton[pageButtonIndex].addActionListener(new TiankafeiTableControlsNumberPageAction(this, tiankafeiTableList, tiankafeiTablePageVO));
        }

        //下一页按钮
        nextTiankafeiButton = new TiankafeiButton();
        nextTiankafeiButton.setWidth(40);
        nextTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableNextButtonIconPath());
        nextTiankafeiButton.setIconHeight(15);
        nextTiankafeiButton.setIconWidth(15);
        TkfButton nextTkfButton = nextTiankafeiButton.initTiankafeiButton();
        pageButtonTkfPanel.add(nextTkfButton);
        nextTkfButton.addActionListener(new TiankafeiTableControlsNextPageAction(this, tiankafeiTableList, tiankafeiTablePageVO));

        //最后页按钮
        lastTiankafeiButton = new TiankafeiButton();
        lastTiankafeiButton.setWidth(40);
        lastTiankafeiButton.setIconFilePath(tiankafeiTablePageVO.getTableLastButtonIconPath());
        lastTiankafeiButton.setIconHeight(15);
        lastTiankafeiButton.setIconWidth(15);
        TkfButton lastTkfButton = lastTiankafeiButton.initTiankafeiButton();
        pageButtonTkfPanel.add(lastTkfButton);
        lastTkfButton.addActionListener(new TiankafeiTableControlsLastPageAction(this, tiankafeiTableList, tiankafeiTablePageVO));

        return pageButtonTkfPanel;
    }

    /**
     * 初始化分页跳转面板
     *
     * @param tiankafeiTablePageVO 表格分页对象
     * @return 分页跳转面板
     */
    private TkfPanel initPageJumpTiankafeiPanel(TiankafeiTablePageVO tiankafeiTablePageVO, List<TiankafeiTable> tiankafeiTableList) {
        PaginatedDTO tablePaginatedDTO = tiankafeiTablePageVO.getTablePaginatedDTO();

        TiankafeiPanel pageJumpTiankafeiPanel = new TiankafeiPanel();
        TkfPanel pageJumpTkfPanel = pageJumpTiankafeiPanel.initTiankafeiPanel();
        pageJumpTkfPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        TiankafeiLabel jumpTiankafeiLabel = new TiankafeiLabel();
        jumpTiankafeiLabel.setText("转到");
        jumpTiankafeiLabel.setWidth(26);
        pageJumpTkfPanel.add(jumpTiankafeiLabel.initTiankafeiLabel());

        //页数下拉框
        Vector<Integer> jumpPageVector = new Vector<Integer>();
        int pageCount = tablePaginatedDTO.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            jumpPageVector.add(i + 1);
        }
        TiankafeiComboBox<Integer> jumpPageTiankafeiComboBox = new TiankafeiComboBox<Integer>(jumpPageVector);
        jumpPageTiankafeiComboBox.setWidth(60);
        jumpPageTkfComboBox = jumpPageTiankafeiComboBox.initTiankafeiComboBox();
        pageJumpTkfPanel.add(jumpPageTkfComboBox);

        TiankafeiLabel jumpPageTiankafeiLabel = new TiankafeiLabel();
        jumpPageTiankafeiLabel.setText("页");
        jumpPageTiankafeiLabel.setWidth(14);
        pageJumpTkfPanel.add(jumpPageTiankafeiLabel.initTiankafeiLabel());

        TiankafeiButton jumpPageTiankafeiButton = new TiankafeiButton();
        jumpPageTiankafeiButton.setText("确定");
        jumpPageTiankafeiButton.setWidth(60);
        TkfButton jumpPageTkfButton = jumpPageTiankafeiButton.initTiankafeiButton();
        pageJumpTkfPanel.add(jumpPageTkfButton);
        jumpPageTkfButton.addActionListener(new TiankafeiTableControlsJumpPageAction(this, tiankafeiTableList, tiankafeiTablePageVO, jumpPageTkfComboBox));

        return pageJumpTkfPanel;
    }

}
