package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统数据字典表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统数据字典表 检查是否存在参数对象")
public class DictInfoCheckParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "字典代码")
    @Size(max = 20, message = "字典代码长度不能超过 20 ！")
    private String dictCode;

}
