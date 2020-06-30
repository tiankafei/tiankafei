package org.tiankafei.general.db.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 数据库表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-06-30
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "数据库表集合 查询参数对象", description = "数据库表集合 查询参数对象")
public class TableNameListQueryParam implements Serializable {

    /**
     * 表名称
     */
    @ApiModelProperty(value = "表名称")
    private String tableName;

    /**
     * 数据表所属的数据库名
     */
    @ApiModelProperty(value = "数据表所属的数据库名")
    private String tableSchema;

}
