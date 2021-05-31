package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统规则设计对象 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统规则设计对象 求记录数参数对象")
public class RuleDesignCountParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
