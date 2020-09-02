package org.tiankafei.ui.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiHandleConditionDTO;
import org.tiankafei.ui.control.condition.actions.TiankafeiAddConditionAction;
import org.tiankafei.ui.control.condition.actions.TiankafeiAddGroupAction;
import org.tiankafei.ui.control.condition.actions.TiankafeiConditionTkfComboBoxAction;
import org.tiankafei.ui.control.condition.actions.TiankafeiDeleteConditionAction;
import org.tiankafei.ui.control.condition.actions.TiankafeiDeleteGroupAction;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.ConditionColumnDTO;
import org.tiankafei.ui.control.dto.TiankafeiAssembleConditionDTO;
import org.tiankafei.ui.control.dto.TiankafeiConditionDTO;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiMenuToolBarActoin;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiCheckBox;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfCheckBox;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义过滤条件控件对象
 *
 * @author tiankafei1
 */
public class TiankafeiConditionControls {

    /**
     * 自定义组合条件对象
     */
    private TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO;

    /**
     * 自定义过滤条件属性对象
     */
    private TiankafeiConditionDTO tiankafeiConditionDTO;

    /**
     * 自定义条件面板
     */
    private TkfPanel tkfPanel;

    /**
     * 构造自定义过滤条件控件对象
     */
    public TiankafeiConditionControls() {
        tiankafeiConditionDTO = new TiankafeiConditionDTO();
    }

    /**
     * 初始化自定义过滤条件面板
     *
     * @param frameWidth 控件宽度
     * @param tiankafeiAssembleConditionDTO        对象
     * @return 自定义过滤条件面板
     * @throws BaseException 自定义异常
     */
    public TkfPanel initTiankafeiConditionPanle(int frameWidth, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) throws BaseException {
        int controlsWidth = frameWidth - 50;

        TiankafeiPanel tiankafeiContentPanel = new TiankafeiPanel();
        TkfPanel tkfContentPanel = tiankafeiContentPanel.initTiankafeiPanel();
        /**
         * 界面大面板
         */
        tkfPanel = initTiankafeiPanel(controlsWidth, 0, false, tiankafeiAssembleConditionDTO);

        TiankafeiScrollPane tiankafeiScrollPane = new TiankafeiScrollPane(tkfPanel);
        TkfScrollPane tkfScrollPane = tiankafeiScrollPane.initTiankafeiScrollPane();
        tkfScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        tkfContentPanel.add(tkfScrollPane, BorderLayout.CENTER);

        if (tiankafeiConditionDTO.getConditionButtonFlag()) {
            TiankafeiPanel conditionButtonTiankafeiPanel = new TiankafeiPanel();
            TkfPanel conditionButtonTkfPanel = conditionButtonTiankafeiPanel.initTiankafeiPanel();
            conditionButtonTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            tkfContentPanel.add(conditionButtonTkfPanel, BorderLayout.SOUTH);

            ConfireConditionAction confireConditionAction = new ConfireConditionAction("确定", 60, null);
            TkfButton confireTkfButton = confireConditionAction.initTiankafeiButton();
            conditionButtonTkfPanel.add(confireTkfButton);

            ClearConditionAction clearConditionAction = new ClearConditionAction("清空条件", 80, null);
            TkfButton clearTkfButton = clearConditionAction.initTiankafeiButton();
            conditionButtonTkfPanel.add(clearTkfButton);
        }
        //初始化自定义组合条件对象面板
        initTiankafeiAssembleConditionPanel(tkfPanel, controlsWidth, tiankafeiAssembleConditionDTO);

        return tkfContentPanel;
    }

    /**
     * 初始化自定义组合条件对象面板
     *
     * @param controlsWidth                 控件宽度
     * @param tiankafeiAssembleConditionDTO 自定义组合条件对象
     */
    private void initTiankafeiAssembleConditionPanel(TkfPanel tkfPanel, int controlsWidth, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) {
        if (tiankafeiAssembleConditionDTO != null) {
            List<TiankafeiCustomConditionDTO> tiankafeiCustomConditionList = tiankafeiAssembleConditionDTO.getTiankafeiCustomConditionList();
            if (CollectionUtils.isNotEmpty(tiankafeiCustomConditionList)) {
                for (int i = 0, lem = tiankafeiCustomConditionList.size(); i < lem; i++) {
                    TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO = tiankafeiCustomConditionList.get(i);
                    initAddConditionPanel(tkfPanel, controlsWidth, tiankafeiCustomConditionDTO);
                }
            }

            List<TiankafeiAssembleConditionDTO> tiankafeiAssembleConditionList = tiankafeiAssembleConditionDTO.getTiankafeiAssembleConditionList();
            if (CollectionUtils.isNotEmpty(tiankafeiAssembleConditionList)) {
                for (int i = 0, lem = tiankafeiAssembleConditionList.size(); i < lem; i++) {
                    TiankafeiAssembleConditionDTO childTiankafeiAssembleConditionDTO = tiankafeiAssembleConditionList.get(i);
                    this.initAddGroupPanel(tkfPanel, controlsWidth, childTiankafeiAssembleConditionDTO);

                    Component[] components = tkfPanel.getComponents();
                    int componentLength = components.length;
                    TkfPanel tempTkfPanel = (TkfPanel) components[componentLength - 2];
                    initTiankafeiAssembleConditionPanel(tempTkfPanel, controlsWidth - tiankafeiConditionDTO.getIndentationWidth(), childTiankafeiAssembleConditionDTO);
                }
            }
        }
    }

