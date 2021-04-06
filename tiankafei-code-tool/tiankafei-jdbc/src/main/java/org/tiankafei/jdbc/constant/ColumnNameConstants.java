package org.tiankafei.jdbc.constant;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tiankafei.common.dto.CodeNameDTO;

/**
 * 物理表字段常量类
 *
 * @author 甜咖啡
 */
public class ColumnNameConstants {

    /**
     * 主键ID字段
     */
    public static final String COLUMN_ID = "ID";

    /**
     * 数据库类型
     */
    public static final String COLUMN_DB_TYPE = "DB_TYPE";

    /**
     * 数据库类型名称
     */
    public static final String COLUMN_DB_TYPE_NAME = "DB_TYPE_NAME";

    /**
     * 数据库名称
     */
    public static final String COLUMN_DB_NAME = "DB_NAME";

    /**
     * 物理表类型
     */
    public static final String COLUMN_TABLE_TYPE = "TABLE_TYPE";

    /**
     * 物理表类型
     */
    public static final String COLUMN_TABLE_TYPE_NAME = "TABLE_TYPE_NAME";

    /**
     * 表名字段
     */
    public static final String COLUMN_TABLE_NAME = "TABLE_NAME";

    /**
     * 字段名字段
     */
    public static final String COLUMN_COLUMN_NAME = "COLUMN_NAME";

    /**
     * 用户名字段
     */
    public static final String COLUMN_USERNAME = "USERNAME";

    /**
     * 用户名类型
     */
    public static final String COLUMN_USER_TYPE = "USER_TYPE";

    /**
     * 用户名类型名称
     */
    public static final String COLUMN_USER_TYPE_NAME = "USER_TYPE_NAME";

    /**
     * 用户中文名
     */
    public static final String COLUMN_USER_CHINESE_NAME = "USER_CHINESE_NAME";

    /**
     * 创建人字段
     */
    public static final String COLUMN_CREATE_USERNAME = "CREATE_USERNAME";

    /**
     * 创建人中文名字段
     */
    public static final String COLUMN_CREATE_CHINESE_NAME = "CREATE_CHINESE_NAME";

    /**
     * 创建时间字段
     */
    public static final String COLUMN_CREATE_TIME = "CREATE_TIME";

    /**
     * 公司代码
     */
    public static final String COLUMN_COMPANY_CODE = "COMPANY_CODE";

    /**
     * 公司名称
     */
    public static final String COLUMN_COMPANY_NAME = "COMPANY_NAME";

    /**
     * 组织机构层级代码
     */
    public static final String COLUMN_ORGANIZATION_CODE = "ORGANIZATION_CODE";

    /**
     * 组织机构层级名称
     */
    public static final String COLUMN_ORGANIZATION_NAME = "ORGANIZATION_NAME";

    /**
     * 状态代码
     */
    public static final String COLUMN_STATUS_CODE = "STATUS_CODE";

    /**
     * 状态名称
     */
    public static final String COLUMN_STATUS_NAME = "STATUS_NAME";

    /**
     * 审批人
     */
    public static final String COLUMN_APPROVAL_USERNAME = "APPROVAL_USERNAME";

    /**
     * 审批人中文名
     */
    public static final String COLUMN_APPROVAL_CHINESENAME = "APPROVAL_CHINESENAME";

    /**
     * 审批时间
     */
    public static final String COLUMN_APPROVAL_TIME = "APPROVAL_TIME";

    /**
     * 审批意见
     */
    public static final String COLUMN_APPROVAL_DESCRIPTION = "APPROVAL_DESCRIPTION";

    /**
     * 修改人字段
     */
    public static final String COLUMN_MODIFY_USERNAME = "MODIFY_USERNAME";

    /**
     * 修改人中文名字段
     */
    public static final String COLUMN_MODIFY_CHINESE_NAME = "MODIFY_CHINESE_NAME";

    /**
     * 修改时间字段
     */
    public static final String COLUMN_MODIFY_TIME = "MODIFY_TIME";

    /**
     * 描述字段
     */
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    /**
     * 功能代码字段
     */
    public static final String COLUMN_FEATURES_CODE = "FEATURES_CODE";

    /**
     * 功能名称字段
     */
    public static final String COLUMN_FEATURES_NAME = "FEATURES_NAME";

    /**
     * 功能表名字段
     */
    public static final String COLUMN_FEATURES_TABLE_NAME = "FEATURES_TABLE_NAME";

    /**
     * 序号字段
     */
    public static final String COLUMN_SERIAL_NUMBER = "SERIAL_NUMBER";

    /**
     * 代码字段
     */
    public static final String COLUMN_CODE = "CODE";

