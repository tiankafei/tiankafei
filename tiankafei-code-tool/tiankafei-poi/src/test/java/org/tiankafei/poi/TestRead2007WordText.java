package org.tiankafei.poi;

import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestRead2007WordText {

    /**
     * 通过XWPFDocument对内容进行访问。对于XWPF文档而言，用这种方式进行读操作更佳。
     *
     * @throws Exception
     */
    @Test
    public void testReadByDoc() throws Exception {
        InputStream is = new FileInputStream("D:\\excel\\5-1-1企业统计信用档案20200126.docx");
        XWPFDocument doc = new XWPFDocument(is);
        List<XWPFParagraph> paras = doc.getParagraphs();

        for (XWPFParagraph para : paras) {
            //当前段落的属性
//       CTPPr pr = para.getCTP().getPPr();
            String text = para.getText();
            if (text.startsWith("编号")) {
                System.out.println("---------------" + text + "---------------");
            } else if (text.startsWith("填报单位") && text.indexOf("单位负责人") != -1) {
                System.out.println("---------------" + text + "---------------");
            } else if (text.startsWith("填报人") && text.indexOf("填报日期") != -1) {
                System.out.println("---------------" + text + "---------------");
            }
        }
        //获取文档中所有的表格
        List<XWPFTable> tables = doc.getTables();
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        int curTableIndex = 0;
        for (XWPFTable table : tables) {
            //表格属性
//       CTTblPr pr = table.getCTTbl().getTblPr();
            //获取表格对应的行
            rows = table.getRows();
            int curRowIndex = 0;
            for (XWPFTableRow row : rows) {
                //获取行对应的单元格
                int curColIndex = 0;
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    String text = cell.getText().trim();
//                    System.out.print("第" + curTableIndex + "和表格\t行号：" + curRowIndex + "\t列号：" + curColIndex + "\t" + cell.getText() + "\t");
                    if (curTableIndex == 0) {
                        // 读取第一个表格
                        if (curRowIndex == 0) {
                            // 找值
                            if (curColIndex == 1) {
                                System.out.println("企业名称：" + text);
                            }
                        }
                        if (curRowIndex == 1) {
                            // 找值
                            if (curColIndex == 1) {
                                System.out.println("企业地址：" + text);
                            }
                        }
                        if (curRowIndex == 2) {
                            // 找值
                            if (curColIndex == 1) {
                                System.out.println("统一社会信用代码：" + text);
                            }
                        }
                        if (curRowIndex == 3) {
                            // 找值
                            if (curColIndex == 1) {
                                System.out.println("法定代表人或主要负责人：" + text);
                            }
                            if (curColIndex == 3) {
                                System.out.println("联系电话：" + text);
                            }
                        }
                        if (curRowIndex == 4) {
                            // 找值
                            if (curColIndex == 1) {
                                System.out.println("统计信用：" + text);
                            }
                        }
                    }
                    curColIndex++;
                }
                curRowIndex++;
            }
            curTableIndex++;
        }
        this.close(is);
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
