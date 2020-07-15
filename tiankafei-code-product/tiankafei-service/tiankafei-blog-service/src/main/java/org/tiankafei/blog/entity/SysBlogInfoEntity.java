package org.tiankafei.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.EqualsAndHashCode;
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
 * 系统的博客数据
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_blog_info")
@ApiModel(value = " 系统的博客数据 实体对象" , description = "系统的博客数据")
public class SysBlogInfoEntity extends BaseEntity {

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
     * 文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符
     */
    @ApiModelProperty(value = "文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    @TableField(value = "content")
    private String content;

    /**
     * 文章分类(only one)，字典表的code长度最大是100，故在此使用100
     */
    @ApiModelProperty(value = "文章分类(only one)，字典表的code长度最大是100，故在此使用100")
    @Size(max = 100, message = "文章分类(only one)，字典表的code长度最大是100，故在此使用100长度不能超过 100 ！")
    @TableField(value = "type")
    private byte[] type;

    /**
     * 标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔
     */
    @ApiModelProperty(value = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔")
    @Size(max = 240, message = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔长度不能超过 240 ！")
    @TableField(value = "label")
    private String label;

    /**
     * 是否置顶，1是，0否
     */
    @ApiModelProperty(value = "是否置顶，1是，0否")
    @TableField(value = "is_top")
    private Boolean isTop;

    /**
     * 自定义访问路径的名称，默认使用id
     */
    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    @Size(max = 30, message = "自定义访问路径的名称，默认使用id长度不能超过 30 ！")
    @TableField(value = "custom_name")
    private String customName;

    /**
     * 访问权限：1功能开，2仅登录用户，3仅自己可见
     */
    @ApiModelProperty(value = "访问权限：1功能开，2仅登录用户，3仅自己可见")
    @Size(max = 2, message = "访问权限：1功能开，2仅登录用户，3仅自己可见长度不能超过 2 ！")
    @TableField(value = "access_permission")
    private String accessPermission;

    /**
     * 密码保护
     */
    @ApiModelProperty(value = "密码保护")
    @Size(max = 64, message = "密码保护长度不能超过 64 ！")
    @TableField(value = "password")
    private String password;

    /**
     * 是否开启评论，1是，0否
     */
    @ApiModelProperty(value = "是否开启评论，1是，0否")
    @TableField(value = "is_discuss")
    private Boolean isDiscuss;

    /**
     * 是否允许订阅
     */
    @ApiModelProperty(value = "是否允许订阅")
    @TableField(value = "is_subscription")
    private Boolean isSubscription;

    /**
     * 发布状态：1草稿，2已发布
     */
    @ApiModelProperty(value = "发布状态：1草稿，2已发布")
    @Size(max = 1, message = "发布状态：1草稿，2已发布长度不能超过 1 ！")
    @TableField(value = "release_status")
    private String releaseStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    @TableField(value = "release_time")
    private Timestamp releaseTime;

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
