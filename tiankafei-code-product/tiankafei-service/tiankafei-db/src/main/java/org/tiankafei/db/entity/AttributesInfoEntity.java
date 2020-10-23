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
 * 功能的属性注册表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_attributes_info")
@ApiModel(value = "AttributesInfoEntity 对象", description = "功能的属性注册表")
public class AttributesInfoEntity extends Model<AttributesInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    @TableField("features_code")
    private String featuresCode;

    @ApiModelProperty(value = "属性代码")
    @Size(max = 20, message = "属性代码长度不能超过 20 ！")
    @TableField("attributes_code")
    private String attributesCode;

    @ApiModelProperty(value = "属性名称")
    @Size(max = 100, message = "属性名称长度不能超过 100 ！")
    @TableField("attributes_name")
    private String attributesName;

    @ApiModelProperty(value = "数据类型")
    @Size(max = 3, message = "数据类型长度不能超过 3 ！")
    @TableField("data_type")
    private String dataType;

    @ApiModelProperty(value = "数据长度")
    @TableField("data_length")
    private Integer dataLength;

    @ApiModelProperty(value = "数据精度")
    @TableField("data_precision")
    private Integer dataPrecision;

    @ApiModelProperty(value = "是否允许为空")
    @TableField("is_null")
    private Boolean isNull;

    @ApiModelProperty(value = "默认值")
    @Size(max = 20, message = "默认值长度不能超过 20 ！")
    @TableField("default_value")
    private String defaultValue;

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

    @ApiModelProperty(value = "租户ID")
    @TableField("tenant_id")
    private Long tenantId;


    public static final String ID = "id";

    public static final String FEATURES_CODE = "features_code";

    public static final String ATTRIBUTES_CODE = "attributes_code";

    public static final String ATTRIBUTES_NAME = "attributes_name";

    public static final String DATA_TYPE = "data_type";

    public static final String DATA_LENGTH = "data_length";

    public static final String DATA_PRECISION = "data_precision";

    public static final String IS_NULL = "is_null";

    public static final String DEFAULT_VALUE = "default_value";

    public static final String DESCRIPTION = "description";

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
