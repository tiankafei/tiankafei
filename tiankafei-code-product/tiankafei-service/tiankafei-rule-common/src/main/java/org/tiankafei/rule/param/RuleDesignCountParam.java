package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 规则设计表达式用户新增的对象 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则设计表达式用户新增的对象 求记录数参数对象")
public class RuleDesignCountParam implements Serializable {

    private static final long serialVersionUID = 1L;



}
