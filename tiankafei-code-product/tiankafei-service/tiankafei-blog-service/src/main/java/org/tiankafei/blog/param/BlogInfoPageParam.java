package org.tiankafei.blog.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.OrderQueryParam;

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
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的博客数据 分页列表参数对象")
public class BlogInfoPageParam extends OrderQueryParam {

    private static final long serialVersionUID = 1L;


}
