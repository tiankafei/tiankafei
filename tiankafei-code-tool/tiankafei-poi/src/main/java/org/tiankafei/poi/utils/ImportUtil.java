package org.tiankafei.poi.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tiankafei.poi.ExcelReadStyle;
import org.tiankafei.poi.exception.ExcelException;
import org.tiankafei.poi.impl.BaseExcelImportImpl;
import org.tiankafei.poi.impl.Excel2003ImportImpl;
import org.tiankafei.poi.impl.Excel2003ReadStyleImpl;
import org.tiankafei.poi.impl.Excel2007ImportImpl;
import org.tiankafei.poi.impl.Excel2007ReadStyleImpl;
import org.tiankafei.poi.impl.Excel9999ImportImpl;
import org.tiankafei.poi.impl.Excel9999ReadStyleImpl;
import org.tiankafei.poi.model.WorkBookData;
import org.tiankafei.poi.property.WorkbookProperty;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class ImportUtil {

    public static void main(String[] args) throws ExcelException {
        String filePath = "D:\\test\\1—1  全省行政区划(1999年末).xls";
        WorkbookProperty workbookProperty = ImportUtil.parseExcel(filePath);
        System.out.println(workbookProperty);
    }

    /**
     * 解析excel
     * @param filePath  excel路径
     * @return
     */
    public static WorkBookData importExcel(String filePath) throws ExcelException {
        return importExcel(new File(filePath));
    }

    /**
     * 解析excel
     * @param inputStream   excel输入流
     * @return
     */
    public static WorkBookData importExcel(InputStream inputStream) throws ExcelException {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            return importExcel(workbook);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcelException(e.getMessage());
        }
    }

    /**
     * 解析excel
     * @param file   excel文件对象
     * @return
     */
    public static WorkBookData importExcel(File file) throws ExcelException {
        try {
            Workbook workbook = WorkbookFactory.create(file);
            return importExcel(workbook);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcelException(e.getMessage());
        }
    }

    /**
     * 解析excel
     * @param workbook
     * @return
     * @throws ExcelException
     */
    private static WorkBookData importExcel(Workbook workbook) throws ExcelException {
        BaseExcelImportImpl baseExcelImport = null;

        if(workbook instanceof HSSFWorkbook){
            baseExcelImport = Excel2003ImportImpl.getInstance();
        }else if(workbook instanceof XSSFWorkbook){
            baseExcelImport = Excel2007ImportImpl.getInstance();
        }else if(workbook instanceof SXSSFWorkbook){
            baseExcelImport = Excel9999ImportImpl.getInstance();
        }else{
            throw new ExcelException("文件读取错误");
        }
        return baseExcelImport.importExcel(workbook);
    }

    /**
     * 解析excel
     * @param filePath  excel路径
     * @return
     */
    public static WorkbookProperty parseExcel(String filePath) throws ExcelException {
        return parseExcel(new File(filePath));
    }

    /**
     * 解析excel
     * @param inputStream   excel输入流
     * @return
     */
    public static WorkbookProperty parseExcel(InputStream inputStream) throws ExcelException {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            return parseExcel(workbook);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcelException(e.getMessage());
        }
    }

    /**
     * 解析excel
     * @param file   excel文件对象
     * @return
     */
    public static WorkbookProperty parseExcel(File file) throws ExcelException {
        try {
            Workbook workbook = WorkbookFactory.create(file);
            return parseExcel(workbook);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcelException(e.getMessage());
        }
    }

    /**
     * 解析excel
     * @param workbook
     * @return
     * @throws ExcelException
     */
    private static WorkbookProperty parseExcel(Workbook workbook) throws ExcelException {
        ExcelReadStyle excelReadStyle = null;

        if(workbook instanceof HSSFWorkbook){
            excelReadStyle = Excel2003ReadStyleImpl.getInstance();
        }else if(workbook instanceof XSSFWorkbook){
            excelReadStyle = Excel2007ReadStyleImpl.getInstance();
        }else if(workbook instanceof SXSSFWorkbook){
            excelReadStyle = Excel9999ReadStyleImpl.getInstance();
        }else{
            throw new ExcelException("文件读取错误");
        }
        return excelReadStyle.importExcel(workbook);
    }

}
