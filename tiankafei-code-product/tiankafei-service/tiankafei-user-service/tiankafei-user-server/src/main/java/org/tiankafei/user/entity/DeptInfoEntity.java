package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.entity.BaseEntity;

/**
 * <pre>
 * 系统部门表信息
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_department")
@ApiModel(value = " 系统部门表信息 实体对象", description = "系统部门表信息")
public class DeptInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门代码
     */
    @ApiModelProperty(value = "部门代码")
    @Size(max = 20, message = "部门代码长度不能超过 20 ！")
    @TableField(value = "department_code")
    private String departmentCode;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    @Size(max = 100, message = "部门名称长度不能超过 100 ！")
    @TableField(value = "department_name")
    private String departmentName;

    /**
     * 父部门
     */
    @ApiModelProperty(value = "父部门")
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    @TableField(value = "serial_number")
    private Integer serialNumber;

    /**
     * 当前部门所处的层级(在第几级)
     */
    @ApiModelProperty(value = "当前部门所处的层级(在第几级)")
    @TableField(value = "level")
    private Integer level;

    /**
     * 部门职责
     */
    @ApiModelProperty(value = "部门职责")
    @TableField(value = "description")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    /**
     * 部门创建用户ID
     */
    @ApiModelProperty(value = "部门创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 部门修改用户ID
     */
    @ApiModelProperty(value = "部门修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

}
