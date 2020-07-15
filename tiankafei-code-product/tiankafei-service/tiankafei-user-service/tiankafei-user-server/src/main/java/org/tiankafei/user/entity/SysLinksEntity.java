package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.entity.BaseEntity;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * <pre>
 * 系统的友情链接
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_links")
@ApiModel(value = " 系统的友情链接 实体对象", description = "系统的友情链接")
public class SysLinksEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 链接名称
     */
    @ApiModelProperty(value = "链接名称")
    @Size(max = 20, message = "链接名称长度不能超过 20 ！")
    @TableField(value = "name")
    private String name;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址")
    @Size(max = 100, message = "链接地址长度不能超过 100 ！")
    @TableField(value = "links")
    private String links;

    /**
     * 状态：是否启用，1启用，2停用
     */
    @ApiModelProperty(value = "状态：是否启用，1启用，2停用")
    @TableField(value = "status")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

}
