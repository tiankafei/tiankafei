package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统数据字典的数据表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统数据字典的数据表 检查是否存在参数对象")
public class DictTableCheckParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统字典id")
    @NotNull(message = "系统字典id不能为空！")
    private Long dictId;

    @ApiModelProperty(value = "代码")
    @NotBlank(message = "代码不能为空！")
    private String code;

    @ApiModelProperty(value = "代码的唯一标识")
    private Long id;

}
