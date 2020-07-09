package org.tiankafei.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import org.tiankafei.web.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 系统的博客日记
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_blog_diary")
@ApiModel(value = " 系统的博客日记 实体对象" , description = "系统的博客日记")
public class SysBlogDiaryEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Size(max = 100, message = "标题长度不能超过 100 ！")
    @TableField(value = "title")
    private String title;

    /**
     * 日记内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符
     */
    @ApiModelProperty(value = "日记内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    @TableField(value = "content")
    private String content;

    /**
     * 自定义访问路径的名称，默认使用id
     */
    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    @Size(max = 30, message = "自定义访问路径的名称，默认使用id长度不能超过 30 ！")
    @TableField(value = "custom_name")
    private String customName;

    /**
     * 密码保护
     */
    @ApiModelProperty(value = "密码保护")
    @Size(max = 64, message = "密码保护长度不能超过 64 ！")
    @TableField(value = "password")
    private String password;

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
