package org.tiankafei.ui.control.dto;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiHandleConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiAndHandleConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiOrHandleConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;

/**
 * 自定义过滤条件属性对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
public class TiankafeiConditionDTO implements Serializable {

    private static final long serialVersionUID = -4073790805671982975L;

    /**
     * 自定义条件按钮显示标识
     */
    private Boolean conditionButtonFlag;

    /**
     * 缩进的宽度
     */
    private Integer indentationWidth;

    /**
     * 控件面板高度
     */
    private Integer controlsPanelHeight;

    /**
     * 字段列表集合
     */
    private List<ConditionColumnDTO> columnList;

    /**
     * 自定义过滤条件集合
     */
    private List<AbstractTiankafeiConditionDTO> tiankafeiConditionList;

    /**
     * 自定义过滤条件操作抽象对象集合
     */
    private List<AbstractTiankafeiHandleConditionDTO> tiankafeiHandleConditionList;

    /**
     * 构造自定义过滤条件属性对象
     */
    public TiankafeiConditionDTO() {
        conditionButtonFlag = true;
        indentationWidth = 30;
        controlsPanelHeight = 36;
        columnList = Lists.newArrayList();

        tiankafeiConditionList = TiankafeiConditionConstants.getTiankafeiConditionList();

        tiankafeiHandleConditionList = Lists.newArrayList();
        tiankafeiHandleConditionList.add(new TiankafeiAndHandleConditionDTO());
        tiankafeiHandleConditionList.add(new TiankafeiOrHandleConditionDTO());
    }

}
