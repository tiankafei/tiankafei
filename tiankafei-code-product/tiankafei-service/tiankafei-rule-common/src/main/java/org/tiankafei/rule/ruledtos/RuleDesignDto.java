package org.tiankafei.rule.ruledtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 规则设计对象
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则设计 对象", description = "规则设计 对象")
public class RuleDesignDto {

    @ApiModelProperty(value = "规则代码")
    private String code;

    @ApiModelProperty(value = "规则名称")
    private String name;

    @ApiModelProperty(value = "规则类型：1审核规则，2计算规则，3跳转规则")
    private String type;

    @ApiModelProperty(value = "规则表达式")
    private String expression;

    @ApiModelProperty(value = "目标表达式")
    private String targetExpression;

    @ApiModelProperty(value = "错误规则表达式")
    private String errorExpression;

    @ApiModelProperty(value = "要锁的规则表达式")
    private String lockExpression;

}
