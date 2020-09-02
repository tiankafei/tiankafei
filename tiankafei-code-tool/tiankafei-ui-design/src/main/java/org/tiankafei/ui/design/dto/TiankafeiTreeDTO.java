package org.tiankafei.ui.design.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.base.dto.CodeNameDTO;

/**
 * 树节点对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class TiankafeiTreeDTO extends CodeNameDTO {

    private static final long serialVersionUID = -2921218542559302923L;

    /**
     * 树节点对象集合
     */
    private List<TiankafeiTreeDTO> tiankafeiTreeList;

    /**
     * 节点对象
     */
    private Object userObject;

    /**
     * 节点是否展开的标识
     */
    private Boolean expandPathFlag;

    /**
     * 节点图标路径
     */
    private String nodeIconFilePath;

    /**
     * 节点图标宽度
     */
    private Integer nodeIconWidth;

    /**
     * 节点图标高度
     */
    private Integer nodeIconHeight;

    /**
     * 显示名称
     */
    private String name;

    /**
     * 构造树对象
     */
    public TiankafeiTreeDTO() {
        expandPathFlag = false;
        nodeIconWidth = 26;
        nodeIconHeight = 26;
    }

    @Override
    public String toString() {
        return name;
    }

}
