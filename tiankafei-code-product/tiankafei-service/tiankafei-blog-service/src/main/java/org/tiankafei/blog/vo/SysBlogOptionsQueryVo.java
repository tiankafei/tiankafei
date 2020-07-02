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
 * 系统的博客选项设置 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的博客选项设置 对象", description = "系统的博客选项设置 查询参数")
public class SysBlogOptionsQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 选项名称
     */
    @ApiModelProperty(value = "选项名称")
    @Size(max = 100, message = "选项名称长度不能超过 100 ！")
    private String optionsName;

    /**
     * 选项值
     */
    @ApiModelProperty(value = "选项值")
    @Size(max = 100, message = "选项值长度不能超过 100 ！")
    private String optionsValue;

    /**
     * 设置时间
     */
    @ApiModelProperty(value = "设置时间")
    private Timestamp settingTime;

    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

}