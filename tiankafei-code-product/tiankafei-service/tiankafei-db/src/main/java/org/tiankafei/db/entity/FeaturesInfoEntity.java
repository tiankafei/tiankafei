package org.tiankafei.db.entity;

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
    @TableField("features_code")
    private String featuresCode;

    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @TableField("features_name")
    private String featuresName;

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

    public static final String FEATURES_CODE = "features_code";

    public static final String FEATURES_NAME = "features_name";

    public static final String FEATURES_TABLE_NAME = "features_table_name";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String DESCRIPTION = "description";

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
