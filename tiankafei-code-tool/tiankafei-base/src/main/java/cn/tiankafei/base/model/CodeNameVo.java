package cn.tiankafei.base.model;

import cn.tiankafei.base.enums.BaseEnums;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 代码名称视图模型
 *
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class CodeNameVo implements Serializable {

    private static final long serialVersionUID = 1881024252185440694L;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 显示类型
     */
    private Integer viewType;

    /**
     * 分割符
     */
    private String separator;

    /**
     * 构造代码名称值对象类
     */
    public CodeNameVo() {
        viewType = BaseEnums.VIEW_NAME.getCode();
        separator = "    ";
    }

    public CodeNameVo(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        if (BaseEnums.VIEW_CODE.getCode() == getViewType()) {
            buffer.append(code);
        } else if (BaseEnums.VIEW_NAME.getCode() == getViewType()) {
            buffer.append(name);
        } else if (BaseEnums.VIEW_CODE_NAME.getCode() == getViewType()) {
            buffer.append(code).append(getSeparator()).append(name);
        } else if (BaseEnums.VIEW_NAME_CODE.getCode() == getViewType()) {
            buffer.append(name).append(getSeparator()).append(code);
        } else {
            //默认显示名称
            buffer.append(name);
        }
        return buffer.toString();
    }

}
