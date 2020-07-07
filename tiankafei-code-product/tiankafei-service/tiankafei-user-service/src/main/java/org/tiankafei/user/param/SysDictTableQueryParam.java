package org.tiankafei.user.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <pre>
 * 系统数据字典的数据表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统数据字典的数据表 查询参数对象", description = "系统数据字典的数据表查询参数")
public class SysDictTableQueryParam implements Serializable {

    /**
     * 数据表
     */
    @ApiModelProperty(value = "数据表")
    @Size(max = 30, message = "数据表长度不能超过 30 ！")
    @NotBlank(message = "字典数据表不能为空！")
    private String dataTable;

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    @Size(max = 100, message = "代码长度不能超过 100 ！")
    private String code;

}
