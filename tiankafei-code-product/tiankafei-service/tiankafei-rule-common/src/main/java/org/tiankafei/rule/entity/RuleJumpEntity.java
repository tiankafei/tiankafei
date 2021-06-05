package org.tiankafei.rule.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 跳转规则记录的数据唯一标识
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_rule_jump")
@ApiModel(value = "RuleJumpEntity 对象", description = "跳转规则记录的数据唯一标识")
public class RuleJumpEntity extends Model<RuleJumpEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规则id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "数据集的唯一标识")
    @Size(max = 64, message = "数据集的唯一标识长度不能超过 64 ！")
    @TableField("dataset_unique_identifier")
    private String datasetUniqueIdentifier;

    @ApiModelProperty(value = "数据唯一标识")
    @Size(max = 64, message = "数据唯一标识长度不能超过 64 ！")
    @TableField("data_unique_identifier")
    private String dataUniqueIdentifier;

    @ApiModelProperty(value = "规则的执行id")
    @TableField("rule_execute_id")
    private Long ruleExecuteId;

    @ApiModelProperty(value = "报告期")
    @TableField("reporting_period")
    private String reportingPeriod;

    @ApiModelProperty(value = "数据唯一标识类型：1目标表达式中的，2要锁的表达式中的")
    @Size(max = 1, message = "数据唯一标识类型：1目标表达式中的，2要锁的表达式中的长度不能超过 1 ！")
    @TableField("data_unique_identifier_type")
    private String dataUniqueIdentifierType;

    @ApiModelProperty(value = "是否需要清空格子的值：true清空，false不清空")
    @TableField("clear_flag")
    private Boolean clearFlag;

    @ApiModelProperty(value = "数据唯一标识的别名")
    @Size(max = 30, message = "数据唯一标识的别名长度不能超过 30 ！")
    @TableField("alias_name")
    private String aliasName;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
    @TableLogic
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;


    public static final String ID = "id";

    public static final String DATASET_UNIQUE_IDENTIFIER = "dataset_unique_identifier";

    public static final String DATA_UNIQUE_IDENTIFIER = "data_unique_identifier";

    public static final String RULE_EXECUTE_ID = "rule_execute_id";

    public static final String REPORTING_PERIOD = "reporting_period";

    public static final String DATA_UNIQUE_IDENTIFIER_TYPE = "data_unique_identifier_type";

    public static final String CLEAR_FLAG = "clear_flag";

    public static final String ALIAS_NAME = "alias_name";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
