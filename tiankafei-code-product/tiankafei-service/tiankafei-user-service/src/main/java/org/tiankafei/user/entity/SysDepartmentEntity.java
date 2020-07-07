package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import org.tiankafei.web.common.entity.BaseEntity;

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
 * 系统部门表信息
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_department")
@ApiModel(value = " 系统部门表信息 实体对象" , description = "系统部门表信息")
public class SysDepartmentEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 部门代码
     */
    @ApiModelProperty(value = "部门代码")
    @Size(max = 20, message = "部门代码长度不能超过 20 ！")
    @TableField("department_code")
    private String departmentCode;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    @Size(max = 100, message = "部门名称长度不能超过 100 ！")
    @TableField("department_name")
    private String departmentName;

    /**
     * 父部门
     */
    @ApiModelProperty(value = "父部门")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    @TableField("serial_number")
    private Integer serialNumber;

    /**
     * 当前部门所处的层级(在第几级)
     */
    @ApiModelProperty(value = "当前部门所处的层级(在第几级)")
    @TableField("level")
    private Integer level;

    /**
     * 部门职责
     */
    @ApiModelProperty(value = "部门职责")
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Timestamp updateTime;

    /**
     * 部门创建人
     */
    @ApiModelProperty(value = "部门创建人")
    @TableField("create_user_id")
    private Long createUserId;

}
