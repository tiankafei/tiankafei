package org.tiankafei.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
@ApiModel(value = "BlogInfoEntity对象", description = "系统的博客数据")
public class BlogInfoVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    private String content;

    @ApiModelProperty(value = "文章分类(only one)，字典表的code长度最大是100，故在此使用100")
    private byte[] type;

    @ApiModelProperty(value = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔")
    private String label;

    @ApiModelProperty(value = "是否置顶，1是，0否")
    private Boolean isTop;

    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    private String customName;

    @ApiModelProperty(value = "访问权限：1功能开，2仅登录用户，3仅自己可见")
    private String accessPermission;

    @ApiModelProperty(value = "密码保护")
    private String password;

    @ApiModelProperty(value = "是否开启评论，1是，0否")
    private Boolean isDiscuss;

    @ApiModelProperty(value = "是否允许订阅")
    private Boolean isSubscription;

    @ApiModelProperty(value = "发布状态：1草稿，2已发布")
    private String releaseStatus;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "发布时间")
    private Timestamp releaseTime;

    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
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


}
