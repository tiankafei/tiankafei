package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
@ApiModel(value = "DictTableEntity对象", description = "系统数据字典的数据表")
public class DictTableVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统字典id")
    @NotNull(message = "系统字典id不能为空！")
    private Long dictId;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    private String code;

    @ApiModelProperty(value = "名称")
    @Size(max = 500, message = "名称长度不能超过 500 ！")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "备注")
    @Size(max = 500, message = "备注长度不能超过 500 ！")
    private String remarks;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "所有父id，用逗号分隔")
    @Size(max = 2100, message = "所有父id，用逗号分隔长度不能超过 2100 ！")
    private String allParentId;

    @ApiModelProperty(value = "序号")
    private Integer serialNumber;

    @ApiModelProperty(value = "所在层级")
    private Integer level;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

    @ApiModelProperty(value = "子代码集合")
    private List<DictTableVo> children;

    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String REMARKS = "remarks";

    public static final String PARENT_ID = "parent_id";

    public static final String ALL_PARENT_ID = "all_parent_id";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String LEVEL = "level";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    public static final String TENANT_ID = "tenant_id";


}
