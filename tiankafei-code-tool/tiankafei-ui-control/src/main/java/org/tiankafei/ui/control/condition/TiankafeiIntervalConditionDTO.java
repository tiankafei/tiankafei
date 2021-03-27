package org.tiankafei.ui.control.condition;

import java.util.List;
import javax.swing.JTextField;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义区间条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiIntervalConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 8521076743691053873L;

    /**
     * 构造自定义区间条件对象
     */
    public TiankafeiIntervalConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_INTERVAL_CONDITION);
    }

    @Override
    public void handleTiankafeiCondition(TkfPanel conditionTkfPanel, int number, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        //先删除
        deleteTiankafeiCondition(conditionTkfPanel, number);
        //区间前标签
        TiankafeiLabel beginTiankafeiLabel = new TiankafeiLabel();
        beginTiankafeiLabel.setText("从");
        beginTiankafeiLabel.setWidth(12);
        TkfLabel beginTkfLabel = beginTiankafeiLabel.initTiankafeiLabel();
        //区间前值输入框
        TiankafeiTextField beginValueTiankafeiTextField = new TiankafeiTextField();
        beginValueTiankafeiTextField.setWidth(100);
        TkfTextField beginValueTkfTextField = beginValueTiankafeiTextField.initTiankafeiTextField();
        //区间后标签
        TiankafeiLabel endTiankafeiLabel = new TiankafeiLabel();
        endTiankafeiLabel.setText("到");
        endTiankafeiLabel.setWidth(12);
        TkfLabel endTkfLabel = endTiankafeiLabel.initTiankafeiLabel();
        //区间后值输入框
        TiankafeiTextField endValueTiankafeiTextField = new TiankafeiTextField();
        endValueTiankafeiTextField.setWidth(100);
        TkfTextField endTkfTextField = endValueTiankafeiTextField.initTiankafeiTextField();
        //控件加入面板
        conditionTkfPanel.add(beginTkfLabel, number);
        conditionTkfPanel.add(beginValueTkfTextField, number + 1);
        conditionTkfPanel.add(endTkfLabel, number + 2);
        conditionTkfPanel.add(endTkfTextField, number + 3);

        if (tiankafeiCustomConditionDTO != null) {
            if (tiankafeiCustomConditionDTO.getBeginValue() != null) {
                beginValueTkfTextField.setText(tiankafeiCustomConditionDTO.getBeginValue().toString());
            }
            if (tiankafeiCustomConditionDTO.getEndValue() != null) {
                endTkfTextField.setText(tiankafeiCustomConditionDTO.getEndValue().toString());
            }
        }
        //刷新面板
        conditionTkfPanel.updateUI();
    }

    @Override
    public String setAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO, int number) {
        JTextField beginValueTextField = (JTextField) tempTkfPanel.getComponents()[number + 1];
        tiankafeiCustomConditionDTO.setBeginValue(beginValueTextField.getText().trim());

        JTextField endValueTextField = (JTextField) tempTkfPanel.getComponents()[number + 3];
        tiankafeiCustomConditionDTO.setEndValue(endValueTextField.getText().trim());
        return null;
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" BETWEEN ? AND ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getBeginValue(), tiankafeiCustomConditionDTO.getEndValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public void clearAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, int number) {
        JTextField beginValueTextField = (JTextField) tempTkfPanel.getComponents()[number + 1];
        beginValueTextField.setText("");

        JTextField endValueTextField = (JTextField) tempTkfPanel.getComponents()[number + 3];
        endValueTextField.setText("");
    }

    @Override
    public String toString() {
        return "区间";
    }

}
