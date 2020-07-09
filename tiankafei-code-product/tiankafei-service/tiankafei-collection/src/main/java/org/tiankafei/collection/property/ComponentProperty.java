package org.tiankafei.collection.property;

public interface ComponentProperty {

    /**
     * 获取组件类型
     * @return
     */
    Integer getComponentType();

    /**
     * 设置字段名
     * @param fieldName
     */
    void setFieldName(String fieldName);

    /**
     * 设置标签名
     * @param labelName
     */
    void setLabelName(String labelName);

}
