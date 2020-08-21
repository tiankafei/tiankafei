package org.tiankafei.db.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 功能的属性注册表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "功能的属性注册表 求记录数参数对象")
public class AttributesInfoCountParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