    /**
     * 初始化区域大面板
     *
     * @param width                         宽度
     * @param paramCode                     参数代码
     * @param deleteFlag                    删除标示
     * @param tiankafeiAssembleConditionDTO 自定义条件对象
     * @return 区域大面板
     * @throws BaseException 自定义异常
     */
    public TkfPanel initTiankafeiPanel(int width, int paramCode, boolean deleteFlag, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) throws BaseException {
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        int number = 2;
        if (paramCode % number == 1) {
            tiankafeiPanel.setBackgroundColor(Color.LIGHT_GRAY);
        }
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfPanel.getTiankafeiModelUiVO().setParamCode(paramCode + "");
        tkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        //初始化操作按钮面板
        TkfPanel handleButtonTkfPanel = initHandleButtonPanel(paramCode, width, tkfPanel, deleteFlag, tiankafeiAssembleConditionDTO);
        tkfPanel.add(handleButtonTkfPanel);

        return tkfPanel;
    }

    /**
     * 初始化操作按钮面板
     *
     * @param paramCode                     参数代码
     * @param width                         宽度
     * @param tkfPanel                      操作面板
     * @param deleteFlag                    删除标示
     * @param tiankafeiAssembleConditionDTO 自定义条件对象
     * @return 操作按钮面板
     * @throws BaseException 自定义异常
     */
    private TkfPanel initHandleButtonPanel(int paramCode, int width, TkfPanel tkfPanel, boolean deleteFlag, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) throws BaseException {
        TiankafeiPanel handleButtonTiankafeiPanel = new TiankafeiPanel();
        handleButtonTiankafeiPanel.setWidth(width);
        handleButtonTiankafeiPanel.setHeight(tiankafeiConditionDTO.getControlsPanelHeight());
        handleButtonTiankafeiPanel.setTopBorderWidth(1);
        handleButtonTiankafeiPanel.setBottomBorderWidth(1);
        handleButtonTiankafeiPanel.setLeftBorderWidth(1);
        handleButtonTiankafeiPanel.setRightBorderWidth(1);
        handleButtonTiankafeiPanel.setBorderColor(Color.RED);
        handleButtonTiankafeiPanel.setBackgroundColor(tkfPanel.getBackground());
        TkfPanel handleButtonTkfPanel = handleButtonTiankafeiPanel.initTiankafeiPanel();
        handleButtonTkfPanel.getTiankafeiModelUiVO().setParamCode("handleButtonPanel" + paramCode);
        handleButtonTkfPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //自定义过滤条件操作抽象对象集合
        List<AbstractTiankafeiHandleConditionDTO> tiankafeiHandleConditionList = tiankafeiConditionDTO.getTiankafeiHandleConditionList();
        AbstractTiankafeiHandleConditionDTO[] tiankafeiHandleConditionArray = new AbstractTiankafeiHandleConditionDTO[tiankafeiHandleConditionList.size()];
        for (int i = 0, lem = tiankafeiHandleConditionList.size(); i < lem; i++) {
            tiankafeiHandleConditionArray[i] = tiankafeiHandleConditionList.get(i);
        }
        //自定义过滤条件操作抽象对象集合
        TiankafeiComboBox<AbstractTiankafeiHandleConditionDTO> tiankafeiHandleConditionTiankafeiComboBox = new TiankafeiComboBox<AbstractTiankafeiHandleConditionDTO>(tiankafeiHandleConditionArray);
        tiankafeiHandleConditionTiankafeiComboBox.setWidth(50);
        TkfComboBox<AbstractTiankafeiHandleConditionDTO> tiankafeiHandleConditionTkfComboBox = tiankafeiHandleConditionTiankafeiComboBox.initTiankafeiComboBox();

        TiankafeiButton addGroupTiankafeiButton = new TiankafeiButton();
        addGroupTiankafeiButton.setText("增加组合条件");
        addGroupTiankafeiButton.setWidth(120);
        TkfButton addGroupTkfButton = addGroupTiankafeiButton.initTiankafeiButton();
        addGroupTkfButton.addActionListener(new TiankafeiAddGroupAction(this, tkfPanel, width));

        TiankafeiButton addConditionTiankafeiButton = new TiankafeiButton();
        addConditionTiankafeiButton.setText("增加条件");
        addConditionTiankafeiButton.setWidth(80);
        TkfButton addConditionTkfButton = addConditionTiankafeiButton.initTiankafeiButton();
        addConditionTkfButton.addActionListener(new TiankafeiAddConditionAction(this, tkfPanel, width));

        TiankafeiButton deleteGroupTiankafeiButton = new TiankafeiButton();
        deleteGroupTiankafeiButton.setText("删除组合条件");
        deleteGroupTiankafeiButton.setWidth(120);
        TkfButton deleteGroupTkfButton = deleteGroupTiankafeiButton.initTiankafeiButton();
        deleteGroupTkfButton.addActionListener(new TiankafeiDeleteGroupAction(this, tkfPanel));

        handleButtonTkfPanel.add(tiankafeiHandleConditionTkfComboBox);
        handleButtonTkfPanel.add(addGroupTkfButton);
        handleButtonTkfPanel.add(addConditionTkfButton);
        if (deleteFlag) {
            handleButtonTkfPanel.add(deleteGroupTkfButton);
        }
        if (tiankafeiAssembleConditionDTO != null) {
            tiankafeiHandleConditionTkfComboBox.setSelectedIndex(tiankafeiAssembleConditionDTO.getAbstractTiankafeiHandleConditionIndex());
        }
        return handleButtonTkfPanel;
    }

