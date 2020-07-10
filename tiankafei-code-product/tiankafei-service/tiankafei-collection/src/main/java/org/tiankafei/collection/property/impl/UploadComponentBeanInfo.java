package org.tiankafei.collection.property.impl;

import org.tiankafei.base.base.model.CodeNameVo;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.RegularExpressionVo;
import org.tiankafei.collection.property.UploadComponentProperty;

import java.util.List;

/**
 * 上传组件的属性对象
 *
 * @author tiankafei
 * @since 1.0
 */
public class UploadComponentBeanInfo extends BaseComponentProperty implements UploadComponentProperty {

    /**
     * 字段名
     */
    protected String fieldName;

    /**
     * 标签名
     */
    protected String labelName;

    /**
     * 表单栅格
     */
    protected Integer formGrid;

    /**
     * 标签宽度
     */
    protected Integer labelWidth;

    /**
     * 组件宽度
     */
    protected Double componentWidth;

    /**
     * 默认值
     */
    protected Object defaultValue;

    /**
     * 文件字段名
     */
    protected String fileFieldName;

    /**
     * 文件类型
     */
    protected String fileType;

    /**
     * 上传地址
     */
    protected String uploadAddress;

    /**
     * 列表类型
     */
    protected String listType;

    /**
     * 是否显示标签
     */
    protected Boolean showLabel;

    /**
     * 自动上传
     */
    protected Boolean autoUpload;

    /**
     * 能否清空
     */
    protected Boolean clearable;

    /**
     * 是否禁用
     */
    protected Boolean disabled;

    /**
     * 是否可以多选
     */
    protected Boolean multipleChoice;

    /**
     * 是否必填
     */
    protected Boolean required;

    /**
     * 正则表达式集合
     */
    protected List<RegularExpressionVo> regularExpressionVoList;

    @Override
    public Integer getComponentType() {
        return ComponentTypeEnum.UPLOAD.getCode();
    }
}
