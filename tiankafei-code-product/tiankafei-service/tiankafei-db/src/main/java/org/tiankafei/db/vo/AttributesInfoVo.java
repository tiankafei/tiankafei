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
    private String code;

    @ApiModelProperty(value = "属性名称")
    @Size(max = 100, message = "属性名称长度不能超过 100 ！")
    private String name;

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

    @ApiModelProperty(value = "是否新增属性（1是）")
    @Size(max = 1, message = "是否新增属性（1是）长度不能超过 1 ！")
    private String isInsertProperty;

    @ApiModelProperty(value = "是否编辑属性（1是）")
    @Size(max = 1, message = "是否编辑属性（1是）长度不能超过 1 ！")
    private String isEditProperty;

    @ApiModelProperty(value = "是否列表属性（1是）")
    @Size(max = 1, message = "是否列表属性（1是）长度不能超过 1 ！")
    private String isListProperty;

    @ApiModelProperty(value = "是否查询属性（1是）")
    @Size(max = 1, message = "是否查询属性（1是）长度不能超过 1 ！")
    private String isQueryProperty;

    @ApiModelProperty(value = "是否默认查询属性（1是）")
    @Size(max = 1, message = "是否默认查询属性（1是）长度不能超过 1 ！")
    private String isDefaultQueryProperty;

    @ApiModelProperty(value = "查询方式（等于、不等于、大于、小于、范围）")
    @Size(max = 2, message = "查询方式（等于、不等于、大于、小于、范围）长度不能超过 2 ！")
    private String queryType;

    @ApiModelProperty(value = "填写类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    @Size(max = 2, message = "填写类型（文本框、文本域、下拉框、复选框、单选框、日期控件）长度不能超过 2 ！")
    private String fillType;

    @ApiModelProperty(value = "查询类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    @Size(max = 2, message = "查询类型（文本框、文本域、下拉框、复选框、单选框、日期控件）长度不能超过 2 ！")
    private String searchType;

    @ApiModelProperty(value = "数据来源：1:json，2:url，3字典")
    @Size(max = 1, message = "数据来源：1:json，2:url，3字典长度不能超过 1 ！")
    private String dataSource;

    @ApiModelProperty(value = "数据来源为json的数据结构")
    private String dataStructure;

    @ApiModelProperty(value = "数据来原为url")
    @Size(max = 100, message = "数据来原为url长度不能超过 100 ！")
    private String dataUrl;

    @ApiModelProperty(value = "数据原来为字典的字典类型")
    @Size(max = 50, message = "数据原来为字典的字典类型长度不能超过 50 ！")
    private String dictType;

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

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String DATA_TYPE = "data_type";

    public static final String DATA_LENGTH = "data_length";

    public static final String DATA_PRECISION = "data_precision";

    public static final String IS_NULL = "is_null";

    public static final String DEFAULT_VALUE = "default_value";

    public static final String IS_INSERT_PROPERTY = "is_insert_property";

    public static final String IS_EDIT_PROPERTY = "is_edit_property";

    public static final String IS_LIST_PROPERTY = "is_list_property";

    public static final String IS_QUERY_PROPERTY = "is_query_property";

    public static final String IS_DEFAULT_QUERY_PROPERTY = "is_default_query_property";

    public static final String QUERY_TYPE = "query_type";

    public static final String FILL_TYPE = "fill_type";

    public static final String SEARCH_TYPE = "search_type";

    public static final String DATA_SOURCE = "data_source";

    public static final String DATA_STRUCTURE = "data_structure";

    public static final String DATA_URL = "data_url";

    public static final String DICT_TYPE = "dict_type";

    public static final String DEL_FLAG = "del_flag";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String REMARK = "remark";


}
