package org.tiankafei.ui.control.condition;

import cn.hutool.core.lang.Validator;
import java.util.List;
import javax.swing.JTextField;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义长度条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiLengthConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 8174485152864609047L;

    /**
     * 构造自定义长度条件对象
     */
    public TiankafeiLengthConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_LENGTH_CONDITION);
    }

    @Override
    public String setAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO, int number) {
        String message = null;
        JTextField valueTextField = (JTextField) tempTkfPanel.getComponents()[number];
        String value = valueTextField.getText().trim();
        if (StringUtils.isNotEmpty(value)) {
            if (!Validator.isNumber(value)) {
                message = "您输入的" + value+ "不是数字，请检查！";
            }
            if (StringUtils.isNotEmpty(message)) {
                StringBuffer errorBuffer = new StringBuffer();
                errorBuffer.append(getInputErrorInfo(tiankafeiCustomConditionDTO)).append(message);
                throw new CommonException(errorBuffer.toString());
            }
            tiankafeiCustomConditionDTO.setValue(valueTextField.getText().trim());
            return message;
        }
        return message;
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        SqlParamDTO sqlParamDTO = new SqlParamDTO();

        StringBuffer sqlBuffer = createSqlBuffer().append(" LENGTH(").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(") = ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "长度";
    }

}
