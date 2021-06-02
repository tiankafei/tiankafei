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
 * 规则设计表达式用户新增的对象
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
  @ApiModel(value="RuleDesignEntity对象", description="规则设计表达式用户新增的对象")
public class RuleDesignVo extends BaseQueryVo {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "规则id")
      private Long id;

      @ApiModelProperty(value = "数据集的唯一标识符")
      @Size(max = 64, message = "数据集的唯一标识符长度不能超过 64 ！")
    private String datasetUniqueIdentifier;

      @ApiModelProperty(value = "规则代码")
      @Size(max = 20, message = "规则代码长度不能超过 20 ！")
    private String code;

      @ApiModelProperty(value = "规则名称")
      @Size(max = 100, message = "规则名称长度不能超过 100 ！")
    private String name;

      @ApiModelProperty(value = "规则类型：1审核规则，2计算规则，3跳转规则")
      private Integer type;

      @ApiModelProperty(value = "状态：0停用，1启用")
      private Boolean status;

      @ApiModelProperty(value = "是否支持离线审核")
      private Boolean offline;

      @ApiModelProperty(value = "规则表达式")
      private String expression;

      @ApiModelProperty(value = "编译不通过时的错误提示消息")
      private String compileErrorMessage;

      @ApiModelProperty(value = "错误规则表达式")
      private String errorExpression;

      @ApiModelProperty(value = "错误表达式编译不通过时的错误提示消息")
      private String errorCompileErrorMessage;

      @ApiModelProperty(value = "目标表达式")
      private String targetExpression;

      @ApiModelProperty(value = "要锁的规则表达式")
      private String lockExpression;

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

      @ApiModelProperty(value = "租户ID")
      private Long tenantId;


      public static final String ID = "id";

      public static final String DATASET_UNIQUE_IDENTIFIER = "dataset_unique_identifier";

      public static final String CODE = "code";

      public static final String NAME = "name";

      public static final String TYPE = "type";

      public static final String STATUS = "status";

      public static final String OFFLINE = "offline";

      public static final String EXPRESSION = "expression";

      public static final String COMPILE_ERROR_MESSAGE = "compile_error_message";

      public static final String ERROR_EXPRESSION = "error_expression";

      public static final String ERROR_COMPILE_ERROR_MESSAGE = "error_compile_error_message";

      public static final String TARGET_EXPRESSION = "target_expression";

      public static final String LOCK_EXPRESSION = "lock_expression";

      public static final String VERSION = "version";

      public static final String DELETE_MARK = "delete_mark";

      public static final String CREATE_TIME = "create_time";

      public static final String UPDATE_TIME = "update_time";

      public static final String CREATE_USER_ID = "create_user_id";

      public static final String UPDATE_USER_ID = "update_user_id";

      public static final String TENANT_ID = "tenant_id";

  
}
