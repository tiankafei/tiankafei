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
 * 系统数据字典表
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_dict_info")
@ApiModel(value = " 系统数据字典表 实体对象" , description = "系统数据字典表")
public class SysDictInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 字典代码
     */
    @ApiModelProperty(value = "字典代码")
    @Size(max = 20, message = "字典代码长度不能超过 20 ！")
    @TableField("dict_code")
    @NotBlank(message = "字典代码不能为空")
    private String dictCode;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    @Size(max = 100, message = "字典名称长度不能超过 100 ！")
    @TableField("dict_name")
    @NotBlank(message = "字典名称不能为空")
    private String dictName;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    @TableField("status")
    private Boolean status;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 60, message = "备注长度不能超过 60 ！")
    @TableField("remarks")
    private String remarks;

    /**
     * 数据表
     */
    @ApiModelProperty(value = "数据表")
    @Size(max = 30, message = "数据表长度不能超过 30 ！")
    @TableField("data_table")
    private String dataTable;

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
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField("update_user_id")
    private Long updateUserId;

}