    /**
     * 初始化条件面板
     *
     * @param width                       宽度
     * @param paramCode                   参数代码
     * @param backgroundColor             背景色
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     * @return 条件面板
     * @throws BaseException 自定义异常
     */
    public TkfPanel initConditionPanel(int width, int paramCode, Color backgroundColor, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) throws BaseException {
        int indentationWidth = tiankafeiConditionDTO.getIndentationWidth() * paramCode;

        TiankafeiPanel conditionTiankafeiPanel = new TiankafeiPanel();
        conditionTiankafeiPanel.setWidth(width);
        conditionTiankafeiPanel.setHeight(tiankafeiConditionDTO.getControlsPanelHeight());
        conditionTiankafeiPanel.setTopBorderWidth(1);
        conditionTiankafeiPanel.setBottomBorderWidth(1);
        conditionTiankafeiPanel.setLeftBorderWidth(1);
        conditionTiankafeiPanel.setRightBorderWidth(1);
        conditionTiankafeiPanel.setBorderColor(Color.BLACK);
        conditionTiankafeiPanel.setBackgroundColor(backgroundColor);
        TkfPanel conditionTkfPanel = conditionTiankafeiPanel.initTiankafeiPanel();
        conditionTkfPanel.getTiankafeiModelUiVO().setParamCode("conditionPanel" + paramCode);
        conditionTkfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //缩进的空标签
        TiankafeiLabel tiankafeiLabel = new TiankafeiLabel();
        tiankafeiLabel.setWidth(indentationWidth);
        TkfLabel tkfLabel = tiankafeiLabel.initTiankafeiLabel();

        //字段列表下拉框
        List<ConditionColumnDTO> columnList = tiankafeiConditionDTO.getColumnList();
        TiankafeiComboBox<ConditionColumnDTO> tableColumnValueTiankafeiComboBox = new TiankafeiComboBox<ConditionColumnDTO>();
        tableColumnValueTiankafeiComboBox.setValueList(columnList);
        tableColumnValueTiankafeiComboBox.setWidth(80);
        TkfComboBox<ConditionColumnDTO> tableColumnValueTkfComboBox = tableColumnValueTiankafeiComboBox.initTiankafeiComboBox();

        //过滤条件列表
        List<AbstractTiankafeiConditionDTO> tiankafeiConditionList = tiankafeiConditionDTO.getTiankafeiConditionList();
        TiankafeiComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTiankafeiComboBox = new TiankafeiComboBox<AbstractTiankafeiConditionDTO>();
        tiankafeiConditionTiankafeiComboBox.setValueList(tiankafeiConditionList);
        tiankafeiConditionTiankafeiComboBox.setWidth(80);
        TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = tiankafeiConditionTiankafeiComboBox.initTiankafeiComboBox();
        tiankafeiConditionTkfComboBox.addItemListener(new TiankafeiConditionTkfComboBoxAction(conditionTkfPanel, tiankafeiConditionTkfComboBox, 3));

        //值输入框
        TiankafeiTextField valueTiankafeiTextField = new TiankafeiTextField();
        valueTiankafeiTextField.setWidth(200);
        TkfTextField tkfTextField = valueTiankafeiTextField.initTiankafeiTextField();

        //删除图片
        TiankafeiCheckBox deleteConditionTiankafeiCheckBox = new TiankafeiCheckBox();
        deleteConditionTiankafeiCheckBox.setIconFilePath("/images/delete.gif");
        deleteConditionTiankafeiCheckBox.setIconWidth(16);
        deleteConditionTiankafeiCheckBox.setIconHeight(16);
        deleteConditionTiankafeiCheckBox.setBackgroundColor(backgroundColor);
        TkfCheckBox deleteConditionTkfCheckBox = deleteConditionTiankafeiCheckBox.initTiankafeiCheckBox();
        deleteConditionTkfCheckBox.addActionListener(new TiankafeiDeleteConditionAction(this, conditionTkfPanel));

        conditionTkfPanel.add(tkfLabel);
        conditionTkfPanel.add(tableColumnValueTkfComboBox);
        conditionTkfPanel.add(tiankafeiConditionTkfComboBox);
        conditionTkfPanel.add(tkfTextField);
        conditionTkfPanel.add(deleteConditionTkfCheckBox);

        if (tiankafeiCustomConditionDTO != null) {
            tableColumnValueTkfComboBox.setSelectedIndex(tiankafeiCustomConditionDTO.getTableColumnValueIndex());
            tiankafeiConditionTkfComboBox.getTiankafeiModelUiVO().setParamObject(tiankafeiCustomConditionDTO);
            tiankafeiConditionTkfComboBox.setSelectedIndex(tiankafeiCustomConditionDTO.getTiankafeiConditionIndex());
        }
        return conditionTkfPanel;
    }

