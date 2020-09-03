package org.tiankafei.jdbc.mybatis.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.mybatis.constant.MybatisDbConfigConstants;
import org.tiankafei.jdbc.mybatis.dao.CommonDynamicMyBatisDaoImpl;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * 自定义mybatis生成注释类
 *
 * @author 甜咖啡
 */
public class TiankafeiCommentGenerator implements CommentGenerator {

    private boolean suppressAllComments;

    private Properties systemPro;

    private Map<String, Map<String, String>> columnChineseMapMap = new HashMap<String, Map<String, String>>();
    private Map<String, String> tableNameMap = new HashMap<String, String>();

    public TiankafeiCommentGenerator() {
        try {
            suppressAllComments = false;
            systemPro = System.getProperties();
            String mybatisConfigProperties = systemPro.getProperty(MybatisDbConfigConstants.MYBATIS_CONFIG_PROPERTIES);
            String columnTableName = systemPro.getProperty(MybatisDbConfigConstants.COLUMN_TABLE_NAME_PROPERTIES);
            String tableTableName = systemPro.getProperty(MybatisDbConfigConstants.TABLE_TABLE_NAME_PROPERTIES);

            CommonDynamicMyBatisDaoImpl commonDynamicMyBatisDaoImpl = new CommonDynamicMyBatisDaoImpl(mybatisConfigProperties);
            //获取字段中文注释
            StringBuffer sqlBuffer = new StringBuffer().append("SELECT * FROM ").append(columnTableName);
            List<Map<String, Object>> dataMapList = commonDynamicMyBatisDaoImpl.queryDataMapList(new SqlParamDTO(sqlBuffer.toString()));
            for (int index = 0, length = dataMapList.size(); index < length; index++) {
                Map<String, Object> dataMap = dataMapList.get(index);
                String tableName = (String) dataMap.get("TABLE_NAME");
                String columnName = (String) dataMap.get("COLUMN_NAME");
                String chineseName = (String) dataMap.get("CHINESE_NAME");

                Map<String, String> columnChineseMap = null;
                if (columnChineseMapMap.containsKey(tableName)) {
                    columnChineseMap = columnChineseMapMap.get(tableName);
                } else {
                    columnChineseMap = new HashMap<String, String>();
                    columnChineseMapMap.put(tableName, columnChineseMap);
                }
                columnChineseMap.put(columnName, chineseName);
            }

            //获取物理表中文注释
            sqlBuffer = new StringBuffer().append("SELECT * FROM ").append(tableTableName);
            dataMapList = commonDynamicMyBatisDaoImpl.queryDataMapList(new SqlParamDTO(sqlBuffer.toString()));
            for (int index = 0, length = dataMapList.size(); index < length; index++) {
                Map<String, Object> dataMap = dataMapList.get(index);
                String tableName = (String) dataMap.get("TABLE_NAME");
                String tableComments = (String) dataMap.get("TABLE_COMMENTS");
                tableNameMap.put(tableName, tableComments);
            }
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    /**
     * 私有属性
     *
     * @param field              字段参数
     * @param introspectedTable  物理表参数
     * @param introspectedColumn 字段参数
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + getColumnChineseName(introspectedTable, introspectedColumn));
        field.addJavaDocLine(" * " + getTableName(introspectedTable) + "." + getColumnName(introspectedColumn));
        field.addJavaDocLine(" */");
    }

    /**
     * 受保护的属性
     *
     * @param field             字段参数
     * @param introspectedTable 物理表参数
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + field.getName());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

    /**
     * 内部类增加注释
     *
     * @param innerClass        内部类参数
     * @param introspectedTable 物理表参数
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * 标准规范");
        innerClass.addJavaDocLine(" */");
    }

    /**
     * 内部类注释
     *
     * @param innerClass        内部类参数
     * @param introspectedTable 物理表参数
     * @param b                 不知道是么属性
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
        if (suppressAllComments) {
            return;
        }
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * 标准规范");
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    /**
     * get方法注释
     *
     * @param method             方法名参数
     * @param introspectedTable  物理表参数
     * @param introspectedColumn 字段参数
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * 获取" + getColumnChineseName(introspectedTable, introspectedColumn));
        method.addJavaDocLine(" * " + getTableName(introspectedTable) + "." + getColumnName(introspectedColumn));
        method.addJavaDocLine(" * @return   " + getColumnChineseName(introspectedTable, introspectedColumn));
        method.addJavaDocLine(" */");
    }

    /**
     * set方法注释
     *
     * @param method             方法名参数
     * @param introspectedTable  物理表参数
     * @param introspectedColumn 字段参数
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        Parameter parameter = method.getParameters().get(0);

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * 设置" + getColumnChineseName(introspectedTable, introspectedColumn));
        method.addJavaDocLine(" * " + getTableName(introspectedTable) + "." + getColumnName(introspectedColumn));
        method.addJavaDocLine(" * @param " + parameter.getName() + "    " + getColumnChineseName(introspectedTable, introspectedColumn));

        method.addJavaDocLine(" */");
    }

    /**
     * 生成普通函数注释
     *
     * @param method            函数参数
     * @param introspectedTable 物理表参数
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        if (suppressAllComments) {
            return;
        }

        compilationUnit.addFileCommentLine("/**");
        compilationUnit.addFileCommentLine(" * 构造");
        compilationUnit.addFileCommentLine(" * @author " + systemPro.getProperty("user.name"));
        /*compilationUnit.addFileCommentLine(" * @date " + DateTimeUtil.getCurrentTime(DateTimeUtil.YYYY_MM_DDHH));*/
        compilationUnit.addFileCommentLine(" */");
    }

    @Override
    public void addComment(XmlElement xmlElement) {

    }

    @Override
    public void addRootComment(XmlElement xmlElement) {

    }

    /**
     * 获取字段中文名
     *
     * @param introspectedTable  用于获取物理表
     * @param introspectedColumn 获取参数名
     * @return 字段中文名
     */
    private String getColumnChineseName(IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String tableName = introspectedTable.getFullyQualifiedTable().toString().toUpperCase();
        String columnName = introspectedColumn.getActualColumnName();
        if (columnChineseMapMap.containsKey(tableName)) {
            return columnChineseMapMap.get(tableName).get(columnName);
        }
        return "";
    }

    /**
     * 获取物理表名
     *
     * @param introspectedTable 物理表名参数
     * @return 物理表名
     */
    private String getTableName(IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getFullyQualifiedTable().toString().toUpperCase();
        return tableName;
    }

    /**
     * 获取字段名
     *
     * @param introspectedColumn 字段参数
     * @return 字段名
     */
    private String getColumnName(IntrospectedColumn introspectedColumn) {
        String columnName = introspectedColumn.getActualColumnName();
        return columnName;
    }

}
