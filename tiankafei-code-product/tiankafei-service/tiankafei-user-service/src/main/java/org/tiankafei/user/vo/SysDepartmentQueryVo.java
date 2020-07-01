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
 * 系统部门表信息 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统部门表信息 对象", description = "系统部门表信息 查询参数")
public class SysDepartmentQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 部门代码
     */
    @ApiModelProperty(value = "部门代码")
    @Size(max = 20, message = "部门代码长度不能超过 20 ！")
    private String departmentCode;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    @Size(max = 100, message = "部门名称长度不能超过 100 ！")
    private String departmentName;

    /**
     * 父部门
     */
    @ApiModelProperty(value = "父部门")
    private Integer parentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    private Integer serialNumber;

    /**
     * 当前部门所处的层级(在第几级)
     */
    @ApiModelProperty(value = "当前部门所处的层级(在第几级)")
    private Integer level;

    /**
     * 部门职责
     */
    @ApiModelProperty(value = "部门职责")
    private String description;

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
     * 部门创建人
     */
    @ApiModelProperty(value = "部门创建人")
    private Long createUserId;

}