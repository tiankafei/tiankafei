package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import org.tiankafei.web.common.entity.BaseEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 系统的友情链接
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-02
 */
@Data
@Accessors(chain = true)
@TableName("sys_links")
@ApiModel(value = " 系统的友情链接 实体对象" , description = "系统的友情链接")
public class SysLinksEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 链接名称
     */
    @ApiModelProperty(value = "链接名称")
    @Size(max = 20, message = "链接名称长度不能超过 20 ！")
    @TableField("name")
    private String name;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址")
    @Size(max = 100, message = "链接地址长度不能超过 100 ！")
    @TableField("links")
    private String links;

    /**
     * 状态：是否启用，1启用，2停用
     */
    @ApiModelProperty(value = "状态：是否启用，1启用，2停用")
    @TableField("status")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private Long createUserId;

}