    /**
     * 名称字段
     */
    public static final String COLUMN_NAME = "NAME";

    /**
     * 计量单位代码字段
     */
    public static final String COLUMN_UNIT_CODE = "UNIT_CODE";

    /**
     * 计量单位名称字段
     */
    public static final String COLUMN_UNIT_NAME = "UNIT_NAME";

    /**
     * 计量单位分类代码字段
     */
    public static final String COLUMN_UNIT_KIND_CODE = "UNIT_KIND_CODE";

    /**
     * 计量单位分类名称字段
     */
    public static final String COLUMN_UNIT_KIND_NAME = "UNIT_KIND_NAME";

    /**
     * 汇总计量单位代码字段
     */
    public static final String COLUMN_COLLECT_UNIT_CODE = "COLLECT_UNIT_CODE";

    /**
     * 汇总计量单位名称字段
     */
    public static final String COLUMN_COLLECT_UNIT_NAME = "COLLECT_UNIT_NAME";

    /**
     * 汇总计量单位分类代码字段
     */
    public static final String COLUMN_COLLECT_UNIT_KIND_CODE = "COLLECT_UNIT_KIND_CODE";

    /**
     * 汇总计量单位分类名称字段
     */
    public static final String COLUMN_COLLECT_UNIT_KIND_NAME = "COLLECT_UNIT_KIND_NAME";

    /**
     * 版本字段
     */
    public static final String COLUMN_VERSION = "VERSION";

    /**
     * 删除标识代码
     */
    public static final String COLUMN_DELETE_MARK = "DELETE_MARK";

    /**
     * 修改标识代码
     */
    public static final String COLUMN_MODIFY_MARK = "MODIFY_MARK";

    /**
     * 角色代码
     */
    public static final String COLUMN_ROLE_CODE = "ROLE_CODE";

    /**
     * 角色名称
     */
    public static final String COLUMN_ROLE_NAME = "ROLE_NAME";

    /**
     * 部门代码
     */
    public static final String COLUMN_DEPARTMENT_CODE = "DEPARTMENT_CODE";

    /**
     * 部门名称
     */
    public static final String COLUMN_DEPARTMENT_NAME = "DEPARTMENT_NAME";

    /**
     * 业务清单代码
     */
    public static final String COLUMN_BUSINESS_CODE = "BUSINESS_CODE";

    /**
     * 业务清单名称
     */
    public static final String COLUMN_BUSINESS_NAME = "BUSINESS_NAME";

    /**
     * 父节点ID
     */
    public static final String COLUMN_PARENT_ID = "PARENT_ID";

    /**
     * 层级
     */
    public static final String COLUMN_LEVEL_NUMBER = "LEVEL_NUMBER";

    /**
     * 电子邮件
     */
    public static final String COLUMN_EMAIL = "EMAIL";

    /**
     * 手机号码
     */
    public static final String COLUMN_MOBILEPHONE = "MOBILEPHONE";

    /**
     * 密码
     */
    public static final String COLUMN_PASSWORD = "PASSWORD";

    /**
     * 字段中文名
     */
    public static final String COLUMN_CHINESE_NAME = "CHINESE_NAME";

    /**
     * 字段类型
     */
    public static final String COLUMN_COLUMN_TYPE = "COLUMN_TYPE";

    /**
     * 字段类型
     */
    public static final String COLUMN_COLUMN_TYPE_NAME = "COLUMN_TYPE_NAME";

    /**
     * 字段最大长度
     */
    public static final String COLUMN_MAX_LENGTH = "MAX_LENGTH";

    /**
     * 字段最小长度
     */
    public static final String COLUMN_MIN_LENGTH = "MIN_LENGTH";

    /**
     * 字段精度
     */
    public static final String COLUMN_DATA_PRECISION = "DATA_PRECISION";

    /**
     * 是否为空
     */
    public static final String COLUMN_IS_NULL = "IS_NULL";

    /**
     * 是否主键
     */
    public static final String COLUMN_PRIMARY_KEY = "PRIMARY_KEY";

    /**
     * 字段默认值
     */
    public static final String COLUMN_DEFAULT_VALUE = "DEFAULT_VALUE";

    /**
     * 消息类型
     */
    public static final String COLUMN_MESSAGE_TYPE = "MESSAGE_TYPE";

    /**
     * 消息名称
     */
    public static final String COLUMN_MESSAGE_TYPE_NAME = "MESSAGE_TYPE_NAME";

    /**
     * 消息处理类型
     */
    public static final String COLUMN_MESSAGE_PROCESS_TYPE = "PROCESS_TYPE";

