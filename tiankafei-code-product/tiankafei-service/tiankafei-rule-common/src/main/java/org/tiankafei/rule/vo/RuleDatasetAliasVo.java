package org.tiankafei.rule.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
@ApiModel(value = "RuleDatasetAliasEntity对象", description = "规则数据集的别名")
public class RuleDatasetAliasVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规则id")
    private Long id;

    @ApiModelProperty(value = "当前数据集的唯一标识符")
    @Size(max = 64, message = "当前数据集的唯一标识符长度不能超过 64 ！")
    private String curDatasetUniqueIdentifier;

    @ApiModelProperty(value = "要跨的数据集的唯一标识符")
    @Size(max = 64, message = "要跨的数据集的唯一标识符长度不能超过 64 ！")
    private String stepDatasetUniqueIdentifier;

    @ApiModelProperty(value = "数据的别名")
    @Size(max = 30, message = "数据的别名长度不能超过 30 ！")
    private String aliasName;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
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


}
