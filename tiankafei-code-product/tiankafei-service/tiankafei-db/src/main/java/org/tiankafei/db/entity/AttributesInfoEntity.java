package org.tiankafei.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "属性名称")
    @Size(max = 100, message = "属性名称长度不能超过 100 ！")
    @TableField("name")
    private String name;

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

    @ApiModelProperty(value = "是否新增属性（1是）")
    @Size(max = 1, message = "是否新增属性（1是）长度不能超过 1 ！")
    @TableField("is_insert_property")
    private String isInsertProperty;

    @ApiModelProperty(value = "是否编辑属性（1是）")
    @Size(max = 1, message = "是否编辑属性（1是）长度不能超过 1 ！")
    @TableField("is_edit_property")
    private String isEditProperty;

    @ApiModelProperty(value = "是否列表属性（1是）")
    @Size(max = 1, message = "是否列表属性（1是）长度不能超过 1 ！")
    @TableField("is_list_property")
    private String isListProperty;

    @ApiModelProperty(value = "是否查询属性（1是）")
    @Size(max = 1, message = "是否查询属性（1是）长度不能超过 1 ！")
    @TableField("is_query_property")
    private String isQueryProperty;

    @ApiModelProperty(value = "是否默认查询属性（1是）")
    @Size(max = 1, message = "是否默认查询属性（1是）长度不能超过 1 ！")
    @TableField("is_default_query_property")
    private String isDefaultQueryProperty;

    @ApiModelProperty(value = "查询方式（等于、不等于、大于、小于、范围）")
    @Size(max = 200, message = "查询方式（等于、不等于、大于、小于、范围）长度不能超过 200 ！")
    @TableField("query_type")
    private String queryType;

    @ApiModelProperty(value = "填写类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    @Size(max = 200, message = "填写类型（文本框、文本域、下拉框、复选框、单选框、日期控件）长度不能超过 200 ！")
    @TableField("fill_type")
    private String fillType;

    @ApiModelProperty(value = "查询类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    @Size(max = 200, message = "查询类型（文本框、文本域、下拉框、复选框、单选框、日期控件）长度不能超过 200 ！")
    @TableField("search_type")
    private String searchType;

    @ApiModelProperty(value = "数据来源：1:json，2:url，3字典")
    @Size(max = 1, message = "数据来源：1:json，2:url，3字典长度不能超过 1 ！")
    @TableField("data_source")
    private String dataSource;

    @ApiModelProperty(value = "数据来源为json的数据结构")
    @TableField("data_structure")
    private String dataStructure;

    @ApiModelProperty(value = "数据来原为url")
    @Size(max = 100, message = "数据来原为url长度不能超过 100 ！")
    @TableField("data_url")
    private String dataUrl;

    @ApiModelProperty(value = "数据原来为字典的字典类型")
    @Size(max = 200, message = "数据原来为字典的字典类型长度不能超过 200 ！")
    @TableField("dict_type")
    private String dictType;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @Size(max = 1, message = "删除标志（0代表存在 2代表删除）长度不能超过 1 ！")
    @TableField("del_flag")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    @Size(max = 64, message = "创建者长度不能超过 64 ！")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "更新者")
    @Size(max = 64, message = "更新者长度不能超过 64 ！")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "备注")
    @Size(max = 500, message = "备注长度不能超过 500 ！")
    @TableField("remark")
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
