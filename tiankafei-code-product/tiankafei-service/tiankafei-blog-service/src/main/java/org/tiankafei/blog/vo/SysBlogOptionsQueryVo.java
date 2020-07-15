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
 * 系统的博客选项设置 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
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
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    private String remark;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 设置时间
     */
    @ApiModelProperty(value = "设置时间")
    private Timestamp createTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;

}