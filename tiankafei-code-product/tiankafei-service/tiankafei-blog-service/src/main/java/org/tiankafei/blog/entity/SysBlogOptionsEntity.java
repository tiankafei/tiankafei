package org.tiankafei.blog.entity;

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
 * 系统的博客选项设置
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_blog_options")
@ApiModel(value = " 系统的博客选项设置 实体对象", description = "系统的博客选项设置")
public class SysBlogOptionsEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 选项名称
     */
    @ApiModelProperty(value = "选项名称")
    @Size(max = 100, message = "选项名称长度不能超过 100 ！")
    @TableField(value = "options_name")
    private String optionsName;

    /**
     * 选项值
     */
    @ApiModelProperty(value = "选项值")
    @Size(max = 100, message = "选项值长度不能超过 100 ！")
    @TableField(value = "options_value")
    private String optionsValue;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    @TableField(value = "remark")
    private String remark;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField(value = "description")
    private String description;

    /**
     * 设置时间
     */
    @ApiModelProperty(value = "设置时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

}