    /**
     * 消息处理名称
     */
    public static final String COLUMN_MESSAGE_PROCESS_TYPE_NAME = "PROCESS_TYPE_NAME";

    /**
     * 消息是否已读或已下载
     */
    public static final String COLUMN_MESSAGE_READ_OR_DOWNLOAD = "MESSAGE_READ_OR_DOWNLOAD";

    /**
     * 开始时间
     */
    public static final String COLUMN_START_TIME = "START_TIME";

    /**
     * 结束时间
     */
    public static final String COLUMN_END_TIME = "END_TIME";

    /**
     * 操作类型
     */
    public static final String COLUMN_OPERATE_TYPE = "OPERATE_TYPE";

    /**
     * 操作名称
     */
    public static final String COLUMN_OPERATE_TYPE_NAME = "OPERATE_TYPE_NAME";

    /**
     * sql文本
     */
    public static final String COLUMN_SQL_TEXT = "SQL_TEXT";

    /**
     * json文本
     */
    public static final String COLUMN_JSON_TEXT = "JSON_TEXT";

    /**
     * 参数名称
     */
    public static final String COLUMN_PARAM_NAME = "PARAM_NAME";

    /**
     * 参数值
     */
    public static final String COLUMN_PARAM_VALUE = "PARAM_VALUE";

    /**
     * 允许值域
     */
    public static final String COLUMN_VALUE_AREA = "VALUE_AREA";

    /**
     * 物理表注释
     */
    public static final String COLUMN_TABLE_COMMENTS = "TABLE_COMMENTS";

    /**
     * 图标路径
     */
    public static final String COLUMN_ICON_PATH = "ICON_PATH";

    /**
     * 是否中间节点
     */
    public static final String COLUMN_MIDDLE_NODE = "MIDDLE_NODE";

    /**
     * url
     */
    public static final String COLUMN_URL = "URL";

    /**
     * 参数
     */
    public static final String COLUMN_PARAM = "PARAM";

    /**
     * 目录用途代码
     */
    public static final String COLUMN_CATALOG_USE_CODE = "CATALOG_USE_CODE";

    /**
     * 目录用途名称
     */
    public static final String COLUMN_CATALOG_USE_NAME = "CATALOG_USE_NAME";

    /**
     * 是否分页
     */
    public static final String COLUMN_PAGE_FLAG = "PAGE_FLAG";

    /**
     * 是否需要计量单位
     */
    public static final String COLUMN_UNIT_FLAG = "UNIT_FLAG";

    /**
     * 电子邮件激活状态
     */
    public static final String COLUMN_EMAIL_STATUS = "EMAIL_STATUS";

    /**
     * 手机激活状态
     */
    public static final String COLUMN_MOBILEPHONE_STATUS = "MOBILEPHONE_STATUS";

    /**
     * 标签名称
     */
    public static final String COLUMN_LABEL_NAME = "LABEL_NAME";

    /**
     * 控件类型
     */
    public static final String COLUMN_CONTROLS_TYPE = "CONTROLS_TYPE";

    /**
     * 控件类型名称
     */
    public static final String COLUMN_CONTROLS_TYPE_NAME = "CONTROLS_TYPE_NAME";

    /**
     * 控件的允许值域是目录id
     */
    public static final String COLUMN_CONTROLS_CATALOG_ID = "CONTROLS_CATALOG_ID";

    /**
     * 控件日期格式
     */
    public static final String COLUMN_CONTROLS_DATE_FORMAT = "CONTROLS_DATE_FORMAT";

    /**
     * 数据类型
     */
    public static final String COLUMN_DATA_TYPE = "DATA_TYPE";

    /**
     * 数据类型名称
     */
    public static final String COLUMN_DATA_TYPE_NAME = "DATA_TYPE_NAME";

    /**
     * 新增页面是否隐藏
     */
    public static final String COLUMN_ADD_HIDDEN = "ADD_HIDDEN";

    /**
     * 新增页面是否可编辑
     */
    public static final String COLUMN_ADD_EDITABLE = "ADD_EDITABLE";

    /**
     * 编辑页面是否隐藏
     */
    public static final String COLUMN_EDIT_HIDDEN = "EDIT_HIDDEN";

    /**
     * 编辑页面是否可编辑
     */
    public static final String COLUMN_EDIT_EDITABLE = "EDIT_EDITABLE";

    /**
     * 标题
     */
    public static final String COLUMN_TITLE = "TITLE";

    /**
     * 列宽
     */
    public static final String COLUMN_WIDTH = "WIDTH";

    /**
     * 最大列宽
     */
    public static final String COLUMN_MAX_WIDTH = "MAX_WIDTH";

