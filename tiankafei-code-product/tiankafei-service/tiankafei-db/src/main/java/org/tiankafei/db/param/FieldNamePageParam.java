package org.tiankafei.db.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.BaseQueryParam;

/**
 * <pre>
 * 数据库表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "数据库表的字段集合 分页查询参数对象", description = "数据库表的字段集合 分页查询参数对象")
public class FieldNamePageParam extends BaseQueryParam {

    /**
     * 表名称
     */
    @ApiModelProperty(value = "表名称")
    @NotBlank(message = "查询单个数据表字段时，表名不能为空！")
    private String tableName;

    /**
     * 数据表所属的数据库名
     */
    @ApiModelProperty(value = "数据表所属的数据库名")
    private String tableSchema;

    /**
     * 字段名
     */
    @ApiModelProperty(value = "字段名")
    private String fieldName;

}
