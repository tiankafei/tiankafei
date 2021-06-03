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
 * 规则数据集的别名
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_rule_dataset_alias")
@ApiModel(value = "RuleDatasetAliasEntity 对象", description = "规则数据集的别名")
public class RuleDatasetAliasEntity extends Model<RuleDatasetAliasEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规则id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "当前数据集的唯一标识符")
    @Size(max = 64, message = "当前数据集的唯一标识符长度不能超过 64 ！")
    @TableField("cur_dataset_unique_identifier")
    private String curDatasetUniqueIdentifier;

    @ApiModelProperty(value = "要跨的数据集的唯一标识符")
    @Size(max = 64, message = "要跨的数据集的唯一标识符长度不能超过 64 ！")
    @TableField("step_dataset_unique_identifier")
    private String stepDatasetUniqueIdentifier;

    @ApiModelProperty(value = "数据的别名")
    @Size(max = 30, message = "数据的别名长度不能超过 30 ！")
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

    public static final String CUR_DATASET_UNIQUE_IDENTIFIER = "cur_dataset_unique_identifier";

    public static final String STEP_DATASET_UNIQUE_IDENTIFIER = "step_dataset_unique_identifier";

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