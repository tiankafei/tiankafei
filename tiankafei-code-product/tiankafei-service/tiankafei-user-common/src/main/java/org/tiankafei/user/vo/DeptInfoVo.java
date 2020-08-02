package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <p>
 * 系统部门表信息
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DeptInfoEntity对象", description = "系统部门表信息")
public class DeptInfoVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门代码")
    @Size(max = 20, message = "部门代码长度不能超过 20 ！")
    private String deptCode;

    @ApiModelProperty(value = "部门名称")
    @Size(max = 100, message = "部门名称长度不能超过 100 ！")
    private String deptName;

    @ApiModelProperty(value = "父部门")
    private Integer parentId;

    @ApiModelProperty(value = "序号")
    private Integer serialNumber;

    @ApiModelProperty(value = "当前部门所处的层级(在第几级)")
    private Integer level;

    @ApiModelProperty(value = "部门职责")
    private String description;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "部门创建用户ID")
    private Long createUserId;

    @ApiModelProperty(value = "部门修改用户ID")
    private Long updateUserId;


    public static final String ID = "id";

    public static final String DEPT_CODE = "dept_code";

    public static final String DEPT_NAME = "dept_name";

    public static final String PARENT_ID = "parent_id";

    public static final String SERIAL_NUMBER = "serial_number";

    public static final String LEVEL = "level";

    public static final String DESCRIPTION = "description";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";


}
