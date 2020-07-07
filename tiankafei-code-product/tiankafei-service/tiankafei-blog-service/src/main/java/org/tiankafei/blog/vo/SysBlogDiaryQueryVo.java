package org.tiankafei.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.tiankafei.web.common.vo.BaseQueryVo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * <pre>
 * 系统的博客日记 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的博客日记 对象", description = "系统的博客日记 查询参数")
public class SysBlogDiaryQueryVo extends BaseQueryVo {

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
     * 日记内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符
     */
    @ApiModelProperty(value = "日记内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符")
    private String content;

    /**
     * 自定义访问路径的名称，默认使用id
     */
    @ApiModelProperty(value = "自定义访问路径的名称，默认使用id")
    @Size(max = 30, message = "自定义访问路径的名称，默认使用id长度不能超过 30 ！")
    private String customName;

    /**
     * 密码保护
     */
    @ApiModelProperty(value = "密码保护")
    @Size(max = 64, message = "密码保护长度不能超过 64 ！")
    private String password;

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
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

}