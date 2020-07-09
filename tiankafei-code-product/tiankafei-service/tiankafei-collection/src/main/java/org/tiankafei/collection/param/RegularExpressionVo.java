package org.tiankafei.collection.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 正则表达式对象
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
public class RegularExpressionVo implements Serializable {

    /**
     * 表达式
     */
    private String expression;

    /**
     * 提示信息
     */
    private String message;

}
