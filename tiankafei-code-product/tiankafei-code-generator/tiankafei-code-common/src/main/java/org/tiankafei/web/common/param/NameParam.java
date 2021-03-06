package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@ApiModel("名称参数")
public class NameParam implements Serializable {

    @ApiModelProperty("名称")
    private String name;

    @Override
    public String toString() {
        return "NameParam{" +
                "name='" + name + '\'' +
                '}';
    }
}
