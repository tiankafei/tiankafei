package org.tiankafei.rule.vo;

import java.sql.Timestamp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
  @ApiModel(value="RuleJumpEntity对象", description="跳转规则记录的数据唯一标识")
public class RuleJumpVo extends BaseQueryVo {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "规则id")
      private Long id;

      @ApiModelProperty(value = "数据集的唯一标识符")
      @Size(max = 64, message = "数据集的唯一标识符长度不能超过 64 ！")
    private String datasetUniqueIdentifier;

      @ApiModelProperty(value = "数据的唯一标识符")
      @Size(max = 64, message = "数据的唯一标识符长度不能超过 64 ！")
    private String dataUniqueIdentifier;

      @ApiModelProperty(value = "规则的执行id")
      private Long ruleExecuteId;

      @ApiModelProperty(value = "报告期")
      private String reportingPeriod;

      @ApiModelProperty(value = "数据的唯一标识符类型：1表达式中的数据，2要锁的表达式中的数据")
      @Size(max = 1, message = "数据的唯一标识符类型：1表达式中的数据，2要锁的表达式中的数据长度不能超过 1 ！")
    private String dataUniqueIdentifierType;

      @ApiModelProperty(value = "是否需要清空格子的值：true清空，false不清空")
      private Boolean clearFlag;

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

  
}