    /**
     * 设置父面板高度
     *
     * @param tkfPanel 当前面板对象
     * @param height   控件高度
     * @param addFlag  新增为true,删除为false
     */
    public void setParentPanelHeight(TkfPanel tkfPanel, int height, boolean addFlag) {
        Component component = tkfPanel.getParent();
        if (component instanceof TkfPanel) {
            TkfPanel parentTkfPanel = (TkfPanel) component;
            String paramCode = parentTkfPanel.getTiankafeiModelUiVO().getParamCode();
            if (Integer.parseInt(paramCode) >= 0) {
                Dimension parentDimension = parentTkfPanel.getPreferredSize();
                int parentWidth = (int) parentDimension.getWidth();
                int parentHeight = (int) parentDimension.getHeight();
                if (addFlag) {
                    parentTkfPanel.setPreferredSize(new Dimension(parentWidth, parentHeight + height));
                } else {
                    parentTkfPanel.setPreferredSize(new Dimension(parentWidth, parentHeight - height));
                }
                parentTkfPanel.updateUI();

                setParentPanelHeight(parentTkfPanel, height, addFlag);
            }
        }
    }

    /**
     * 确认条件事件
     *
     * @author tiankafei1
     */
    class ConfireConditionAction extends AbstractTiankafeiMenuToolBarActoin {
        private static final long serialVersionUID = -3624246136782328067L;

        /**
         * 构造抽象菜单事件
         *
         * @param displayText  显示文本
         * @param width        控件宽度
         * @param iconFilePath 图标路径
         */
        public ConfireConditionAction(String displayText, int width, String iconFilePath) {
            super(displayText, width, iconFilePath);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO = getCondition();
                SqlParamDTO sqlParamDTO = tiankafeiAssembleConditionDTO.getSqlParamDTO();
                System.out.println(sqlParamDTO.getSql());
                System.out.println(sqlParamDTO.getParamList());
                System.out.println(JSON.toJSONString(tiankafeiAssembleConditionDTO, SerializerFeature.DisableCircularReferenceDetect));
            } catch (BaseException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        }
    }

    /**
     * 清空条件事件
     *
     * @author tiankafei1
     */
    class ClearConditionAction extends AbstractTiankafeiMenuToolBarActoin {
        private static final long serialVersionUID = 5054338824967026391L;

