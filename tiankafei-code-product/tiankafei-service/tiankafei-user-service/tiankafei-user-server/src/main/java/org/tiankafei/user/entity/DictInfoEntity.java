package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
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
 * 系统数据字典表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_info")
@ApiModel(value = "DictInfoEntity 对象", description = "系统数据字典表")
public class DictInfoEntity extends Model<DictInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "字典代码")
    @Size(max = 20, message = "字典代码长度不能超过 20 ！")
    @TableField("dict_code")
    private String dictCode;

    @ApiModelProperty(value = "字典名称")
    @Size(max = 100, message = "字典名称长度不能超过 100 ！")
    @TableField("dict_name")
    private String dictName;

    @ApiModelProperty(value = "状态：0设计中，1启用，2停用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "备注")
    @Size(max = 60, message = "备注长度不能超过 60 ！")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "数据表")
    @Size(max = 30, message = "数据表长度不能超过 30 ！")
    @TableField("data_table")
    private String dataTable;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
    @TableLogic
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


    public static final String ID = "id";

    public static final String DICT_CODE = "dict_code";

    public static final String DICT_NAME = "dict_name";

    public static final String STATUS = "status";

    public static final String DESCRIPTION = "description";

    public static final String REMARKS = "remarks";

    public static final String DATA_TABLE = "data_table";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
