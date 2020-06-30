package org.tiankafei.general.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.tiankafei.web.common.entity.BaseEntity;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@TableName("information_schema.TABLES")
@ApiModel(value = "数据库表 实体对象" , description = "数据库表 实体对象")
public class TableEntity extends BaseEntity {

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
     * 表类型[system view|base table]
     */
    @TableField("TABLE_TYPE")
    @ApiModelProperty(value = "表类型[system view|base table]")
    private String tableType;

    /**
     * 使用的数据库引擎[MyISAM|CSV|InnoDB]
     */
    @TableField("ENGINE")
    @ApiModelProperty(value = "使用的数据库引擎[MyISAM|CSV|InnoDB]")
    private String engineType;

    /**
     * 版本，默认值10
     */
    @TableField("VERSION")
    @ApiModelProperty(value = "版本，默认值10")
    private String version;

    /**
     * 表里所存多少行数据
     */
    @TableField("TABLE_ROWS")
    @ApiModelProperty(value = "表里所存多少行数据")
    private BigInteger tableRows;

    /**
     * 平均行长度
     */
    @TableField("AVG_ROW_LENGTH")
    @ApiModelProperty(value = "平均行长度")
    private Integer avgRowLength;

    /**
     * 数据长度
     */
    @TableField("DATA_LENGTH")
    @ApiModelProperty(value = "数据长度")
    private Integer dataLength;

    /**
     * 最大数据长度
     */
    @TableField("MAX_DATA_LENGTH")
    @ApiModelProperty(value = "最大数据长度")
    private Integer maxDataLength;

    /**
     * 索引长度
     */
    @TableField("INDEX_LENGTH")
    @ApiModelProperty(value = "索引长度")
    private Integer indexLength;

    /**
     * 做自增主键的自动增量当前值
     */
    @TableField("AUTO_INCREMENT")
    @ApiModelProperty(value = "做自增主键的自动增量当前值")
    private BigInteger autoIncrement;

    /**
     * 表的创建时间
     */
    @TableField("CREATE_TIME")
    @ApiModelProperty(value = "表的创建时间")
    private Timestamp createTime;

    /**
     * 表的更新时间
     */
    @TableField("UPDATE_TIME")
    @ApiModelProperty(value = "表的更新时间")
    private Timestamp updateTime;

    /**
     * 表的字符校验编码集
     */
    @TableField("TABLE_COLLATION")
    @ApiModelProperty(value = "表的字符校验编码集")
    private String tableCollationl;

    /**
     * 表的注释、备注
     */
    @TableField("TABLE_COMMENT")
    @ApiModelProperty(value = "表的注释、备注")
    private String comment;

}
