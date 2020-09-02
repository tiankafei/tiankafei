package org.tiankafei.ui.control.condition;

import java.util.List;
import javax.swing.JTextField;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.condition.actions.TiankafeiConditionTkfComboBoxAction;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.control.util.CommonCheckUtil;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义截取条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiSubstrConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 799131165015708607L;

    /**
     * 构造自定义截取条件对象
     */
    public TiankafeiSubstrConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_SUBSTR_CONDITION);
    }

    @Override
    public void handleTiankafeiCondition(TkfPanel conditionTkfPanel, int number, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) throws BaseException {
        //先删除
        deleteTiankafeiCondition(conditionTkfPanel, number);
        //截取开始位置标签
        TiankafeiLabel beginIndexTiankafeiLabel = new TiankafeiLabel();
        beginIndexTiankafeiLabel.setText("第");
        beginIndexTiankafeiLabel.setWidth(12);
        TkfLabel beginIndexTkfLabel = beginIndexTiankafeiLabel.initTiankafeiLabel();
        //截取开始位置输入框
        TiankafeiTextField beginIndexTiankafeiTextField = new TiankafeiTextField();
        beginIndexTiankafeiTextField.setWidth(20);
        TkfTextField beginIndexTkfTextField = beginIndexTiankafeiTextField.initTiankafeiTextField();
        //截取数量位置标签
        TiankafeiLabel numberTiankafeiLabel = new TiankafeiLabel();
        numberTiankafeiLabel.setText("位取");
        numberTiankafeiLabel.setWidth(24);
        TkfLabel numberTkfLabel = numberTiankafeiLabel.initTiankafeiLabel();
        //截取数量位置输入框
        TiankafeiTextField endIndexTiankafeiTextField = new TiankafeiTextField();
        endIndexTiankafeiTextField.setWidth(20);
        TkfTextField endIndexTkfTextField = endIndexTiankafeiTextField.initTiankafeiTextField();
        //截取数量位置标签
        TiankafeiLabel endIndexTiankafeiLabel = new TiankafeiLabel();
        endIndexTiankafeiLabel.setText("位");
        endIndexTiankafeiLabel.setWidth(12);
        TkfLabel endIndexTkfLabel = endIndexTiankafeiLabel.initTiankafeiLabel();

        //过滤条件列表
        int index = 3;
        List<AbstractTiankafeiConditionDTO> tiankafeiConditionList = TiankafeiConditionConstants.getTiankafeiConditionList();
        AbstractTiankafeiConditionDTO[] tiankafeiConditionArray = new AbstractTiankafeiConditionDTO[tiankafeiConditionList.size() - index];
        for (int i = 0, lem = tiankafeiConditionList.size() - index; i < lem; i++) {
            tiankafeiConditionArray[i] = tiankafeiConditionList.get(i + index);
        }
        TiankafeiComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTiankafeiComboBox = new TiankafeiComboBox<AbstractTiankafeiConditionDTO>(tiankafeiConditionArray);
        tiankafeiConditionTiankafeiComboBox.setWidth(80);
        TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = tiankafeiConditionTiankafeiComboBox.initTiankafeiComboBox();
        tiankafeiConditionTkfComboBox.addItemListener(new TiankafeiConditionTkfComboBoxAction(conditionTkfPanel, tiankafeiConditionTkfComboBox, number + 6));

        //值输入框
        TiankafeiTextField valueTiankafeiTextField = new TiankafeiTextField();
        valueTiankafeiTextField.setWidth(200);
        TkfTextField tkfTextField = valueTiankafeiTextField.initTiankafeiTextField();

        //控件加入面板
        conditionTkfPanel.add(beginIndexTkfLabel, number);
        conditionTkfPanel.add(beginIndexTkfTextField, number + 1);
        conditionTkfPanel.add(numberTkfLabel, number + 2);
        conditionTkfPanel.add(endIndexTkfTextField, number + 3);
        conditionTkfPanel.add(endIndexTkfLabel, number + 4);
        conditionTkfPanel.add(tiankafeiConditionTkfComboBox, number + 5);
        conditionTkfPanel.add(tkfTextField, number + 6);

        if (tiankafeiCustomConditionDTO != null) {
            String beginIndex = "";
            if (tiankafeiCustomConditionDTO.getBeginIndex() != -1) {
                beginIndex = String.valueOf(tiankafeiCustomConditionDTO.getBeginIndex());
            }
            beginIndexTkfTextField.setText(beginIndex);

            String numberIndex = "";
            if (tiankafeiCustomConditionDTO.getNumberIndex() != -1) {
                numberIndex = String.valueOf(tiankafeiCustomConditionDTO.getNumberIndex());
            }
            endIndexTkfTextField.setText(numberIndex);
            AbstractTiankafeiConditionDTO interceptionTiankafeiConditionDTO = tiankafeiCustomConditionDTO.getInterceptionTiankafeiConditionDTO();
            tiankafeiConditionTkfComboBox.getTiankafeiModelUiVO().setParamObject(interceptionTiankafeiConditionDTO);
            tiankafeiConditionTkfComboBox.setSelectedIndex(tiankafeiCustomConditionDTO.getInterceptionTiankafeiConditionIndex());
            if (tiankafeiCustomConditionDTO.getValue() != null) {
                tkfTextField.setText(tiankafeiCustomConditionDTO.getValue().toString());
            }
        }
        //刷新面板
        conditionTkfPanel.updateUI();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String setAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO, int number) throws BaseException {
        String message = null;
        JTextField beginIndexTextField = (JTextField) tempTkfPanel.getComponents()[number + 1];
        String beginIndexValue = beginIndexTextField.getText().trim();
        if (StringUtils.isNotEmpty(beginIndexValue)) {
            message = CommonCheckUtil.checkAllNumberValidationTwoEmpty(beginIndexValue, true);
            if (StringUtils.isNotEmpty(message)) {
                StringBuffer errorBuffer = new StringBuffer();
                errorBuffer.append(getInputErrorInfo(tiankafeiCustomConditionDTO)).append("操作中的第___位").append(message);
                throw new BaseException(errorBuffer.toString());
            }
            tiankafeiCustomConditionDTO.setBeginIndex(Integer.parseInt(beginIndexValue));
        }

        JTextField endIndexTextField = (JTextField) tempTkfPanel.getComponents()[number + 3];
        String endIndexValue = endIndexTextField.getText().trim();
        if (StringUtils.isNotEmpty(endIndexValue)) {
            message = CommonCheckUtil.checkAllNumberValidationTwoEmpty(endIndexValue, true);
            if (StringUtils.isNotEmpty(message)) {
                StringBuffer errorBuffer = new StringBuffer();
                errorBuffer.append(getInputErrorInfo(tiankafeiCustomConditionDTO)).append("操作中的取___位").append(message);
                throw new BaseException(errorBuffer.toString());
            }
            tiankafeiCustomConditionDTO.setNumberIndex(Integer.parseInt(endIndexValue));
        }

        TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = (TkfComboBox<AbstractTiankafeiConditionDTO>) tempTkfPanel.getComponents()[number + 5];
        AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = (AbstractTiankafeiConditionDTO) tiankafeiConditionTkfComboBox.getSelectedItem();
        int tiankafeiConditionIndex = tiankafeiConditionTkfComboBox.getSelectedIndex();
        tiankafeiCustomConditionDTO.setInterceptionTiankafeiConditionDTO(abstractTiankafeiConditionDTO);
        tiankafeiCustomConditionDTO.setInterceptionTiankafeiConditionIndex(tiankafeiConditionIndex);

        //获取值
        abstractTiankafeiConditionDTO.setAbstractTiankafeiConditionValue(tempTkfPanel, tiankafeiCustomConditionDTO, number + 6);

        return message;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clearAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, int number) {
        JTextField beginIndexTextField = (JTextField) tempTkfPanel.getComponents()[number + 1];
        beginIndexTextField.setText("");

        JTextField endIndexTextField = (JTextField) tempTkfPanel.getComponents()[number + 3];
        endIndexTextField.setText("");

        TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox = (TkfComboBox<AbstractTiankafeiConditionDTO>) tempTkfPanel.getComponents()[number + 5];
        AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = (AbstractTiankafeiConditionDTO) tiankafeiConditionTkfComboBox.getSelectedItem();
        abstractTiankafeiConditionDTO.clearAbstractTiankafeiConditionValue(tempTkfPanel, number + 6);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer();
        List<Object> paramList = createParamList();

        sqlBuffer.append(" SUBSTR(").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(", ?, ?) ");
        paramList.add(tiankafeiCustomConditionDTO.getBeginIndex());
        paramList.add(tiankafeiCustomConditionDTO.getEndValue());

        AbstractTiankafeiConditionDTO interceptionTiankafeiConditionDTO = tiankafeiCustomConditionDTO.getInterceptionTiankafeiConditionDTO();
        tiankafeiCustomConditionDTO.getInterceptionTiankafeiConditionDTO();
        SqlParamDTO tempSqlParamDTO = interceptionTiankafeiConditionDTO.getAbstractTiankafeiConditionSql(tiankafeiCustomConditionDTO);

        sqlBuffer.append(tempSqlParamDTO.getSql().replace(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN, ""));
        paramList.addAll(tempSqlParamDTO.getParamList());
        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "截取";
    }

}
