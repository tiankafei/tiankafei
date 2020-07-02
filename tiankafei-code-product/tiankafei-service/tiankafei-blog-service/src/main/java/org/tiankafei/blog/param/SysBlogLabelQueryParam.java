package org.tiankafei.blog.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 系统的博客标签 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统的博客标签 查询参数对象", description = "系统的博客标签查询参数")
public class SysBlogLabelQueryParam implements Serializable {




}
