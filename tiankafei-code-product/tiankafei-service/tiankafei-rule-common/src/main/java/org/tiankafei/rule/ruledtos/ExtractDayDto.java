package org.tiankafei.rule.ruledtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "摘抄日报参数对象", description = "摘抄日报参数对象")
public class ExtractDayDto {

    @ApiModelProperty(value = "函数名")
    private String methodName;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "指定时间范围的key值")
    private String time;

}
