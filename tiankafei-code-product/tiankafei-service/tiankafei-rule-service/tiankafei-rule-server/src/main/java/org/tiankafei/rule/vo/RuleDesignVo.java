package org.tiankafei.rule.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
@ApiModel(value = "RuleDesignEntity对象", description = "系统规则设计对象")
public class RuleDesignVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "规则代码")
    @Size(max = 20, message = "规则代码长度不能超过 20 ！")
    private String code;

    @ApiModelProperty(value = "规则名称")
    @Size(max = 100, message = "规则名称长度不能超过 100 ！")
    private String name;

    @ApiModelProperty(value = "规则类型：1审核规则，2计算规则，3跳转规则")
    private Integer type;

    @ApiModelProperty(value = "规则表达式")
    private String expression;

    @ApiModelProperty(value = "规则表达式生成的javascript的脚本")
    private String javascript;

    @ApiModelProperty(value = "规则表达式生成的规则解析对象")
    private String expressionDto;

    @ApiModelProperty(value = "编译不通过时的错误提示消息")
    private String compileErrorMessage;

    @ApiModelProperty(value = "错误规则表达式")
    private String errorExpression;

    @ApiModelProperty(value = "错误规则表达式生成的javascript的脚本")
    private String errorJavascriptList;

    @ApiModelProperty(value = "错误规则表达式生成的规则解析对象集合")
    private String errorExpressionList;

    @ApiModelProperty(value = "错误表达式编译不通过时的错误提示消息")
    private String errorCompileErrorMessage;

    @ApiModelProperty(value = "目标表达式")
    private String targetExpression;

    @ApiModelProperty(value = "目标规则表达式生成的规则解析对象")
    private String targetExpressionDto;

    @ApiModelProperty(value = "要锁的规则表达式")
    private String lockExpression;

    @ApiModelProperty(value = "要锁的规则表达式生成的规则解析对象")
    private String lockExpressionDto;


    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String EXPRESSION = "expression";

    public static final String JAVASCRIPT = "javascript";

    public static final String EXPRESSION_DTO = "expression_dto";

    public static final String COMPILE_ERROR_MESSAGE = "compile_error_message";

    public static final String ERROR_EXPRESSION = "error_expression";

    public static final String ERROR_JAVASCRIPT_LIST = "error_javascript_list";

    public static final String ERROR_EXPRESSION_LIST = "error_expression_list";

    public static final String ERROR_COMPILE_ERROR_MESSAGE = "error_compile_error_message";

    public static final String TARGET_EXPRESSION = "target_expression";

    public static final String TARGET_EXPRESSION_DTO = "target_expression_dto";

    public static final String LOCK_EXPRESSION = "lock_expression";

    public static final String LOCK_EXPRESSION_DTO = "lock_expression_dto";


}
