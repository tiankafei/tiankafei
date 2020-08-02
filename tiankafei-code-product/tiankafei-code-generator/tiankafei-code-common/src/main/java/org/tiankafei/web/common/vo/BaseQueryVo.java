package org.tiankafei.web.common.vo;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "基本的查询 对象", description = "基本的查询对象参数")
public class BaseQueryVo implements Serializable {

}
