package org.tiankafei.blog.entity;

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
 * 系统的博客选项设置
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_blog_options")
@ApiModel(value = " 系统的博客选项设置 实体对象" , description = "系统的博客选项设置")
public class SysBlogOptionsEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 选项名称
     */
    @ApiModelProperty(value = "选项名称")
    @Size(max = 100, message = "选项名称长度不能超过 100 ！")
    @TableField("options_name")
    private String optionsName;

    /**
     * 选项值
     */
    @ApiModelProperty(value = "选项值")
    @Size(max = 100, message = "选项值长度不能超过 100 ！")
    @TableField("options_value")
    private String optionsValue;

    /**
     * 设置时间
     */
    @ApiModelProperty(value = "设置时间")
    @TableField("setting_time")
    private Timestamp settingTime;

    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    @TableField("create_user_id")
    private Long createUserId;

}
