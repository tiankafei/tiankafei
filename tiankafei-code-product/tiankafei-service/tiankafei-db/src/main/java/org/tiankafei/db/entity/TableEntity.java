package org.tiankafei.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigInteger;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tiankafei.web.common.entity.BaseEntity;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("information_schema.TABLES")
@ApiModel(value = "数据库表 实体对象", description = "数据库表 实体对象")
public class TableEntity extends BaseEntity {

    /**
     * 数据表登记目录
     */
    @TableField(value = "TABLE_CATALOG")
    @ApiModelProperty(value = "数据表登记目录")
    private String tableCatalog;

    /**
     * 数据表所属的数据库名
     */
    @TableField(value = "TABLE_SCHEMA")
    @ApiModelProperty(value = "数据表所属的数据库名")
    private String tableSchema;

    /**
     * 表名称
     */
    @TableField(value = "TABLE_NAME")
    @ApiModelProperty(value = "表名称")
    private String tableName;

    /**
     * 表类型[system view|base table]
     */
    @TableField(value = "TABLE_TYPE")
    @ApiModelProperty(value = "表类型[system view|base table]")
    private String tableType;

    /**
     * 使用的数据库引擎[MyISAM|CSV|InnoDB]
     */
    @TableField(value = "ENGINE")
    @ApiModelProperty(value = "使用的数据库引擎[MyISAM|CSV|InnoDB]")
    private String engineType;

    /**
     * 版本，默认值10
     */
    @TableField(value = "VERSION")
    @ApiModelProperty(value = "版本，默认值10")
    private String version;

    /**
     * 行格式[Compact|Dynamic|Fixed]
     */
    @TableField(value = "ROW_FORMAT")
    @ApiModelProperty(value = "行格式[Compact|Dynamic|Fixed]")
    private String rowFormat;

    /**
     * 表里所存多少行数据
     */
    @TableField(value = "TABLE_ROWS")
    @ApiModelProperty(value = "表里所存多少行数据")
    private BigInteger tableRows;

    /**
     * 平均行长度
     */
    @TableField(value = "AVG_ROW_LENGTH")
    @ApiModelProperty(value = "平均行长度")
    private BigInteger avgRowLength;

    /**
     * 数据长度
     */
    @TableField(value = "DATA_LENGTH")
    @ApiModelProperty(value = "数据长度")
    private BigInteger dataLength;

    /**
     * 最大数据长度
     */
    @TableField(value = "MAX_DATA_LENGTH")
    @ApiModelProperty(value = "最大数据长度")
    private BigInteger maxDataLength;

    /**
     * 索引长度
     */
    @TableField(value = "INDEX_LENGTH")
    @ApiModelProperty(value = "索引长度")
    private BigInteger indexLength;

    /**
     * 空间碎片
     */
    @TableField(value = "DATA_FREE")
    @ApiModelProperty(value = "空间碎片")
    private BigInteger dataFree;

    /**
     * 做自增主键的自动增量当前值
     */
    @TableField(value = "AUTO_INCREMENT")
    @ApiModelProperty(value = "做自增主键的自动增量当前值")
    private BigInteger autoIncrement;

    /**
     * 表的创建时间
     */
    @TableField(value = "CREATE_TIME")
    @ApiModelProperty(value = "表的创建时间")
    private Timestamp createTime;

    /**
     * 表的更新时间
     */
    @TableField(value = "UPDATE_TIME")
    @ApiModelProperty(value = "表的更新时间")
    private Timestamp updateTime;

    /**
     * 表的检查时间
     */
    @TableField(value = "CHECK_TIME")
    @ApiModelProperty(value = "表的检查时间")
    private Timestamp checkTime;

    /**
     * 表的字符校验编码集
     */
    @TableField(value = "TABLE_COLLATION")
    @ApiModelProperty(value = "表的字符校验编码集")
    private String tableCollationl;

    /**
     * 校验和
     */
    @TableField(value = "CHECKSUM")
    @ApiModelProperty(value = "校验和")
    private BigInteger checksum;

    /**
     * 创建选项
     */
    @TableField(value = "CREATE_OPTIONS")
    @ApiModelProperty(value = "创建选项")
    private String createOptions;

    /**
     * 表的注释、备注
     */
    @TableField(value = "TABLE_COMMENT")
    @ApiModelProperty(value = "表的注释、备注")
    private String comment;

}
