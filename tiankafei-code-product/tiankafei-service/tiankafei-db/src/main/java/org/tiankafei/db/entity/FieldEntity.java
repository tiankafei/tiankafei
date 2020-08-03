package org.tiankafei.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigInteger;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tiankafei.web.common.entity.BaseEntity;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("information_schema.COLUMNS")
public class FieldEntity extends BaseEntity {

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
     * 字段名称
     */
    @TableField(value = "COLUMN_NAME")
    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    /**
     * 字段标识，其实就是字段编号，从1开始往后排。
     */
    @TableField(value = "ORDINAL_POSITION")
    @ApiModelProperty(value = "字段标识，其实就是字段编号，从1开始往后排。")
    private Integer ordinalPosition;

    /**
     * 列的默认值
     */
    @TableField(value = "COLUMN_DEFAULT")
    @ApiModelProperty(value = "列的默认值")
    private String columnDefault;

    /**
     * 字段是否可以是NULL，该列记录的值是YES或者NO。
     */
    @TableField(value = "IS_NULLABLE")
    @ApiModelProperty(value = "字段是否可以是NULL，该列记录的值是YES或者NO。")
    private String isNullable;

    /**
     * 数据类型，里面的值是字符串，比如varchar，float，int
     */
    @TableField(value = "DATA_TYPE")
    @ApiModelProperty(value = "数据类型，里面的值是字符串，比如varchar，float，int")
    private String dataType;

    /**
     * 字段的最大字符数。假如字段设置为varchar(50)，那么这一列记录的值就是50。该列只适用于二进制数据，字符，文本，图像数据。其他类型数据比如int，float，datetime等，在该列显示为NULL。
     */
    @TableField(value = "CHARACTER_MAXIMUM_LENGTH")
    @ApiModelProperty(value = "字段的最大字符数。假如字段设置为varchar(50)，那么这一列记录的值就是50。该列只适用于二进制数据，字符，文本，图像数据。其他类型数据比如int，float，datetime等，在该列显示为NULL。")
    private BigInteger characterMaximumLength;

    /**
     * 字段的最大字节数。和最大字符数一样，只适用于二进制数据，字符，文本，图像数据，其他类型显示为NULL。和最大字符数的数值有比例关系，和字符集有关。比如UTF8类型的表，最大字节数就是最大字符数的3倍
     */
    @TableField(value = "CHARACTER_OCTET_LENGTH")
    @ApiModelProperty(value = "字段的最大字节数。和最大字符数一样，只适用于二进制数据，字符，文本，图像数据，其他类型显示为NULL。和最大字符数的数值有比例关系，和字符集有关。比如UTF8类型的表，最大字节数就是最大字符数的3倍")
    private BigInteger characterOctetLength;

    /**
     * 数字精度。适用于各种数字类型比如int，float之类的。如果字段设置为int(10)，那么在该列保存的数值是9，少一位，还没有研究原因。如果字段设置为float(10,3)，那么在该列报错的数值是10。非数字类型显示为在该列NULL。
     */
    @TableField(value = "NUMERIC_PRECISION")
    @ApiModelProperty(value = "数字精度。适用于各种数字类型比如int，float之类的。如果字段设置为int(10)，那么在该列保存的数值是9，少一位，还没有研究原因。如果字段设置为float(10,3)，那么在该列报错的数值是10。非数字类型显示为在该列NULL。")
    private BigInteger numericPrecision;

    /**
     * 小数位数。和数字精度一样，适用于各种数字类型比如int，float之类。如果字段设置为int(10)，那么在该列保存的数值是0，代表没有小数。如果字段设置为float(10,3)，那么在该列报错的数值是3。非数字类型显示为在该列NULL。
     */
    @TableField(value = "NUMERIC_SCALE")
    @ApiModelProperty(value = "小数位数。和数字精度一样，适用于各种数字类型比如int，float之类。如果字段设置为int(10)，那么在该列保存的数值是0，代表没有小数。如果字段设置为float(10,3)，那么在该列报错的数值是3。非数字类型显示为在该列NULL。")
    private BigInteger numericScale;

    /**
     * datetime类型和SQL-92interval类型数据库的子类型代码。我本地datetime类型的字段在该列显示为0。其他类型显示为NULL。
     */
    @TableField(value = "DATETIME_PRECISION")
    @ApiModelProperty(value = "datetime类型和SQL-92interval类型数据库的子类型代码。我本地datetime类型的字段在该列显示为0。其他类型显示为NULL。")
    private Integer datetimePrecision;

    /**
     * 字段字符集名称。比如utf8。
     */
    @TableField(value = "CHARACTER_SET_NAME")
    @ApiModelProperty(value = "字段字符集名称。比如utf8。")
    private String characterSetName;

    /**
     * 字符集排序规则。比如utf8_general_ci，是不区分大小写一种排序规则。utf8_general_cs，是区分大小写的排序规则。
     */
    @TableField(value = "COLLATION_NAME")
    @ApiModelProperty(value = "字符集排序规则。比如utf8_general_ci，是不区分大小写一种排序规则。utf8_general_cs，是区分大小写的排序规则。")
    private String collationName;

    /**
     * 字段类型。比如float(9,3)，varchar(50)。
     */
    @TableField(value = "COLUMN_TYPE")
    @ApiModelProperty(value = "字段类型。比如float(9,3)，varchar(50)。")
    private String columnType;

    /**
     * 索引类型。可包含的值有PRI，代表主键，UNI，代表唯一键，MUL，可重复。
     */
    @TableField(value = "COLUMN_KEY")
    @ApiModelProperty(value = "索引类型。可包含的值有PRI，代表主键，UNI，代表唯一键，MUL，可重复。")
    private String columnKey;

    /**
     * 其他信息。比如主键的auto_increment。
     */
    @TableField(value = "EXTRA")
    @ApiModelProperty(value = "其他信息。比如主键的auto_increment。")
    private String extra;

    /**
     * 权限，多个权限用逗号隔开，比如 select,insert,update,references
     */
    @TableField(value = "PRIVILEGES")
    @ApiModelProperty(value = "权限，多个权限用逗号隔开，比如 select,insert,update,references")
    private String privileges;

    /**
     * 字段注释
     */
    @TableField(value = "COLUMN_COMMENT")
    @ApiModelProperty(value = "字段注释")
    private String columnComment;

    /**
     * 组合字段的公式。
     */
    @TableField(value = "GENERATION_EXPRESSION")
    @ApiModelProperty(value = "组合字段的公式。")
    private String generationExpression;

    /**
     * srsId
     */
    @TableField(value = "SRS_ID")
    @ApiModelProperty(value = "srsId")
    private Integer srsId;

}
