package org.tiankafei.jdbc.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 自定义Oracle分页插件(使用分页对象)
 *
 * @author 甜咖啡
 */
public class TiankafeiPaginatedDtoPlugin extends AbstractPaginatedPlugin {

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();

        // 产生分页语句前半部分
        XmlElement paginationPrefixElement = new XmlElement("sql");
        paginationPrefixElement.addAttribute(new Attribute("id", "dbPaginatedPrefix"));
        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "paginatedDTO != null and _databaseId == 'oracle'"));
        pageStart.addElement(new TextElement("SELECT * FROM ( SELECT T.*,ROWNUM RN FROM ( "));
        paginationPrefixElement.addElement(pageStart);
        parentElement.addElement(paginationPrefixElement);

        // 产生分页语句后半部分
        XmlElement paginationSuffixElement = new XmlElement("sql");
        paginationSuffixElement.addAttribute(new Attribute("id", "dbPaginatedSuffix"));
        XmlElement pageOracleEnd = new XmlElement("if");
        pageOracleEnd.addAttribute(new Attribute("test", "paginatedDTO != null and _databaseId == 'oracle'"));
        pageOracleEnd.addElement(new TextElement("<![CDATA[   ) T  WHERE ROWNUM <= #{paginatedDTO.endRecordIndex} ) WHERE RN > #{paginatedDTO.beginRecordIndex}  ]]>"));
        paginationSuffixElement.addElement(pageOracleEnd);

        XmlElement pageMysqlEnd = new XmlElement("if");
        pageMysqlEnd.addAttribute(new Attribute("test", "paginatedDTO != null and (_databaseId == 'mysql' or _databaseId == 'sqlite')"));
        pageMysqlEnd.addElement(new TextElement("limit #{paginatedDTO.beginRecordIndex} , #{paginatedDTO.endRecordIndex}"));
        paginationSuffixElement.addElement(pageMysqlEnd);
        parentElement.addElement(paginationSuffixElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    protected boolean sqlMapSelectByExample(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement pageStart = new XmlElement("include");
        pageStart.addAttribute(new Attribute("refid", "dbPaginatedPrefix"));
        element.getElements().add(0, pageStart);

        XmlElement isNotNullElement = new XmlElement("include");
        isNotNullElement.addAttribute(new Attribute("refid", "dbPaginatedSuffix"));
        element.getElements().add(isNotNullElement);

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

}