        /**
         * 构造抽象菜单事件
         *
         * @param displayText  显示文本
         * @param width        控件宽度
         * @param iconFilePath 图标路径
         */
        public ClearConditionAction(String displayText, int width, String iconFilePath) {
            super(displayText, width, iconFilePath);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            clearCondition();
        }
    }

    /**
     * 获取自定义条件
     *
     * @return 自定义组合条件对象
     * @throws BaseException 自定义异常
     */
    public TiankafeiAssembleConditionDTO getCondition() throws BaseException {
        TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO = new TiankafeiAssembleConditionDTO();
        //设置自定义条件值
        setConditionValue(tkfPanel, tiankafeiAssembleConditionDTO);

        //设置自定义条件SQL
        SqlParamDTO sqlParamDTO = new SqlParamDTO();
        setConditionSql(tiankafeiAssembleConditionDTO, sqlParamDTO);
        tiankafeiAssembleConditionDTO.setSqlParamDTO(sqlParamDTO);
        return tiankafeiAssembleConditionDTO;
    }

    /**
     * 设置自定义条件
     *
     * @param tiankafeiAssembleConditionDTO 自定义组合条件对象
     * @param sqlParamDTO                   SQL参数对象
     */
    private void setConditionSql(TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO, SqlParamDTO sqlParamDTO) {
        AbstractTiankafeiHandleConditionDTO abstractTiankafeiHandleConditionDTO = tiankafeiAssembleConditionDTO.getAbstractTiankafeiHandleConditionDTO();
        String handleType = abstractTiankafeiHandleConditionDTO.getHandleType();

        StringBuffer sqlBuffer = new StringBuffer();
        List<Object> paramList = Lists.newArrayList();

        List<TiankafeiCustomConditionDTO> tiankafeiCustomConditionList = tiankafeiAssembleConditionDTO.getTiankafeiCustomConditionList();
        for (int i = 0, lem = tiankafeiCustomConditionList.size(); i < lem; i++) {
            TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO = tiankafeiCustomConditionList.get(i);
            SqlParamDTO tempSqlParamDTO = tiankafeiCustomConditionDTO.getSqlParamDTO();
            if (tempSqlParamDTO != null) {
                sqlBuffer.append(tempSqlParamDTO.getSql());
                paramList.addAll(tempSqlParamDTO.getParamList());

                if (i != lem - 1) {
                    sqlBuffer.append(handleType);
                }
            }
        }
        sqlParamDTO.setSql(sqlBuffer.toString()).setParamList(paramList);

        List<TiankafeiAssembleConditionDTO> tiankafeiAssembleConditionList = tiankafeiAssembleConditionDTO.getTiankafeiAssembleConditionList();
        if (CollectionUtils.isNotEmpty(tiankafeiAssembleConditionList) && !tiankafeiAssembleConditionList.isEmpty()) {
            for (int i = 0, lem = tiankafeiAssembleConditionList.size(); i < lem; i++) {
                TiankafeiAssembleConditionDTO tempTiankafeiAssembleConditionDTO = tiankafeiAssembleConditionList.get(i);
                sqlBuffer.append(handleType).append(" ( ");
                setConditionSql(tempTiankafeiAssembleConditionDTO, sqlParamDTO);
                sqlBuffer.append(" ) ");
            }
        }
    }

