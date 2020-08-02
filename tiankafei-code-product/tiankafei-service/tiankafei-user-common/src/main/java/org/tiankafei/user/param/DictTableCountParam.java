package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@ApiModel(value = "系统数据字典的数据表 求记录数参数对象")
public class DictTableCountParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据表名")
    @Size(max = 30, message = "数据表名长度不能超过 30 ！")
    @NotBlank(message = "数据表名不能为空！")
    private String dataTable;

}
