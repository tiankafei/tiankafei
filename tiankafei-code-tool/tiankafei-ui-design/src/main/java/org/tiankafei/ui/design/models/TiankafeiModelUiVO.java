package org.tiankafei.ui.design.models;

import java.io.Serializable;

/**
 * 自定义控件模型UI对象
 *
 * @author tiankafei1
 */
public class TiankafeiModelUiVO implements Serializable {

    private static final long serialVersionUID = -3636468709694141303L;

    /**
     * 参数对象
     */
    private Object paramObject;

    /**
     * 参数代码
     */
    private String paramCode;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 构造自定义控件模型UI对象
     */
    public TiankafeiModelUiVO() {

    }

    /**
     * 获取参数对象
     *
     * @return 参数对象
     */
    public Object getParamObject() {
        return paramObject;
    }

    /**
     * 设置参数对象
     *
     * @param paramObject 参数对象
     */
    public void setParamObject(Object paramObject) {
        this.paramObject = paramObject;
    }

    /**
     * 获取参数代码
     *
     * @return 参数代码
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * 设置参数代码
     *
     * @param paramCode 参数代码
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    /**
     * 获取参数名称
     *
     * @return 参数名称
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置参数名称
     *
     * @param paramName 参数名称
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
