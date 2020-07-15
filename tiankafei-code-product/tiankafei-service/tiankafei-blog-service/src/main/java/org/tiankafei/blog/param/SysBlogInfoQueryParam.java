package org.tiankafei.blog.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 系统的博客数据 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统的博客数据 查询参数对象", description = "系统的博客数据查询参数")
public class SysBlogInfoQueryParam implements Serializable {


}
