package org.tiankafei.elasticsearch.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * @author 甜咖啡
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DatasourceEntity 对象", description = "数据源实体对象")
public class DatasourceEntity extends Model<DatasourceEntity> {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 30, message = "昵称，中文名长度不能超过 30 ！")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    private String telephone;

    @ApiModelProperty(value = "性别：1男，2女，3未知")
    @Size(max = 1, message = "性别：1男，2女，3未知长度不能超过 1 ！")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    private Timestamp bornTime;

    @ApiModelProperty(value = "用户头像")
    @Size(max = 100, message = "用户头像长度不能超过 100 ！")
    private String avatar;

    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    private String remark;

    @ApiModelProperty(value = "用户类型")
    @Size(max = 2, message = "用户类型长度不能超过 2 ！")
    private String userType;

    @ApiModelProperty(value = "部门id")
    private Integer deptId;

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

}
