package org.tiankafei.poi;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.PAPBinTable;
import org.apache.poi.hwpf.model.PAPX;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestRead2003WordText {

    /**
     * 通过XWPFDocument对内容进行访问。对于XWPF文档而言，用这种方式进行读操作更佳。
     *
     * @throws Exception
     */
    @Test
    public void testReadByDoc() throws Exception {
        InputStream is = new FileInputStream("D:\\excel\\5-1-1企业统计信用档案20200126.doc");
        HWPFDocument hdoc = new HWPFDocument(is);

        WordExtractor wordExtractor = new WordExtractor(hdoc);
        String[] paragraphText = wordExtractor.getParagraphText();
        for (int index = 0, length = paragraphText.length; index < length; index++) {
            String text = paragraphText[index].replace("\r\n", "");
            if (text.startsWith("编号")) {
                System.out.println("---------------" + text + "---------------");
            } else if (text.startsWith("填报单位") && text.indexOf("单位负责人") != -1) {
                System.out.println("---------------" + text + "---------------");
            } else if (text.startsWith("填报人") && text.indexOf("填报日期") != -1) {
                System.out.println("---------------" + text + "---------------");
            }
        }


        Range range = hdoc.getRange();
        TableIterator it = new TableIterator(range);
        int curTableIndex = 0;
        while (it.hasNext()) {
            Table tb = it.next();
            //迭代行，默认从0开始
            for (int curRowIndex = 0; curRowIndex < tb.numRows(); curRowIndex++) {
                TableRow tr = tb.getRow(curRowIndex);
                tr.numSections();
                //迭代列，默认从0开始
                for (int curColIndex = 0; curColIndex < tr.numCells(); curColIndex++) {
                    TableCell td = tr.getCell(curColIndex);//取得单元格
                    //取得单元格的内容
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);
                        stringBuilder.append(para.text().trim());
                    }
                    String text = stringBuilder.toString();
//                    System.out.println("第" + curTableIndex + "个表格\t行号：" + curRowIndex + "\t列号：" + curColIndex + "\t" + text + "\t");

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
                }
            }
            curTableIndex++;
        }
//        XWPFDocument doc = new XWPFDocument(is);
//        List<XWPFParagraph> paras = doc.getParagraphs();
//
//
//        for (XWPFParagraph para : paras) {
//            //当前段落的属性
////       CTPPr pr = para.getCTP().getPPr();
//            String text = para.getText();
//            if(text.startsWith("编号")){
//                System.out.println("---------------" + text + "---------------");
//            } else if (text.startsWith("填报单位") && text.indexOf("单位负责人") != -1) {
//                System.out.println("---------------" + text + "---------------");
//            } else if (text.startsWith("填报人") && text.indexOf("填报日期") != -1) {
//                System.out.println("---------------" + text + "---------------");
//            }
//        }
//        //获取文档中所有的表格
//        List<XWPFTable> tables = doc.getTables();
//        List<XWPFTableRow> rows;
//        List<XWPFTableCell> cells;
//        int curTableIndex = 0;
//        for (XWPFTable table : tables) {
//            //表格属性
////       CTTblPr pr = table.getCTTbl().getTblPr();
//            //获取表格对应的行
//            rows = table.getRows();
//            int curRowIndex = 0;
//            for (XWPFTableRow row : rows) {
//                //获取行对应的单元格
//                int curColIndex = 0;
//                cells = row.getTableCells();
//                for (XWPFTableCell cell : cells) {
//                    String text = cell.getText();
////                    System.out.print("第" + curTableIndex + "和表格\t行号：" + curRowIndex + "\t列号：" + curColIndex + "\t" + cell.getText() + "\t");
//                    if(curTableIndex == 0){
//                        // 读取第一个表格
//                        if(curRowIndex == 0){
//                            // 找值
//                            if(curColIndex == 1){
//                                System.out.println("企业名称：" +text);
//                            }
//                        }
//                        if(curRowIndex == 1){
//                            // 找值
//                            if(curColIndex == 1){
//                                System.out.println("企业地址：" +text);
//                            }
//                        }
//                        if(curRowIndex == 2){
//                            // 找值
//                            if(curColIndex == 1){
//                                System.out.println("统一社会信用代码：" +text);
//                            }
//                        }
//                        if(curRowIndex == 3){
//                            // 找值
//                            if(curColIndex == 1){
//                                System.out.println("法定代表人或主要负责人：" +text);
//                            }
//                            if(curColIndex == 3){
//                                System.out.println("联系电话：" +text);
//                            }
//                        }
//                        if(curRowIndex == 4){
//                            // 找值
//                            if(curColIndex == 1){
//                                System.out.println("统计信用：" +text);
//                            }
//                        }
//                    }
//                    if(curTableIndex == 0 && curRowIndex == 0 && curColIndex == 0 && "企业名称".equals(text)){
//
//                    }
//                    curColIndex++;
//                }
//                curRowIndex++;
//            }
//            curTableIndex++;
//        }
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
