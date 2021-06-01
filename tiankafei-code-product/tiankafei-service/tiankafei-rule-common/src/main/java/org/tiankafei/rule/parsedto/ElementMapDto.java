package org.tiankafei.rule.parsedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 元素映射对象
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "元素映射对象", description = "元素映射对象")
public class ElementMapDto {

    @ApiModelProperty(value = "当前元素的别名")
    private String aliasName;

    @ApiModelProperty(value = "当前元素的表达式：[]里面的内容")
    private String expression;

    @ApiModelProperty(value = "数据集的唯一标识符")
    private String datasetUniqueIdentifier;

    @ApiModelProperty(value = "数据唯一标识符")
    private String dataUniqueIdentifier;

    @ApiModelProperty(value = "跳转规则锁格子的同时是否需要清空值：true清空，false不清空")
    private Boolean clearFlag = Boolean.FALSE;

    @ApiModelProperty(value = "是否时y1，compareMulu函数第三个参数中定位的元素")
    private Boolean y1Flag = Boolean.FALSE;

    @ApiModelProperty(value = "是否时y2，compareMulu函数第三个参数中定位的元素")
    private Boolean y2Flag = Boolean.FALSE;

    @ApiModelProperty(value = "是否系统参数")
    private Boolean sysParamFlag = Boolean.FALSE;

    @ApiModelProperty(value = "报告期对象")
    private ReportingPeriodDto reportingPeriodDto;

    @ApiModelProperty(value = "聚合函数对象")
    private AggregateFunctionDto aggregateFunctionDto;

    @ApiModelProperty(value = "行列范围对象")
    private RankRangeDto rankRangeDto;

    @ApiModelProperty(value = "摘抄日报参数对象")
    private ExtractDayDto extractDayDto;

}
