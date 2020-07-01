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

/**
 * <pre>
 * 角色信息表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Data
@Accessors(chain = true)
@TableName("sys_rule_info")
@ApiModel(value = " 角色信息表 实体对象" , description = "角色信息表")
public class SysRuleInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 角色代码
     */
    @ApiModelProperty(value = "角色代码")
    @Size(max = 20, message = "角色代码长度不能超过 20 ！")
    @TableField("rule_code")
    private String ruleCode;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @Size(max = 100, message = "角色名称长度不能超过 100 ！")
    @TableField("rule_name")
    private String ruleName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    /**
     * 角色状态:1启用，0停用
     */
    @ApiModelProperty(value = "角色状态:1启用，0停用")
    @Size(max = 1, message = "角色状态:1启用，0停用长度不能超过 1 ！")
    @TableField("status")
    private Boolean status;

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
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    @TableField("create_user_id")
    private Long createUserId;

}
