package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 规则中用到的数据的别名 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则中用到的数据的别名 求记录数参数对象")
public class RuleDataAliasCountParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
