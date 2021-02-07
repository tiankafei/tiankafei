package org.tiankafei.db.vo;

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
 * 功能的属性注册表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "AttributesInfoEntity对象", description = "功能的属性注册表")
public class AttributesInfoVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    private String featuresCode;

    @ApiModelProperty(value = "属性代码")
    @Size(max = 20, message = "属性代码长度不能超过 20 ！")
    private String attributesCode;

    @ApiModelProperty(value = "属性名称")
    @Size(max = 100, message = "属性名称长度不能超过 100 ！")
    private String attributesName;

    @ApiModelProperty(value = "数据类型")
    @Size(max = 3, message = "数据类型长度不能超过 3 ！")
    private String dataType;

    @ApiModelProperty(value = "数据长度")
    private Integer dataLength;

    @ApiModelProperty(value = "数据精度")
    private Integer dataPrecision;

    @ApiModelProperty(value = "是否允许为空")
    private Boolean isNull;

    @ApiModelProperty(value = "默认值")
    @Size(max = 20, message = "默认值长度不能超过 20 ！")
    private String defaultValue;

    @ApiModelProperty(value = "功能描述")
    private String description;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @Size(max = 1, message = "删除标志（0代表存在 2代表删除）长度不能超过 1 ！")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    @Size(max = 64, message = "创建者长度不能超过 64 ！")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "更新者")
    @Size(max = 64, message = "更新者长度不能超过 64 ！")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "备注")
    @Size(max = 500, message = "备注长度不能超过 500 ！")
    private String remark;


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

    public static final String DEL_FLAG = "del_flag";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String REMARK = "remark";


}
