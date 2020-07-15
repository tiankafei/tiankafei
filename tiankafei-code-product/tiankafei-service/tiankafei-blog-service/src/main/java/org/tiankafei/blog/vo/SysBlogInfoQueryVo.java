package org.tiankafei.blog.vo;

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
 * 系统的博客数据 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的博客数据 对象", description = "系统的博客数据 查询参数")
public class SysBlogInfoQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Size(max = 100, message = "标题长度不能超过 100 ！")
    private String title;

    /**
     * 文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符
     */
    @ApiModelProperty(value = "文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    private String content;

    /**
     * 文章分类(only one)，字典表的code长度最大是100，故在此使用100
     */
    @ApiModelProperty(value = "文章分类(only one)，字典表的code长度最大是100，故在此使用100")
    @Size(max = 100, message = "文章分类(only one)，字典表的code长度最大是100，故在此使用100长度不能超过 100 ！")
    private byte[] type;

    /**
     * 标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔
     */
    @ApiModelProperty(value = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔")
    @Size(max = 240, message = "标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔长度不能超过 240 ！")
    private String label;

    /**
     * 是否置顶，1是，0否
     */
    @ApiModelProperty(value = "是否置顶，1是，0否")
    private Boolean isTop;

    /**
     * 自定义访问路径的名称，默认使用id
     */
    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    @Size(max = 30, message = "自定义访问路径的名称，默认使用id长度不能超过 30 ！")
    private String customName;

    /**
     * 访问权限：1功能开，2仅登录用户，3仅自己可见
     */
    @ApiModelProperty(value = "访问权限：1功能开，2仅登录用户，3仅自己可见")
    @Size(max = 2, message = "访问权限：1功能开，2仅登录用户，3仅自己可见长度不能超过 2 ！")
    private String accessPermission;

    /**
     * 密码保护
     */
    @ApiModelProperty(value = "密码保护")
    @Size(max = 64, message = "密码保护长度不能超过 64 ！")
    private String password;

    /**
     * 是否开启评论，1是，0否
     */
    @ApiModelProperty(value = "是否开启评论，1是，0否")
    private Boolean isDiscuss;

    /**
     * 是否允许订阅
     */
    @ApiModelProperty(value = "是否允许订阅")
    private Boolean isSubscription;

    /**
     * 发布状态：1草稿，2已发布
     */
    @ApiModelProperty(value = "发布状态：1草稿，2已发布")
    @Size(max = 1, message = "发布状态：1草稿，2已发布长度不能超过 1 ！")
    private String releaseStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private Timestamp releaseTime;

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