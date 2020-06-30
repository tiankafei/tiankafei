package org.tiankafei.general.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.tiankafei.web.common.entity.BaseEntity;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@TableName("information_schema.COLUMNS")
public class FieldEntity extends BaseEntity {

    /**
     * 数据表登记目录
     */
    @TableField("TABLE_CATALOG")
    @ApiModelProperty(value = "数据表登记目录")
    private String tableCatalog;

    /**
     * 数据表所属的数据库名
     */
    @TableField("TABLE_SCHEMA")
    @ApiModelProperty(value = "数据表所属的数据库名")
    private String tableSchema;

    /**
     * 表名称
     */
    @TableField("TABLE_NAME")
    @ApiModelProperty(value = "表名称")
    private String tableName;

    /**
     * 字段名称
     */
    @TableField("COLUMN_NAME")
    @ApiModelProperty(value = "字段名称")
    private String fieldName;


}
