package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 规则设计执行的对象 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则设计执行的对象 列表参数对象")
public class RuleExecuteListParam implements Serializable {

    private static final long serialVersionUID = 1L;

@ApiModelProperty(value = "主键id集合")
    private List<Long> idList;

@ApiModelProperty(value = "逻辑删除字段：2已删除，0未删除")
    private Integer deleteMark;
}
