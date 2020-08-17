package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.BaseOrderQueryParam;

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
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统数据字典的数据表 分页列表参数对象")
public class DictTablePageParam extends BaseOrderQueryParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "逻辑删除字段：1已删除，0未删除")
    private Integer deleteMark = 0;

    @ApiModelProperty(value = "数据表名")
    @Size(max = 30, message = "数据表名长度不能超过 30 ！")
    @NotBlank(message = "数据表名不能为空！")
    private String dataTable;

}
