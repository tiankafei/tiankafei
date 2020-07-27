package org.tiankafei.poi;

import java.io.FileInputStream;
import lombok.Data;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.BorderCode;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class TestReadWordTable {

    @Test
    public void testWord() {
        try {
            FileInputStream in = new FileInputStream("D:\\software\\WeChat Files\\WeChat Files\\wxid_o5qgqn7l0op331\\FileStorage\\File\\2020-07\\03第三部分 普查表式、指标解释及填报目录(1).doc");//载入文档
            POIFSFileSystem pfs = new POIFSFileSystem(in);
            HWPFDocument hwpf = new HWPFDocument(pfs);
            Range range = hwpf.getRange();//得到文档的读取范围


            TableIterator it = new TableIterator(range);
            //迭代文档中的表格
            while (it.hasNext()) {
                Table tb = it.next();
                //迭代行，默认从0开始
                for (int i = 0; i < tb.numRows(); i++) {
                    TableRow tr = tb.getRow(i);
                    tr.numSections();
                    //迭代列，默认从0开始
                    for (int j = 0; j < tr.numCells(); j++) {
                        TableCell td = tr.getCell(j);//取得单元格

                        BorderCode brcBottom = td.getBrcBottom();
                        brcBottom.getBorderType();

                        //取得单元格的内容
                        for (int k = 0;
                             k < td.numParagraphs(); k++) {
                            Paragraph para = td.getParagraph(k);
                            System.out.println(td.numParagraphs() + ":::" + i + ",,," + j + ",,," + para.text());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    static class RowDto {

        private int height;



    }

    static class ColDto {

    }

    @Data
    static class CellDto {

        private String text;

    }

}
