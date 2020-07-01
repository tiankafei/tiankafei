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
 * 字典的数据表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Data
@Accessors(chain = true)
@TableName("sys_dict_table")
@ApiModel(value = " 字典的数据表 实体对象" , description = "字典的数据表")
public class SysDictTableEntity extends BaseEntity {

    /**
     * 主键id，
     * 因为这张表有一个字段存储的所有父id，如果有多个，用逗号分割，用来查询所有的父亲节点（使用like），故不能使用自增自增主键，
     * 为了保证mysql不频繁进行页分裂，所以要保证主键按顺序自增，uuid排除掉不可用，
     * 看到mybatis-plus提供了一种自定义ID生成器：雪花算法+UUID(不含中划线)
     */
    @ApiModelProperty(value = "主键id")
    @Size(max = 20, message = "主键id长度不能超过 20 ！")
    @TableId(value = "id" , type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    @TableField("code")
    @NotBlank(message = "代码不能为空")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 500, message = "名称长度不能超过 500 ！")
    @TableField("name")
    @NotBlank(message = "名称不能为空")
    private String name;

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
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    @TableField("remarks")
    private String remarks;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    @Size(max = 20, message = "父id长度不能超过 20 ！")
    @TableField("parent_id")
    private String parentId;

    /**
     * 所有父id，用逗号分隔
     */
    @ApiModelProperty(value = "所有父id，用逗号分隔")
    @Size(max = 2100, message = "所有父id，用逗号分隔长度不能超过 2100 ！")
    @TableField("all_parent_id")
    private String allParentId;

    /**
     * 所在层级
     */
    @ApiModelProperty(value = "所在层级")
    @TableField("level")
    @NotNull(message = "所在层级不能为空")
    private Integer level;

    /**
     * 计量单位1
     */
    @ApiModelProperty(value = "计量单位1")
    @Size(max = 10, message = "计量单位1长度不能超过 10 ！")
    @TableField("unit1")
    private String unit1;

    /**
     * 计量单位2
     */
    @ApiModelProperty(value = "计量单位2")
    @Size(max = 10, message = "计量单位2长度不能超过 10 ！")
    @TableField("unit2")
    private String unit2;

    /**
     * 计量单位3
     */
    @ApiModelProperty(value = "计量单位3")
    @Size(max = 10, message = "计量单位3长度不能超过 10 ！")
    @TableField("unit3")
    private String unit3;

    /**
     * 计量单位4
     */
    @ApiModelProperty(value = "计量单位4")
    @Size(max = 10, message = "计量单位4长度不能超过 10 ！")
    @TableField("unit4")
    private String unit4;

    /**
     * 计量单位5
     */
    @ApiModelProperty(value = "计量单位5")
    @Size(max = 10, message = "计量单位5长度不能超过 10 ！")
    @TableField("unit5")
    private String unit5;

    /**
     * 计量单位6
     */
    @ApiModelProperty(value = "计量单位6")
    @Size(max = 10, message = "计量单位6长度不能超过 10 ！")
    @TableField("unit6")
    private String unit6;

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
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private Long createUserId;

}
