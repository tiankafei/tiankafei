package org.tiankafei.user.vo;

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
 * 系统数据字典表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统数据字典表 对象", description = "系统数据字典表 查询参数")
public class SysDictInfoQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 字典代码
     */
    @ApiModelProperty(value = "字典代码")
    @Size(max = 20, message = "字典代码长度不能超过 20 ！")
    @NotBlank(message = "字典代码不能为空")
    private String dictCode;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    @Size(max = 100, message = "字典名称长度不能超过 100 ！")
    @NotBlank(message = "字典名称不能为空")
    private String dictName;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    private Boolean status;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 60, message = "备注长度不能超过 60 ！")
    private String remarks;

    /**
     * 数据表
     */
    @ApiModelProperty(value = "数据表")
    @Size(max = 30, message = "数据表长度不能超过 30 ！")
    private String dataTable;

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