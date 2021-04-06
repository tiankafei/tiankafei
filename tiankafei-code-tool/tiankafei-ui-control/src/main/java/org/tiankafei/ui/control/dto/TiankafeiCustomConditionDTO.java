package org.tiankafei.ui.control.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;

/**
 * 自定义条件对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
public class TiankafeiCustomConditionDTO implements Serializable {

    private static final long serialVersionUID = 6273312937953688311L;

    /**
     * 字段对象
     */
    private ConditionColumnDTO conditionColumnDTO;

    /**
     * 字段对象索引位置
     */
    private Integer tableColumnValueIndex;

    /**
     * 自定义过滤条件抽象对象
     */
    private AbstractTiankafeiConditionDTO tiankafeiConditionDTO;

    /**
     * 自定义过滤条件抽象对象索引位置
     */
    private Integer tiankafeiConditionIndex;

    /**
     * 截取时使用(开始位置)
     */
    private Integer beginIndex;

    /**
     * 截取时使用(一共截几位)
     */
    private Integer numberIndex;

    /**
     * 截取后的自定义过滤条件抽象对象
     */
    private AbstractTiankafeiConditionDTO interceptionTiankafeiConditionDTO;

    /**
     * 截取后的自定义过滤条件抽象对象索引位置
     */
    private Integer interceptionTiankafeiConditionIndex;

    /**
     * 区间使用(开始值)
     */
    private Object beginValue;

    /**
     * 区间使用(结束值)
     */
    private Object endValue;

    /**
     * 值
     */
    private Object value;

    /**
     * SQL参数对象
     */
    private SqlParamDTO sqlParamDTO;

    /**
     * 是否可编辑条件的标识
     */
    private Boolean editableFlag;

    /**
     * 构造自定义条件对象
     */
    public TiankafeiCustomConditionDTO() {
        beginIndex = -1;
        numberIndex = -1;
        editableFlag = true;
        tableColumnValueIndex = -1;
        tiankafeiConditionIndex = -1;
        interceptionTiankafeiConditionIndex = -1;

    }

}
