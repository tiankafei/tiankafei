package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 跳转规则记录的数据唯一标识 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "跳转规则记录的数据唯一标识 求记录数参数对象")
public class RuleJumpCountParam implements Serializable {

    private static final long serialVersionUID = 1L;



}
