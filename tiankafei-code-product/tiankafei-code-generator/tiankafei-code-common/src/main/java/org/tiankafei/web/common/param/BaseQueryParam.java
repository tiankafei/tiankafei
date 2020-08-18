package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.constants.CommonConstants;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel("查询参数对象")
public abstract class BaseQueryParam implements Serializable {

    @ApiModelProperty(value = "页码,默认为1", example = "1")
    private Integer current = CommonConstants.DEFAULT_PAGE_INDEX;
    @ApiModelProperty(value = "页大小,默认为10", example = "10")
    private Integer size = CommonConstants.DEFAULT_PAGE_SIZE;
    @ApiModelProperty(value = "搜索字符串", example = "")
    private String keyword;

    public void setCurrent(Integer current) {
        if (current == null || current <= 0) {
            this.current = CommonConstants.DEFAULT_PAGE_INDEX;
        } else {
            this.current = current;
        }
    }

    public void setSize(Integer size) {
        if (size == null || size <= 0) {
            this.size = CommonConstants.DEFAULT_PAGE_SIZE;
        } else {
            this.size = size;
        }
    }

}
