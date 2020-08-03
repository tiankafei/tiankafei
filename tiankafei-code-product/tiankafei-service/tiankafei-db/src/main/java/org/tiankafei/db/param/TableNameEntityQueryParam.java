package org.tiankafei.db.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 数据库表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "数据库表 查询参数对象", description = "数据库表 查询参数对象")
public class TableNameEntityQueryParam implements Serializable {

    /**
     * 表名称
     */
    @ApiModelProperty(value = "表名称")
    @NotBlank(message = "查询单个数据表时，表名称不能为空！")
    private String tableName;

    /**
     * 数据表所属的数据库名
     */
    @ApiModelProperty(value = "数据表所属的数据库名")
    private String tableSchema;

}