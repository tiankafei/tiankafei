package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <pre>
 * 系统数据字典的数据表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统数据字典的数据表 对象", description = "系统数据字典的数据表 查询参数")
public class DictTableVo extends BaseQueryVo {

    /**
     * 数据表
     */
    @ApiModelProperty(value = "数据表")
    @Size(max = 30, message = "数据表长度不能超过 30 ！")
    @NotBlank(message = "字典数据表不能为空！")
    private String dataTable;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @Size(max = 20, message = "主键id长度不能超过 20 ！")
    private String id;

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    @NotBlank(message = "代码不能为空")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 500, message = "名称长度不能超过 500 ！")
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    private String remarks;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    @Size(max = 20, message = "父id长度不能超过 20 ！")
    private String parentId;

    /**
     * 所有父id，用逗号分隔
     */
    @ApiModelProperty(value = "所有父id，用逗号分隔")
    @Size(max = 2100, message = "所有父id，用逗号分隔长度不能超过 2100 ！")
    private String allParentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    private Integer serialNumber;

    /**
     * 所在层级
     */
    @ApiModelProperty(value = "所在层级")
    private Integer level;

    /**
     * 计量单位1
     */
    @ApiModelProperty(value = "计量单位1")
    @Size(max = 10, message = "计量单位1长度不能超过 10 ！")
    private String unit1;

    /**
     * 计量单位2
     */
    @ApiModelProperty(value = "计量单位2")
    @Size(max = 10, message = "计量单位2长度不能超过 10 ！")
    private String unit2;

    /**
     * 计量单位3
     */
    @ApiModelProperty(value = "计量单位3")
    @Size(max = 10, message = "计量单位3长度不能超过 10 ！")
    private String unit3;

    /**
     * 计量单位4
     */
    @ApiModelProperty(value = "计量单位4")
    @Size(max = 10, message = "计量单位4长度不能超过 10 ！")
    private String unit4;

    /**
     * 计量单位5
     */
    @ApiModelProperty(value = "计量单位5")
    @Size(max = 10, message = "计量单位5长度不能超过 10 ！")
    private String unit5;

    /**
     * 计量单位6
     */
    @ApiModelProperty(value = "计量单位6")
    @Size(max = 10, message = "计量单位6长度不能超过 10 ！")
    private String unit6;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;

}