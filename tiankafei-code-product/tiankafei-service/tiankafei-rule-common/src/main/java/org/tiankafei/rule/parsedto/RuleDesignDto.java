//package org.tiankafei.rule.parsedto;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.util.List;
//import lombok.Data;
//import lombok.experimental.Accessors;
//
///**
// * 规则设计对象
// *
// * @author tiankafei
// */
//@Data
//@Accessors(chain = true)
//@ApiModel(value = "规则设计表达式 对象", description = "规则设计表达式 对象")
//public class RuleDesignDto {
//
//    @ApiModelProperty(value = "规则代码")
//    private String code;
//
//    @ApiModelProperty(value = "规则名称")
//    private String name;
//
//    @ApiModelProperty(value = "规则类型：1审核规则，2计算规则，3跳转规则")
//    private String type;
//
//    @ApiModelProperty(value = "规则表达式")
//    private String expression;
//
//    @ApiModelProperty(value = "规则表达式生成的javascript的脚本")
//    private String javascript;
//
//    @ApiModelProperty(value = "规则表达式生成的规则解析对象")
//    private RuleExpressionDto expressionDto;
//
//    @ApiModelProperty(value = "错误规则表达式")
//    private String errorExpression;
//
//    @ApiModelProperty(value = "错误规则表达式生成的javascript的脚本")
//    private List<String> errorJavascriptList;
//
//    @ApiModelProperty(value = "错误规则表达式生成的规则解析对象集合")
//    private List<RuleExpressionDto> errorExpressionList;
//
//    @ApiModelProperty(value = "目标表达式")
//    private String targetExpression;
//
//    @ApiModelProperty(value = "目标规则表达式生成的规则解析对象")
//    private RuleExpressionDto targetExpressionDto;
//
//    @ApiModelProperty(value = "要锁的规则表达式")
//    private String lockExpression;
//
//    @ApiModelProperty(value = "要锁的规则表达式生成的规则解析对象")
//    private RuleExpressionDto lockExpressionDto;
//
//}
