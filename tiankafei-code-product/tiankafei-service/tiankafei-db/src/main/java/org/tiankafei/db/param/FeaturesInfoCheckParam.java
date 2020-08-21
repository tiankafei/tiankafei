package org.tiankafei.db.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 功能注册表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "功能注册表 检查是否存在参数对象")
public class FeaturesInfoCheckParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

}
