package org.tiankafei.ui.control.abstractinterface;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import java.awt.Component;
import java.io.Serializable;
import java.util.List;
import javax.swing.JTextField;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.condition.TiankafeiDefaultConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiIntervalConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLengthConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLessThanConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLessThanEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiListConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiMoreThanConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiMoreThanEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoListConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoNullConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoPrefixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoSuffixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNullConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiPrefixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiSubstrConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiSuffixConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.ConditionColumnDTO;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义过滤条件抽象对象
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiConditionDTO implements Serializable {

    private static final long serialVersionUID = -1886280511248454454L;

    /**
     * 自定义过滤条件标识
     */
    private String condition;

    protected StringBuffer createSqlBuffer() {
        return new StringBuffer();
    }

    protected List<Object> createParamList() {
        return Lists.newArrayList();
    }

    protected List<Object> addParam(Object... objArray) {
        return Lists.newArrayList(objArray);
    }

    /**
     * 设置自定义条件值
     *
     * @param tempTkfPanel                自定义面板对象
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     * @param number                      序号
     * @return 返回错误验证验证信息
     * @throws BaseException 自定义异常
     */
    public String setAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO, int number) throws BaseException {
        JTextField valueTextField = (JTextField) tempTkfPanel.getComponents()[number];
        tiankafeiCustomConditionDTO.setValue(valueTextField.getText().trim());
        return null;
    }

    /**
     * 设置自定义条件的SQL
     *
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     * @return 自定义条件的SQL
     */
    public abstract SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO);

    /**
     * 获取输入错误信息
     *
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     * @return 错误信息
     */
    public String getInputErrorInfo(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        ConditionColumnDTO conditionColumnDTO = tiankafeiCustomConditionDTO.getConditionColumnDTO();
        AbstractTiankafeiConditionDTO tiankafeiConditionDTO = tiankafeiCustomConditionDTO.getTiankafeiConditionDTO();

        StringBuffer errorBuffer = new StringBuffer();
        errorBuffer.append(conditionColumnDTO.toString()).append("的").append(tiankafeiConditionDTO.toString());
        return errorBuffer.toString();
    }

    /**
     * 清空自定义条件面板
     *
     * @param tempTkfPanel 当前面板对象
     * @param number       序号
     */
    public void clearAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, int number) {
        JTextField valueTextField = (JTextField) tempTkfPanel.getComponents()[number];
        valueTextField.setText("");
    }

    /**
     * 处理自定义过滤条件
     *
     * @param conditionTkfPanel           当前过滤条件面板对象
     * @param number                      序号
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     * @throws BaseException 自定义异常
     */
    public void handleTiankafeiCondition(TkfPanel conditionTkfPanel, int number, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) throws BaseException {
        //先删除，再新增
        deleteTiankafeiCondition(conditionTkfPanel, number);
        addTiankafeiCondition(conditionTkfPanel, number, tiankafeiCustomConditionDTO);
    }

    /**
     * 删除自定义过滤条件
     *
     * @param conditionTkfPanel 当前过滤条件面板对象
     * @param number            序号
     */
    public void deleteTiankafeiCondition(TkfPanel conditionTkfPanel, int number) {
        Component[] components = conditionTkfPanel.getComponents();
        for (int i = number, length = components.length - 1; i < length; i++) {
            Component component = components[i];
            conditionTkfPanel.remove(component);
        }
        conditionTkfPanel.updateUI();
    }

    /**
     * 添加自定义过滤条件值
     *
     * @param conditionTkfPanel           当前过滤条件面板对象
     * @param number                      序号
     * @param tiankafeiCustomConditionDTO 自定义条件对象
     */
    public void addTiankafeiCondition(TkfPanel conditionTkfPanel, int number, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        //值输入框
        TiankafeiTextField valueTiankafeiTextField = new TiankafeiTextField();
        valueTiankafeiTextField.setWidth(200);
        TkfTextField tkfTextField = valueTiankafeiTextField.initTiankafeiTextField();
        //增加到面板
        conditionTkfPanel.add(tkfTextField, number);

        if (tiankafeiCustomConditionDTO != null && tiankafeiCustomConditionDTO.getValue() != null) {
            tkfTextField.setText(tiankafeiCustomConditionDTO.getValue().toString());
        }
        conditionTkfPanel.updateUI();
    }

    /**
     * 对象字符串化
     *
     * @return 对象的字符串
     */
    @Override
    public abstract String toString();

    /**
     * 获取自定义过滤条件标识
     *
     * @return 自定义过滤条件标识
     */
    public String getCondition() {
        return condition;
    }

    /**
     * 设置自定义过滤条件标识
     *
     * @param condition 自定义过滤条件标识
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * 创建自定义过滤条件抽象对象
     *
     * @param condition 自定义过滤条件标识
     * @return 自定义过滤条件抽象对象
     */
    public static AbstractTiankafeiConditionDTO createAbstractTiankafeiConditionDTO(String condition) {
        AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = null;
        if (TiankafeiConditionConstants.TIANKAFEI_DEFAULT_CONDITION.equals(condition)) {
            //请选择
            abstractTiankafeiConditionDTO = new TiankafeiDefaultConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_SUBSTR_CONDITION.equals(condition)) {
            //截取
            abstractTiankafeiConditionDTO = new TiankafeiSubstrConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_LENGTH_CONDITION.equals(condition)) {
            //长度
            abstractTiankafeiConditionDTO = new TiankafeiLengthConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_EQUAL_CONDITION.equals(condition)) {
            //等于
            abstractTiankafeiConditionDTO = new TiankafeiEqualConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NO_EQUAL_CONDITION.equals(condition)) {
            //不等于
            abstractTiankafeiConditionDTO = new TiankafeiNoEqualConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_MORE_THAN_CONDITION.equals(condition)) {
            //大于
            abstractTiankafeiConditionDTO = new TiankafeiMoreThanConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_MORE_THAN_EQUAL_CONDITION.equals(condition)) {
            //大于等于
            abstractTiankafeiConditionDTO = new TiankafeiMoreThanEqualConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_LESS_THAN_CONDITION.equals(condition)) {
            //小于
            abstractTiankafeiConditionDTO = new TiankafeiLessThanConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_LESS_THAN_EQUAL_CONDITION.equals(condition)) {
            //小于等于
            abstractTiankafeiConditionDTO = new TiankafeiLessThanEqualConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_INTERVAL_CONDITION.equals(condition)) {
            //区间
            abstractTiankafeiConditionDTO = new TiankafeiIntervalConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_PREFIX_CONDITION.equals(condition)) {
            //前缀
            abstractTiankafeiConditionDTO = new TiankafeiPrefixConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_SUFFIX_CONDITION.equals(condition)) {
            //后缀
            abstractTiankafeiConditionDTO = new TiankafeiSuffixConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NO_PREFIX_CONDITION.equals(condition)) {
            //非前缀
            abstractTiankafeiConditionDTO = new TiankafeiNoPrefixConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NO_SUFFIX_CONDITION.equals(condition)) {
            //非后缀
            abstractTiankafeiConditionDTO = new TiankafeiNoSuffixConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NULL_CONDITION.equals(condition)) {
            //为空
            abstractTiankafeiConditionDTO = new TiankafeiNullConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NO_NULL_CONDITION.equals(condition)) {
            //非空
            abstractTiankafeiConditionDTO = new TiankafeiNoNullConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_LIST_CONDITION.equals(condition)) {
            //列表
            abstractTiankafeiConditionDTO = new TiankafeiListConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_NO_LIST_CONDITION.equals(condition)) {
            //非列表
            abstractTiankafeiConditionDTO = new TiankafeiNoListConditionDTO();
        }
        return abstractTiankafeiConditionDTO;
    }

    /**
     * 创建自定义过滤条件抽象对象
     *
     * @param tiankafeiConditionJsonObject 自定义过滤条件标识
     * @return 自定义过滤条件抽象对象
     */
    public static AbstractTiankafeiConditionDTO createAbstractTiankafeiConditionDTO(JSONObject tiankafeiConditionJsonObject) {
        AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = null;
        if (tiankafeiConditionJsonObject != null) {
            String condition = tiankafeiConditionJsonObject.getString("condition");
            if (TiankafeiConditionConstants.TIANKAFEI_DEFAULT_CONDITION.equals(condition)) {
                //请选择
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiDefaultConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_SUBSTR_CONDITION.equals(condition)) {
                //截取
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiSubstrConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_LENGTH_CONDITION.equals(condition)) {
                //长度
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiLengthConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_EQUAL_CONDITION.equals(condition)) {
                //等于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiEqualConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NO_EQUAL_CONDITION.equals(condition)) {
                //不等于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNoEqualConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_MORE_THAN_CONDITION.equals(condition)) {
                //大于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiMoreThanConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_MORE_THAN_EQUAL_CONDITION.equals(condition)) {
                //大于等于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiMoreThanEqualConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_LESS_THAN_CONDITION.equals(condition)) {
                //小于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiLessThanConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_LESS_THAN_EQUAL_CONDITION.equals(condition)) {
                //小于等于
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiLessThanEqualConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_INTERVAL_CONDITION.equals(condition)) {
                //区间
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiIntervalConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_PREFIX_CONDITION.equals(condition)) {
                //前缀
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiPrefixConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_SUFFIX_CONDITION.equals(condition)) {
                //后缀
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiSuffixConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NO_PREFIX_CONDITION.equals(condition)) {
                //非前缀
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNoPrefixConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NO_SUFFIX_CONDITION.equals(condition)) {
                //非后缀
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNoSuffixConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NULL_CONDITION.equals(condition)) {
                //为空
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNullConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NO_NULL_CONDITION.equals(condition)) {
                //非空
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNoNullConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_LIST_CONDITION.equals(condition)) {
                //列表
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiListConditionDTO.class);
            } else if (TiankafeiConditionConstants.TIANKAFEI_NO_LIST_CONDITION.equals(condition)) {
                //非列表
                abstractTiankafeiConditionDTO = JSON.toJavaObject(tiankafeiConditionJsonObject, TiankafeiNoListConditionDTO.class);
            }
        }
        return abstractTiankafeiConditionDTO;
    }

}
