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
 * 系统的友情链接
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_links_info")
@ApiModel(value = "LinksInfoEntity 对象", description = "系统的友情链接")
public class LinksInfoEntity extends Model<LinksInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "链接名称")
    @Size(max = 20, message = "链接名称长度不能超过 20 ！")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "链接地址")
    @Size(max = 100, message = "链接地址长度不能超过 100 ！")
    @TableField("links")
    private String links;

    @ApiModelProperty(value = "状态：是否启用，1启用，2停用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "序号")
    @TableField("serial_number")
    private Integer serialNumber;

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

    public static final String NAME = "name";

    public static final String LINKS = "links";

    public static final String STATUS = "status";

    public static final String SERIAL_NUMBER = "serial_number";

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
