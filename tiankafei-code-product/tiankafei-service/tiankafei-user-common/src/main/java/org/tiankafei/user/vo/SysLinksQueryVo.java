package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * <pre>
 * 系统的友情链接 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的友情链接 对象", description = "系统的友情链接 查询参数")
public class SysLinksQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 链接名称
     */
    @ApiModelProperty(value = "链接名称")
    @Size(max = 20, message = "链接名称长度不能超过 20 ！")
    private String name;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址")
    @Size(max = 100, message = "链接地址长度不能超过 100 ！")
    private String links;

    /**
     * 状态：是否启用，1启用，2停用
     */
    @ApiModelProperty(value = "状态：是否启用，1启用，2停用")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;

}