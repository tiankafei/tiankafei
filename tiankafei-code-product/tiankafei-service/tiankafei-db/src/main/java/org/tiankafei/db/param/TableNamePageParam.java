package org.tiankafei.db.param;

import com.ruoyi.common.core.web.domain.SearchEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "数据库表集合 分页查询参数对象", description = "数据库表集合 分页查询参数对象")
public class TableNamePageParam extends SearchEntity {

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
