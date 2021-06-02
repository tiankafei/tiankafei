package org.tiankafei.rule.vo;

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
 * 规则中用到的数据的别名
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "RuleDataAliasEntity对象", description = "规则中用到的数据的别名")
public class RuleDataAliasVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "数据集的唯一标识符")
    @Size(max = 64, message = "数据集的唯一标识符长度不能超过 64 ！")
    private String datasetUniqueIdentifier;

    @ApiModelProperty(value = "数据的别名")
    @Size(max = 30, message = "数据的别名长度不能超过 30 ！")
    private String aliasName;

    @ApiModelProperty(value = "来源的数据集唯一标识符")
    @Size(max = 64, message = "来源的数据集唯一标识符长度不能超过 64 ！")
    private String sourceDatasetUniqueIdentifier;

    @ApiModelProperty(value = "来源的数据唯一标识符")
    @Size(max = 64, message = "来源的数据唯一标识符长度不能超过 64 ！")
    private String sourceDataUniqueIdentifier;

    @ApiModelProperty(value = "行的唯一标识")
    @Size(max = 64, message = "行的唯一标识长度不能超过 64 ！")
    private String rowUniqueIdentifier;

    @ApiModelProperty(value = "列的唯一标识")
    @Size(max = 64, message = "列的唯一标识长度不能超过 64 ！")
    private String colUniqueIdentifier;

    @ApiModelProperty(value = "二维挂目录时的目录id")
    @Size(max = 64, message = "二维挂目录时的目录id长度不能超过 64 ！")
    private String catalogId;

    @ApiModelProperty(value = "二维挂目录时的目录项id")
    @Size(max = 64, message = "二维挂目录时的目录项id长度不能超过 64 ！")
    private String catalogItem;

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


    public static final String ID = "id";

    public static final String DATASET_UNIQUE_IDENTIFIER = "dataset_unique_identifier";

    public static final String ALIAS_NAME = "alias_name";

    public static final String SOURCE_DATASET_UNIQUE_IDENTIFIER = "source_dataset_unique_identifier";

    public static final String SOURCE_DATA_UNIQUE_IDENTIFIER = "source_data_unique_identifier";

    public static final String ROW_UNIQUE_IDENTIFIER = "row_unique_identifier";

    public static final String COL_UNIQUE_IDENTIFIER = "col_unique_identifier";

    public static final String CATALOG_ID = "catalog_id";

    public static final String CATALOG_ITEM = "catalog_item";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";


}