    /**
     * 设置自定义条件值
     *
     * @param tkfPanel                      自定义条件面板
     * @param tiankafeiAssembleConditionDTO 自定义组合条件对象
     * @throws BaseException
     */
    @SuppressWarnings("unchecked")
    private void setConditionValue(TkfPanel tkfPanel, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) throws BaseException {
        //获取自定义条件集合
        List<TiankafeiCustomConditionDTO> tiankafeiCustomConditionList = tiankafeiAssembleConditionDTO.getTiankafeiCustomConditionList();
        //自定义组合条件对象集合
        List<TiankafeiAssembleConditionDTO> tiankafeiAssembleConditionList = tiankafeiAssembleConditionDTO.getTiankafeiAssembleConditionList();

        Component[] components = tkfPanel.getComponents();
        for (int i = 0, lem = components.length; i < lem; i++) {
            TkfPanel tempTkfPanel = (TkfPanel) components[i];
            String paramCode = tempTkfPanel.getTiankafeiModelUiVO().getParamCode();
            if (paramCode.startsWith("conditionPanel")) {
                TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO = new TiankafeiCustomConditionDTO();

                //获取字段
                TkfComboBox<ConditionColumnDTO> tableColumnValueTkfComboBox = (TkfComboBox<ConditionColumnDTO>) tempTkfPanel.getComponents()[1];
                ConditionColumnDTO conditionColumnDTO = (ConditionColumnDTO) tableColumnValueTkfComboBox.getSelectedItem();
                int tableColumnValueIndex = tableColumnValueTkfComboBox.getSelectedIndex();
                tiankafeiCustomConditionDTO.setConditionColumnDTO(conditionColumnDTO);
                tiankafeiCustomConditionDTO.setTableColumnValueIndex(tableColumnValueIndex);

                //获取字段操作类型
                TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = (TkfComboBox<AbstractTiankafeiConditionDTO>) tempTkfPanel.getComponents()[2];
                AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = (AbstractTiankafeiConditionDTO) tiankafeiConditionTkfComboBox.getSelectedItem();
                int tiankafeiConditionIndex = tiankafeiConditionTkfComboBox.getSelectedIndex();
                tiankafeiCustomConditionDTO.setTiankafeiConditionDTO(abstractTiankafeiConditionDTO);
                tiankafeiCustomConditionDTO.setTiankafeiConditionIndex(tiankafeiConditionIndex);

                //设置值
                String message = abstractTiankafeiConditionDTO.setAbstractTiankafeiConditionValue(tempTkfPanel, tiankafeiCustomConditionDTO, 3);
                if (StringUtils.isNotEmpty(message)) {
                    throw new BaseException(message);
                }
                //设置SQL
                SqlParamDTO sqlParamDTO = abstractTiankafeiConditionDTO.getAbstractTiankafeiConditionSql(tiankafeiCustomConditionDTO);
                if (sqlParamDTO != null) {
                    //要被替换的值
                    String replaceValue = conditionColumnDTO.getTableName() + "." + conditionColumnDTO.getColumnName();
                    String newSql = sqlParamDTO.getSql().replaceAll(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN, replaceValue);
                    sqlParamDTO.setSql(newSql);
                    tiankafeiCustomConditionDTO.setSqlParamDTO(sqlParamDTO);
                }
                tiankafeiCustomConditionList.add(tiankafeiCustomConditionDTO);
            } else if (paramCode.startsWith("handleButtonPanel")) {
                TkfComboBox<AbstractTiankafeiHandleConditionDTO> tiankafeiHandleConditionTkfComboBox = (TkfComboBox<AbstractTiankafeiHandleConditionDTO>) tempTkfPanel.getComponents()[0];
                AbstractTiankafeiHandleConditionDTO abstractTiankafeiHandleConditionDTO = (AbstractTiankafeiHandleConditionDTO) tiankafeiHandleConditionTkfComboBox.getSelectedItem();
                int abstractTiankafeiHandleConditionIndex = tiankafeiHandleConditionTkfComboBox.getSelectedIndex();
                tiankafeiAssembleConditionDTO.setAbstractTiankafeiHandleConditionDTO(abstractTiankafeiHandleConditionDTO);
                tiankafeiAssembleConditionDTO.setAbstractTiankafeiHandleConditionIndex(abstractTiankafeiHandleConditionIndex);
            } else {
                if (Integer.parseInt(paramCode) >= 0) {
                    TiankafeiAssembleConditionDTO tempTiankafeiAssembleConditionDTO = new TiankafeiAssembleConditionDTO();
                    setConditionValue(tempTkfPanel, tempTiankafeiAssembleConditionDTO);
                    tiankafeiAssembleConditionList.add(tempTiankafeiAssembleConditionDTO);
                }
            }
        }
    }

    /**
     * 清空自定义条件
     */
    public void clearCondition() {
        //清空所有值
        clearConditionValue(tkfPanel);
    }

    /**
     * 清空自定义条件值
     *
     * @param tkfPanel 自定义条件面板
     */
    @SuppressWarnings("unchecked")
    private void clearConditionValue(TkfPanel tkfPanel) {
        Component[] components = tkfPanel.getComponents();
        for (int i = 0, lem = components.length; i < lem; i++) {
            TkfPanel tempTkfPanel = (TkfPanel) components[i];
            String paramCode = tempTkfPanel.getTiankafeiModelUiVO().getParamCode();
            if (paramCode.startsWith("conditionPanel")) {
                //获取字段操作类型
                TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = (TkfComboBox<AbstractTiankafeiConditionDTO>) tempTkfPanel.getComponents()[2];
                AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = (AbstractTiankafeiConditionDTO) tiankafeiConditionTkfComboBox.getSelectedItem();
                //清空自定义条件面板
                abstractTiankafeiConditionDTO.clearAbstractTiankafeiConditionValue(tempTkfPanel, 3);
            } else if (paramCode.startsWith("handleButtonPanel")) {
            } else {
                if (Integer.parseInt(paramCode) >= 0) {
                    clearConditionValue(tempTkfPanel);
                }
            }
        }
    }

