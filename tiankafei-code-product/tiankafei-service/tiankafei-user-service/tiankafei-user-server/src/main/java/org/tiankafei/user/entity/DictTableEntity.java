package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统数据字典的数据表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_table")
@ApiModel(value = "DictTableEntity 对象", description = "系统数据字典的数据表")
public class DictTableEntity extends Model<DictTableEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @Size(max = 500, message = "名称长度不能超过 500 ！")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "所有父id，用逗号分隔")
    @Size(max = 2100, message = "所有父id，用逗号分隔长度不能超过 2100 ！")
    @TableField("all_parent_id")
    private String allParentId;

    @ApiModelProperty(value = "序号")
    @TableField("serial_number")
    private Integer serialNumber;

    @ApiModelProperty(value = "所在层级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "计量单位1")
    @Size(max = 10, message = "计量单位1长度不能超过 10 ！")
    @TableField("unit1")
    private String unit1;

    @ApiModelProperty(value = "计量单位2")
    @Size(max = 10, message = "计量单位2长度不能超过 10 ！")
    @TableField("unit2")
    private String unit2;

    @ApiModelProperty(value = "计量单位3")
    @Size(max = 10, message = "计量单位3长度不能超过 10 ！")
    @TableField("unit3")
    private String unit3;

    @ApiModelProperty(value = "计量单位4")
    @Size(max = 10, message = "计量单位4长度不能超过 10 ！")
    @TableField("unit4")
    private String unit4;

    @ApiModelProperty(value = "计量单位5")
    @Size(max = 10, message = "计量单位5长度不能超过 10 ！")
    @TableField("unit5")
    private String unit5;

    @ApiModelProperty(value = "计量单位6")
    @Size(max = 10, message = "计量单位6长度不能超过 10 ！")
    @TableField("unit6")
    private String unit6;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
//    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
//    @TableLogic
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

    @ApiModelProperty(value = "租户ID")
    @TableField("tenant_id")
    private Long tenantId;


    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String REMARKS = "remarks";

    public static final String PARENT_ID = "parent_id";

    public static final String ALL_PARENT_ID = "all_parent_id";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String LEVEL = "level";

    public static final String UNIT1 = "unit1";

    public static final String UNIT2 = "unit2";

    public static final String UNIT3 = "unit3";

    public static final String UNIT4 = "unit4";

    public static final String UNIT5 = "unit5";

    public static final String UNIT6 = "unit6";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    public static final String TENANT_ID = "tenant_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
