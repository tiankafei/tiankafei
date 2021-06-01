package org.tiankafei.rule.parsedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "报告期对象", description = "报告期对象")
public class ReportingPeriodDto {

    @ApiModelProperty(value = "指定的报告期")
    private String reportingPeriod;

    @ApiModelProperty(value = "是否所有历史报告期")
    private Boolean allHistoryReportingPeriod = Boolean.FALSE;

    @ApiModelProperty(value = "是否去年同期")
    private Boolean sameTimeLastYear = Boolean.FALSE;

    @ApiModelProperty(value = "报告期的偏移量：例如:本期0，上期-1，")
    private Integer reportingPeriodOffset = 0;

}
