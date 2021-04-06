package org.tiankafei.ui.control;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.BoxLayout;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.ui.control.choose.TiankafeiChooseFactory;
import org.tiankafei.ui.control.constants.TiankafeiChooseConstants;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiChooseAction;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.againsui.TiankafeiList;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfList;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义左侧选择到右侧的选择器
 *
 * @author 甜咖啡
 */
public class TiankafeiLeftChooseRightControls {

    /**
     * 要选择的列表
     */
    private List<CodeNameDTO> codeNameDtoList;

    /**
     * 已选的列表
     */
    private List<CodeNameDTO> targetCodeNameDtoList;

    public TiankafeiLeftChooseRightControls() {
        codeNameDtoList = Lists.newArrayList();
        targetCodeNameDtoList = Lists.newArrayList();
    }

    public TkfPanel initTiankafeiLeftChooseRightControls(TiankafeiFrame tiankafeiFrame) {
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfPanel.setLayout(new BoxLayout(tkfPanel, BoxLayout.X_AXIS));

        //左侧选择面板
        TiankafeiPanel leftTiankafeiPanel = new TiankafeiPanel();
        leftTiankafeiPanel.setBackgroundColor(Color.LIGHT_GRAY);
        TkfPanel leftTkfPanel = leftTiankafeiPanel.initTiankafeiPanel();
        tkfPanel.add(leftTkfPanel);
        //左侧选择JList
        TiankafeiList leftTiankafeiList = new TiankafeiList();
        leftTiankafeiList.setCodeNameDtoList(codeNameDtoList);
        TkfList leftTkfList = leftTiankafeiList.initTiankafeiList();
        leftTkfPanel.add(leftTkfList);

        //中间操作面板
        TiankafeiPanel operateTiankafeiPanel = new TiankafeiPanel();
        TkfPanel operateTkfPanel = operateTiankafeiPanel.initTiankafeiPanel();
        operateTkfPanel.setLayout(new BoxLayout(operateTkfPanel, BoxLayout.Y_AXIS));
        tkfPanel.add(operateTkfPanel);

        //右侧目标面板
        TiankafeiPanel rightTiankafeiPanel = new TiankafeiPanel();
        rightTiankafeiPanel.setBackgroundColor(Color.LIGHT_GRAY);
        TkfPanel rightTkfPanel = rightTiankafeiPanel.initTiankafeiPanel();
        tkfPanel.add(rightTkfPanel);
        //右侧目标JList
        TiankafeiList rightTiankafeiList = new TiankafeiList();
        rightTiankafeiList.setCodeNameDtoList(targetCodeNameDtoList);
        TkfList rightTkfList = rightTiankafeiList.initTiankafeiList();
        rightTkfPanel.add(rightTkfList);

        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.UN_CHOOSE, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE_ALL, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.UN_CHOOSE_ALL, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE_TOP, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE_UP, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE_DOWN, leftTkfList, rightTkfList));
        operateTkfPanel.add(initOperateButton(TiankafeiChooseConstants.CHOOSE_BOTTOM, leftTkfList, rightTkfList));

        tkfPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //初始化面板的大小
                initPanelDimension(tiankafeiFrame, leftTkfPanel, operateTkfPanel, rightTkfPanel);
            }
        });
        //初始化面板的大小
        initPanelDimension(tiankafeiFrame, leftTkfPanel, operateTkfPanel, rightTkfPanel);
        return tkfPanel;
    }

    /**
     * 初始化面板的大小
     *
     * @param tiankafeiFrame
     * @param leftTkfPanel
     * @param operateTkfPanel
     * @param rightTkfPanel
     */
    private void initPanelDimension(TiankafeiFrame tiankafeiFrame, TkfPanel leftTkfPanel, TkfPanel operateTkfPanel, TkfPanel rightTkfPanel) {
        double width = (tiankafeiFrame.getSize().getWidth() - operateTkfPanel.getPreferredSize().getWidth()) / 2;
        double height = leftTkfPanel.getSize().getHeight();
        Dimension dimension = new Dimension((int) width, (int) height);
        leftTkfPanel.setPreferredSize(dimension);
        rightTkfPanel.setPreferredSize(dimension);
    }

    /**
     * 初始化操作按钮控件
     *
     * @param text         按钮上的文本
     * @param leftTkfList  左侧要选择的面板
     * @param rightTkfList 右侧选中的面板
     * @return 按钮对象
     */
    @SuppressWarnings("rawtypes")
    private TkfButton initOperateButton(String text, TkfList leftTkfList, TkfList rightTkfList) {
        TiankafeiButton tiankafeiButton = new TiankafeiButton();
        tiankafeiButton.setText(text);
        TkfButton tkfButton = tiankafeiButton.initTiankafeiButton();
        //操作事件
        AbstractTiankafeiChooseAction abstractTiankafeiChooseAction = TiankafeiChooseFactory.getAbstractTiankafeiChooseAction(text, leftTkfList, rightTkfList);
        tkfButton.addActionListener(abstractTiankafeiChooseAction);
        return tkfButton;
    }

    public List<CodeNameDTO> getCodeNameDtoList() {
        return codeNameDtoList;
    }

    public void setCodeNameDtoList(List<CodeNameDTO> codeNameDtoList) {
        this.codeNameDtoList = codeNameDtoList;
    }

    public List<CodeNameDTO> getTargetCodeNameDtoList() {
        return targetCodeNameDtoList;
    }

    public void setTargetCodeNameDtoList(List<CodeNameDTO> targetCodeNameDtoList) {
        this.targetCodeNameDtoList = targetCodeNameDtoList;
    }
}