    /**
     * 更新字段列下拉框值
     *
     * @param columnList 需要更改字段下拉框值列表
     */
    public void updateFieldsColumnComboBox(List<ConditionColumnDTO> columnList) {
        tiankafeiConditionDTO.setColumnList(columnList);
        //更改所有字段列下拉框的值
        updateFieldsColumnComboBoxValue(tkfPanel, columnList);
    }

    /**
     * 更新字段列下拉框值
     *
     * @param tkfPanel                  自定义条件面板
     * @param columnList                需要更改字段下拉框值列表
     */
    @SuppressWarnings("unchecked")
    private void updateFieldsColumnComboBoxValue(TkfPanel tkfPanel, List<ConditionColumnDTO> columnList) {
        Component[] components = tkfPanel.getComponents();
        for (int i = 0, lem = components.length; i < lem; i++) {
            TkfPanel tempTkfPanel = (TkfPanel) components[i];
            String paramCode = tempTkfPanel.getTiankafeiModelUiVO().getParamCode();
            if (paramCode.startsWith("conditionPanel")) {
                //获取字段
                TkfComboBox<ConditionColumnDTO> tableColumnValueTkfComboBox = (TkfComboBox<ConditionColumnDTO>) tempTkfPanel.getComponents()[1];
                ConditionColumnDTO conditionColumnDTO = (ConditionColumnDTO) tableColumnValueTkfComboBox.getSelectedItem();
                tableColumnValueTkfComboBox.removeAllItems();
                for (int columnIndex = 0, columnLength = columnList.size(); columnIndex < columnLength; columnIndex++) {
                    tableColumnValueTkfComboBox.addItem(columnList.get(columnIndex));
                }
                if (columnList.contains(conditionColumnDTO)) {
                    tableColumnValueTkfComboBox.setSelectedItem(conditionColumnDTO);
                } else {
                    tableColumnValueTkfComboBox.setSelectedIndex(0);
                }
            } else if (paramCode.startsWith("handleButtonPanel")) {
            } else {
                if (Integer.parseInt(paramCode) >= 0) {
                    updateFieldsColumnComboBoxValue(tempTkfPanel, columnList);
                }
            }
        }
    }

