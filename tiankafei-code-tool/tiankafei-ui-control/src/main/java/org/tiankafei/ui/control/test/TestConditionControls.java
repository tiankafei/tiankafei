package org.tiankafei.ui.control.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.ui.control.TiankafeiConditionControls;
import org.tiankafei.ui.control.dto.ConditionColumnDTO;
import org.tiankafei.ui.control.dto.TiankafeiAssembleConditionDTO;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * @Author 魏双双
 * @Date 2019/12/9
 * @Version V1.0
 **/
public class TestConditionControls {

    public static void main(String[] args) {
        TiankafeiFrame tiankafeiFrame = new TiankafeiFrame();
        tiankafeiFrame.setWidth(900);
        tiankafeiFrame.setHeight(700);
        tiankafeiFrame.setTitle("系统");
        tiankafeiFrame.initTiankafeiFrame();

        TiankafeiConditionControls tiankafeiConditionControls = new TiankafeiConditionControls();

        ConditionColumnDTO conditionColumnDTO = new ConditionColumnDTO();
        conditionColumnDTO.setTableName("sys_user");
        conditionColumnDTO.setColumnChineseName("指标");
        tiankafeiConditionControls.getTiankafeiConditionDTO().getColumnList().add(conditionColumnDTO);

        String str = "{\"abstractTiankafeiHandleConditionDTO\":{\"handleType\":\"AND\"},\"abstractTiankafeiHandleConditionIndex\":0,\"sqlParamDTO\":{\"paramList\":[\"12\"],\"sql\":\" sys_user.null <> ? \"},\"tiankafeiAssembleConditionList\":[{\"abstractTiankafeiHandleConditionDTO\":{\"handleType\":\"AND\"},\"abstractTiankafeiHandleConditionIndex\":0,\"sqlParamDTO\":{},\"tiankafeiAssembleConditionList\":[],\"tiankafeiCustomConditionList\":[{\"beginIndex\":-1,\"conditionColumnDTO\":{\"columnChineseName\":\"指标\",\"columnDataPrecision\":0,\"dbName\":\"master\",\"nullFlag\":true,\"primaryKeyFlag\":false,\"tableName\":\"sys_user\"},\"editableFlag\":true,\"interceptionTiankafeiConditionIndex\":-1,\"numberIndex\":-1,\"sqlParamDTO\":{\"paramList\":[\"12\"],\"sql\":\" sys_user.null <> ? \"},\"tableColumnValueIndex\":0,\"tiankafeiConditionDTO\":{\"condition\":\"TIANKAFEI_NO_EQUAL_CONDITION\"},\"tiankafeiConditionIndex\":4,\"value\":\"12\"}]}],\"tiankafeiCustomConditionList\":[{\"beginIndex\":-1,\"conditionColumnDTO\":{\"columnChineseName\":\"指标\",\"columnDataPrecision\":0,\"dbName\":\"master\",\"nullFlag\":true,\"primaryKeyFlag\":false,\"tableName\":\"sys_user\"},\"editableFlag\":true,\"interceptionTiankafeiConditionIndex\":-1,\"numberIndex\":-1,\"sqlParamDTO\":{\"paramList\":[\"12\"],\"sql\":\" LENGTH(sys_user.null) = ? \"},\"tableColumnValueIndex\":0,\"tiankafeiConditionDTO\":{\"condition\":\"TIANKAFEI_LENGTH_CONDITION\"},\"tiankafeiConditionIndex\":2,\"value\":\"12\"},{\"beginIndex\":-1,\"conditionColumnDTO\":{\"columnChineseName\":\"指标\",\"columnDataPrecision\":0,\"dbName\":\"master\",\"nullFlag\":true,\"primaryKeyFlag\":false,\"tableName\":\"sys_user\"},\"editableFlag\":true,\"interceptionTiankafeiConditionIndex\":-1,\"numberIndex\":-1,\"sqlParamDTO\":{\"paramList\":[\"122\"],\"sql\":\" sys_user.null = ? \"},\"tableColumnValueIndex\":0,\"tiankafeiConditionDTO\":{\"condition\":\"TIANKAFEI_EQUAL_CONDITION\"},\"tiankafeiConditionIndex\":3,\"value\":\"122\"}]}";
        TiankafeiAssembleConditionDTO tiankafeiAssembleConditionDTO = null;
        if (StringUtils.isNotEmpty(str)) {
            tiankafeiAssembleConditionDTO = JSON.parseObject(str, TiankafeiAssembleConditionDTO.class);
        }
        TkfPanel tkfPanel = tiankafeiConditionControls.initTiankafeiConditionPanle(600, tiankafeiAssembleConditionDTO);
        tiankafeiFrame.getContentTkfPanel().add(tkfPanel);

        tiankafeiFrame.setVisible(true);
    }

}
