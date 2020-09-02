package org.tiankafei.ui.design.dto;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.base.dto.CodeNameDTO;
import org.tiankafei.base.enums.DataTypeEnum;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;

/**
 * 自定义表格列对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
public class TableColumnDTO implements Serializable {

    private static final long serialVersionUID = -3937870882340172165L;

    /**
     * 表格列选择序号列
     */
    private Boolean numberFlag;

    /**
     * 表格列单选状态列上一次选的行
     */
    private Integer radioStatusPreviousRow;

    /**
     * 表格列头部标题
     */
    private String header;

    /**
     * 表格列标识
     */
    private String mark;

    /**
     * 表格列是否隐藏
     */
    private Boolean hiddenFlag;

    /**
     * 表格列数据类型
     */
    private Integer dataType;

    /**
     * 表格列最大宽度
     */
    private Integer maxWidth;

    /**
     * 表格列宽
     */
    private Integer width;

    /**
     * 表格列最小宽度
     */
    private Integer minWidth;

    /**
     * 表格列是否被禁用标识
     */
    private Boolean editableFlag;

    /**
     * 表格列控件类型
     */
    private Integer controlsType;

    /**
     * 表格列值
     */
    private Object value;

    /**
     * 代码名称值对象集合
     */
    private List<CodeNameDTO> codeNameList;

    /**
     * 构造自定义表格列对象
     */
    public TableColumnDTO() {
        numberFlag = false;
        radioStatusPreviousRow = -1;

        hiddenFlag = false;
        dataType = DataTypeEnum.DATA_TYPE_STRING.getCode();

        width = 200;
        minWidth = 20;
        editableFlag = true;
        controlsType = TiankafeiDesignerConstants.CHOOSE_TYPE_NO;

        codeNameList = Lists.newArrayList();
    }

    /**
     * 设置表格列选择序号列
     *
     * @param numberFlag 表格列选择序号列
     */
    public void setTableColumnNumberFlag(boolean numberFlag) {
        if (numberFlag) {
            //设置选择序号列时，该列将被禁用
            editableFlag = false;
        }
        this.numberFlag = numberFlag;
    }

    /**
     * 设置表格列控件类型
     *
     * @param controlsType 表格列控件类型
     */
    public void setTableColumnControlsType(int controlsType) {
        if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == controlsType || TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == controlsType) {
            //控件类型为单选或复选时，该列将被禁用，并设置默认列宽
            editableFlag = false;
            width = 40;
        }
        this.controlsType = controlsType;
    }

}