    /**
     * 初始化新增自定义条件面板
     *
     * @param tkfPanel                      自定义条件面板
     * @param width                         自定义条件面板宽度
     * @param tiankafeiAssembleConditionDTO 自定义组合条件对象
     */
    public void initAddGroupPanel(TkfPanel tkfPanel, int width, TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) {
        try {
            String paramCode = tkfPanel.getTiankafeiModelUiVO().getParamCode();
            int newParamCode = Integer.parseInt(paramCode) + 1;
            //自定义过滤条件属性对象
            TiankafeiConditionDTO tiankafeiConditionDTO = getTiankafeiConditionDTO();
            int needAddHeight = tiankafeiConditionDTO.getControlsPanelHeight();
            //面板当前的宽度和高度
            Dimension dimension = tkfPanel.getPreferredSize();
            int controlsWidth = (int) dimension.getWidth();
            int controlsHeight = (int) dimension.getHeight();
            //设置当前面板的宽度和高度
            tkfPanel.setPreferredSize(new Dimension(controlsWidth, controlsHeight + needAddHeight));
            //设置父面板高度
            setParentPanelHeight(tkfPanel, needAddHeight, true);
            //加入面板，当前面板的面板数量
            Component[] components = tkfPanel.getComponents();
            //初始化条件面板
            TkfPanel conditionTkfPanel = initTiankafeiPanel(width - tiankafeiConditionDTO.getIndentationWidth(), newParamCode, true, tiankafeiAssembleConditionDTO);
            tkfPanel.add(conditionTkfPanel, components.length - 1);
            //更新面板
            tkfPanel.updateUI();
        } catch (BaseException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 删除分组面板
     *
     * @param tkfPanel 分组面板
     */
    public void deleteGroupPanel(TkfPanel tkfPanel) {
        //当前面板高度
        Dimension dimension = tkfPanel.getPreferredSize();
        int controlsHeight = (int) dimension.getHeight();

        Container container = tkfPanel.getParent();
        TkfPanel parentTkfPanel = (TkfPanel) container;
        //父面板的宽度和高度
        Dimension parentDimension = parentTkfPanel.getPreferredSize();
        int parentControlsWidth = (int) parentDimension.getWidth();
        int parentControlsHeight = (int) parentDimension.getHeight();
        parentTkfPanel.remove(tkfPanel);
        //设置当前面板的父面板高度
        parentTkfPanel.setPreferredSize(new Dimension(parentControlsWidth, parentControlsHeight - controlsHeight));
        //设置父面板高度
        setParentPanelHeight(parentTkfPanel, controlsHeight, false);
        //更新面板
        parentTkfPanel.updateUI();
    }

    /**
     * 初始化新增自定义条件面板
     *
     * @param tkfPanel                    自定义条件面板
     * @param width                       控件宽度
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     */
    public void initAddConditionPanel(TkfPanel tkfPanel, int width, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        try {
            //自定义过滤条件属性对象
            TiankafeiConditionDTO tiankafeiConditionDTO = getTiankafeiConditionDTO();
            int needAddHeight = tiankafeiConditionDTO.getControlsPanelHeight();
            int paramCode = Integer.valueOf(tkfPanel.getTiankafeiModelUiVO().getParamCode());
            //面板当前的宽度和高度
            Dimension dimension = tkfPanel.getPreferredSize();
            int controlsWidth = (int) dimension.getWidth();
            int controlsHeight = (int) dimension.getHeight();
            //设置当前面板的宽度和高度
            tkfPanel.setPreferredSize(new Dimension(controlsWidth, controlsHeight + needAddHeight));
            //设置父面板高度
            setParentPanelHeight(tkfPanel, needAddHeight, true);
            //当前面板的面板数量
            Component[] components = tkfPanel.getComponents();
            //初始化条件面板
            TkfPanel conditionTkfPanel = initConditionPanel(width, paramCode, tkfPanel.getBackground(), tiankafeiCustomConditionDTO);
            tkfPanel.add(conditionTkfPanel, components.length - 1);
            //更新面板
            tkfPanel.updateUI();
        } catch (BaseException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 删除自定义条件面板
     *
     * @param conditionTkfPanel 自定义条件面板
     */
    public void deleteConditionPanel(TkfPanel conditionTkfPanel) {
        //自定义过滤条件属性对象
        TiankafeiConditionDTO tiankafeiConditionDTO = getTiankafeiConditionDTO();
        int needAddHeight = tiankafeiConditionDTO.getControlsPanelHeight();

        Container container = conditionTkfPanel.getParent();
        TkfPanel tkfPanel = (TkfPanel) container;
        //父面板的宽度和高度
        Dimension dimension = tkfPanel.getPreferredSize();
        int controlsWidth = (int) dimension.getWidth();
        int controlsHeight = (int) dimension.getHeight();
        tkfPanel.remove(conditionTkfPanel);
        //设置当前面板的父面板高度
        tkfPanel.setPreferredSize(new Dimension(controlsWidth, controlsHeight - needAddHeight));
        //设置父面板高度
        setParentPanelHeight(tkfPanel, needAddHeight, false);
        //更新面板
        tkfPanel.updateUI();
    }

    /**
     * 获取自定义组合条件对象
     *
     * @return 自定义组合条件对象
     */
    public TiankafeiAssembleConditionDTO getTiankafeiAssembleConditionDTO() {
        return tiankafeiAssembleConditionDTO;
    }

    /**
     * 设置自定义组合条件对象
     *
     * @param tiankafeiAssembleConditionDTO 自定义组合条件对象
     */
    public void setTiankafeiAssembleConditionDTO(TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO) {
        this.tiankafeiAssembleConditionDTO = tiankafeiAssembleConditionDTO;
    }

    /**
     * 获取自定义过滤条件属性对象
     *
     * @return 自定义过滤条件属性对象
     */
    public TiankafeiConditionDTO getTiankafeiConditionDTO() {
        return tiankafeiConditionDTO;
    }

    /**
     * 设置自定义过滤条件属性对象
     *
     * @param tiankafeiConditionDTO 自定义过滤条件属性对象
     */
    public void setTiankafeiConditionDTO(TiankafeiConditionDTO tiankafeiConditionDTO) {
        this.tiankafeiConditionDTO = tiankafeiConditionDTO;
    }

    /**
     * 获取自定义条件面板
     *
     * @return 自定义条件面板
     */
    public TkfPanel getTkfPanel() {
        return tkfPanel;
    }

    /**
     * 设置自定义条件面板
     *
     * @param tkfPanel 自定义条件面板
     */
    public void setTkfPanel(TkfPanel tkfPanel) {
        this.tkfPanel = tkfPanel;
    }

}
