package org.tiankafei.rule.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 规则数据集的别名 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则数据集的别名 求记录数参数对象")
public class RuleDatasetAliasCountParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
