package org.tiankafei.user.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CatalogDto {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    private String code;

    @ApiModelProperty(value = "名称")
    @Size(max = 500, message = "名称长度不能超过 500 ！")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "所有父id，用逗号分隔")
    @Size(max = 2100, message = "所有父id，用逗号分隔长度不能超过 2100 ！")
    private String allParentId;

    @ApiModelProperty(value = "序号")
    private Integer serialNumber;

    @ApiModelProperty(value = "所在层级")
    private Integer level;

    private List<CatalogDto> sub;

}
