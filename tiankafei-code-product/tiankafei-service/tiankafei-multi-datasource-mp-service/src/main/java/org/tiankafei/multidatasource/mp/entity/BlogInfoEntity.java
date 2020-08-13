package org.tiankafei.multidatasource.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统的博客数据
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_blog_info")
@ApiModel(value = "BlogInfoEntity 对象", description = "系统的博客数据")
public class BlogInfoEntity extends Model<BlogInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "标题")
    @Size(max = 100, message = "标题长度不能超过 100 ！")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "文章分类(only one)，字典表的code长度最大是100，故在此使用100")
    @Size(max = 100, message = "文章分类(only one)，字典表的code长度最大是100，故在此使用100长度不能超过 100 ！")
    @TableField("type")
    private byte[] type;

    @ApiModelProperty(value = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔")
    @Size(max = 240, message = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔长度不能超过 240 ！")
    @TableField("label")
    private String label;

    @ApiModelProperty(value = "是否置顶，1是，0否")
    @TableField("is_top")
    private Boolean isTop;

    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    @Size(max = 30, message = "自定义访问路径的名称，默认使用id长度不能超过 30 ！")
    @TableField("custom_name")
    private String customName;

    @ApiModelProperty(value = "访问权限：1功能开，2仅登录用户，3仅自己可见")
    @Size(max = 2, message = "访问权限：1功能开，2仅登录用户，3仅自己可见长度不能超过 2 ！")
    @TableField("access_permission")
    private String accessPermission;

    @ApiModelProperty(value = "密码保护")
    @Size(max = 64, message = "密码保护长度不能超过 64 ！")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "是否开启评论，1是，0否")
    @TableField("is_discuss")
    private Boolean isDiscuss;

    @ApiModelProperty(value = "是否允许订阅")
    @TableField("is_subscription")
    private Boolean isSubscription;

    @ApiModelProperty(value = "发布状态：1草稿，2已发布")
    @Size(max = 1, message = "发布状态：1草稿，2已发布长度不能超过 1 ！")
    @TableField("release_status")
    private String releaseStatus;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
    @TableLogic
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "发布时间")
    @TableField("release_time")
    private Timestamp releaseTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;


    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String CONTENT = "content";

    public static final String TYPE = "type";

    public static final String LABEL = "label";

    public static final String IS_TOP = "is_top";

    public static final String CUSTOM_NAME = "custom_name";

    public static final String ACCESS_PERMISSION = "access_permission";

    public static final String PASSWORD = "password";

    public static final String IS_DISCUSS = "is_discuss";

    public static final String IS_SUBSCRIPTION = "is_subscription";

    public static final String RELEASE_STATUS = "release_status";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String RELEASE_TIME = "release_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
