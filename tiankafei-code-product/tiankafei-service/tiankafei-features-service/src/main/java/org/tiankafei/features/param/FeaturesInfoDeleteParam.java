package org.tiankafei.features.param;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "功能注册表 删除参数对象")
public class FeaturesInfoDeleteParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
