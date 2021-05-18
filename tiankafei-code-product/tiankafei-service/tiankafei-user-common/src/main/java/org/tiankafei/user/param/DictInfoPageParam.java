package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.BaseOrderQueryParam;

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
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统数据字典表 分页列表参数对象")
public class DictInfoPageParam extends BaseOrderQueryParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "逻辑删除字段：2已删除，0未删除")
    private Integer deleteMark;

    @ApiModelProperty(value = "系统数据字典代码")
    private String code;

    @ApiModelProperty(value = "系统数据字典名称")
    private String name;

    @ApiModelProperty(value = "系统数据字典状态")
    private Boolean status;

    @Size(max = 1, message = "用途类型：1系统用，2业务使用 长度不能超过1！")
    @ApiModelProperty(value = "用途类型：1系统用，2业务使用")
    private String useType = "1";

}
