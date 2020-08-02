package org.tiankafei.blog.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统的博客数据 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统的博客数据 列表参数对象")
public class BlogInfoListParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
