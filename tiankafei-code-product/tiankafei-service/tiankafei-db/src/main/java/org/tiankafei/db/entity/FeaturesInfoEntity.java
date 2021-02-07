package org.tiankafei.db.entity;

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
 * 功能注册表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_features_info")
@ApiModel(value = "FeaturesInfoEntity 对象", description = "功能注册表")
public class FeaturesInfoEntity extends Model<FeaturesInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    @Size(max = 1, message = "帐号状态（0正常 1停用）长度不能超过 1 ！")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "功能的数据表")
    @Size(max = 30, message = "功能的数据表长度不能超过 30 ！")
    @TableField("features_table_name")
    private String featuresTableName;

    @ApiModelProperty(value = "序号")
    @TableField("serial_number")
    private Integer serialNumber;

    @ApiModelProperty(value = "功能描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @Size(max = 1, message = "删除标志（0代表存在 2代表删除）长度不能超过 1 ！")
    @TableField("del_flag")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    @Size(max = 64, message = "创建者长度不能超过 64 ！")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "更新者")
    @Size(max = 64, message = "更新者长度不能超过 64 ！")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "备注")
    @Size(max = 500, message = "备注长度不能超过 500 ！")
    @TableField("remark")
    private String remark;


    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String STATUS = "status";

    public static final String FEATURES_TABLE_NAME = "features_table_name";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String DESCRIPTION = "description";

    public static final String DEL_FLAG = "del_flag";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String REMARK = "remark";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
