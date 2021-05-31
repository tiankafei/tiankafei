package org.tiankafei.rule.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统规则设计对象
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_rule_design")
@ApiModel(value = "RuleDesignEntity 对象", description = "系统规则设计对象")
public class RuleDesignEntity extends Model<RuleDesignEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "规则代码")
    @Size(max = 20, message = "规则代码长度不能超过 20 ！")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "规则名称")
    @Size(max = 100, message = "规则名称长度不能超过 100 ！")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "规则类型：1审核规则，2计算规则，3跳转规则")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "规则表达式")
    @TableField("expression")
    private String expression;

    @ApiModelProperty(value = "规则表达式生成的javascript的脚本")
    @TableField("javascript")
    private String javascript;

    @ApiModelProperty(value = "规则表达式生成的规则解析对象")
    @TableField("expression_dto")
    private String expressionDto;

    @ApiModelProperty(value = "错误规则表达式")
    @TableField("error_expression")
    private String errorExpression;

    @ApiModelProperty(value = "错误规则表达式生成的javascript的脚本")
    @TableField("error_javascript_list")
    private String errorJavascriptList;

    @ApiModelProperty(value = "错误规则表达式生成的规则解析对象集合")
    @TableField("error_expression_list")
    private String errorExpressionList;

    @ApiModelProperty(value = "目标表达式")
    @TableField("target_expression")
    private String targetExpression;

    @ApiModelProperty(value = "目标规则表达式生成的规则解析对象")
    @TableField("target_expression_dto")
    private String targetExpressionDto;

    @ApiModelProperty(value = "要锁的规则表达式")
    @TableField("lock_expression")
    private String lockExpression;

    @ApiModelProperty(value = "要锁的规则表达式生成的规则解析对象")
    @TableField("lock_expression_dto")
    private String lockExpressionDto;


    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String EXPRESSION = "expression";

    public static final String JAVASCRIPT = "javascript";

    public static final String EXPRESSION_DTO = "expression_dto";

    public static final String ERROR_EXPRESSION = "error_expression";

    public static final String ERROR_JAVASCRIPT_LIST = "error_javascript_list";

    public static final String ERROR_EXPRESSION_LIST = "error_expression_list";

    public static final String TARGET_EXPRESSION = "target_expression";

    public static final String TARGET_EXPRESSION_DTO = "target_expression_dto";

    public static final String LOCK_EXPRESSION = "lock_expression";

    public static final String LOCK_EXPRESSION_DTO = "lock_expression_dto";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
