package org.tiankafei.base.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.base.enums.DictEnum;

/**
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class CommonDTO implements Serializable {

    private static final long serialVersionUID = -6782850469178984340L;

    /**
     * id唯一标识
     */
    private String id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态代码
     */
    private String statusCode;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 用户所属公司代码
     */
    private String companyCode;

    /**
     * 用户所属公司名称
     */
    private String companyName;

    /**
     * 用户所属组织机构代码
     */
    private String organizationCode;

    /**
     * 用户所属组织机构名称
     */
    private String organizationName;

    /**
     * 创建人
     */
    private String createUsername;

    /**
     * 创建人中文名
     */
    private String createChineseName;

    /**
     * 修改人
     */
    private String modifyUsername;

    /**
     * 修改人中文名
     */
    private String modifyChineseName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp modifyTime;

    /**
     * 修改标识
     */
    private String modifyMark;

    /**
     * 删除标识
     */
    private String deleteMark;

    /**
     * 父节点id
     */
    private String parentId;

    /**
     * 子节点集合
     */
    private List<CommonDTO> children;

    public CommonDTO() {
        modifyMark = DictEnum.YES.getCode();
        deleteMark = DictEnum.YES.getCode();
    }

}