    /**
     * 最小列宽
     */
    public static final String COLUMN_MIN_WIDTH = "MIN_WIDTH";

    /**
     * 是否做为搜索条件
     */
    public static final String COLUMN_SEARCH = "SEARCH";

    /**
     * 是否默认搜索条件
     */
    public static final String COLUMN_DEFAULT_SEARCH = "DEFAULT_SEARCH";

    /**
     * 列表页面是否隐藏
     */
    public static final String COLUMN_HIDDEN = "COLUMN_HIDDEN";

    /**
     * 列表页面是否可编辑
     */
    public static final String COLUMN_EDITABLE = "COLUMN_EDITABLE";

    /**
     * 功能id
     */
    public static final String COLUMN_FUNCTION_ID = "FUNCTION_ID";

    /**
     * 功能名称
     */
    public static final String COLUMN_FUNCTION_NAME = "FUNCTION_NAME";

    /**
     * 日志大字段
     */
    public static final String COLUMN_LOG = "LOG";


    /**
     * 字段类型(char类型)
     */
    public static final int COLUMN_TYPE_CHAR = 10;
    public static final String COLUMN_TYPE_CHAR_NAME = "char";

    /**
     * 字段类型(varchar类型)
     */
    public static final int COLUMN_TYPE_VARCHAR = 20;
    public static final String COLUMN_TYPE_VARCHAR_NAME = "varchar";

    /**
     * 字段类型(integer类型)
     */
    public static final int COLUMN_TYPE_INTEGER = 30;
    public static final String COLUMN_TYPE_INTEGER_NAME = "integer";

    /**
     * 字段类型(number类型)
     */
    public static final int COLUMN_TYPE_NUMBER = 40;
    public static final String COLUMN_TYPE_NUMBER_NAME = "number";

    /**
     * 字段类型(timestamp类型)
     */
    public static final int COLUMN_TYPE_TIMESTAMP = 50;
    public static final String COLUMN_TYPE_TIMESTAMP_NAME = "timestamp";

    /**
     * 字段类型(clob,text类型)
     */
    public static final int COLUMN_TYPE_CLOB = 60;
    public static final String COLUMN_TYPE_CLOB_NAME = "clob或text";

    /**
     * 字段类型(blob类型)
     */
    public static final int COLUMN_TYPE_BLOB = 70;
    public static final String COLUMN_TYPE_BLOB_NAME = "blob";

    /**
     * 获取字段类型名称
     *
     * @param columnType 字段类型
     * @return 字段类型名称
     */
    public static String getColumnTypeName(int columnType) {
        Map<String, CodeNameDTO> codeNameDtoMap = getColumnTypeMap();
        CodeNameDTO CodeNameDTO = codeNameDtoMap.get(String.valueOf(columnType));
        return CodeNameDTO.getName();
    }

    /**
     * 获取字段类型列表
     *
     * @return 字段类型列表
     */
    public static Map<String, CodeNameDTO> getColumnTypeMap() {
        List<CodeNameDTO> codeNameDtoList = getColumnTypeList();
        int length = codeNameDtoList.size();

        Map<String, CodeNameDTO> codeNameDtoMap = new HashMap<String, CodeNameDTO>(length);
        for (int index = 0; index < length; index++) {
            CodeNameDTO CodeNameDTO = codeNameDtoList.get(index);
            codeNameDtoMap.put(CodeNameDTO.getCode(), CodeNameDTO);
        }

        return codeNameDtoMap;
    }

    /**
     * 获取字段类型列表
     *
     * @return 字段类型列表
     */
    public static List<CodeNameDTO> getColumnTypeList() {
        List<CodeNameDTO> codeNameDtoList = Lists.newArrayList();

        CodeNameDTO CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_CHAR));
        CodeNameDTO.setName(COLUMN_TYPE_CHAR_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_VARCHAR));
        CodeNameDTO.setName(COLUMN_TYPE_VARCHAR_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_INTEGER));
        CodeNameDTO.setName(COLUMN_TYPE_INTEGER_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_NUMBER));
        CodeNameDTO.setName(COLUMN_TYPE_NUMBER_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_TIMESTAMP));
        CodeNameDTO.setName(COLUMN_TYPE_TIMESTAMP_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_CLOB));
        CodeNameDTO.setName(COLUMN_TYPE_CLOB_NAME);
        codeNameDtoList.add(CodeNameDTO);

        CodeNameDTO = new CodeNameDTO();
        CodeNameDTO.setCode(String.valueOf(COLUMN_TYPE_BLOB));
        CodeNameDTO.setName(COLUMN_TYPE_BLOB_NAME);
        codeNameDtoList.add(CodeNameDTO);

        return codeNameDtoList;
    }

}
