package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <pre>
 * 系统数据字典表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统数据字典表 查询参数对象", description = "系统数据字典表查询参数")
public class SysDictInfoQueryParam implements Serializable {

    /**
     * 字典代码
     */
    @ApiModelProperty(value = "字典代码")
    @Size(max = 20, message = "字典代码长度不能超过 20 ！")
    @NotBlank(message = "字典代码不能为空")
    private String dictCode;

}
