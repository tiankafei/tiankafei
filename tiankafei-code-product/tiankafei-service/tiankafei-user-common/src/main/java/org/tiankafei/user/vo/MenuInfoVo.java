package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <p>
 * 系统功能菜单信息表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "MenuInfoEntity对象", description = "系统功能菜单信息表")
public class MenuInfoVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    private String menuCode;

    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    private String menuName;

    @ApiModelProperty(value = "图标的名称")
    @Size(max = 20, message = "图标的名称长度不能超过 20 ！")
    private String icon;

    @ApiModelProperty(value = "菜单类型：1目录，2菜单，3按钮")
    @Size(max = 1, message = "菜单类型：1目录，2菜单，3按钮长度不能超过 1 ！")
    private String menuType;

    @ApiModelProperty(value = "打开方式：1页签，2新窗口")
    @Size(max = 1, message = "打开方式：1页签，2新窗口长度不能超过 1 ！")
    private String openType;

    @ApiModelProperty(value = "功能的url路径")
    @Size(max = 50, message = "功能的url路径长度不能超过 50 ！")
    private String path;

    @ApiModelProperty(value = "是否外部链接：1是，0否")
    private Boolean isOutsideUrl;

    @ApiModelProperty(value = "状态：1启用，0停用")
    private Boolean status;

    @ApiModelProperty(value = "权限关键字标识")
    @Size(max = 60, message = "权限关键字标识长度不能超过 60 ！")
    private String keys;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "顺序")
    private Integer serialNumber;

    @ApiModelProperty(value = "描述")
    private String description;

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

    @ApiModelProperty(value = "子菜单集合")
    private List<MenuInfoVo> menuInfoList;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

    public static final String ID = "id";

    public static final String MENU_CODE = "menu_code";

    public static final String MENU_NAME = "menu_name";

    public static final String ICON = "icon";

    public static final String MENU_TYPE = "menu_type";

    public static final String OPEN_TYPE = "open_type";

    public static final String PATH = "path";

    public static final String IS_OUTSIDE_URL = "is_outside_url";

    public static final String STATUS = "status";

    public static final String KEYS = "keys";

    public static final String PARENT_ID = "parent_id";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String DESCRIPTION = "description";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    public static final String TENANT_ID = "tenant_id";


}
