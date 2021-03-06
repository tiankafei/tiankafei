package org.tiankafei.poi.impl;

import org.tiankafei.poi.ExcelReadStyle;

/**
 * @author tiankafei
 */
public class Excel2003ReadStyleImpl extends BaseExcelReadStyleImpl {

    private static class InnerClass {
        private static ExcelReadStyle INSTANCE = new Excel2003ReadStyleImpl();
    }

    private Excel2003ReadStyleImpl(){}

    public static ExcelReadStyle getInstance(){
        return InnerClass.INSTANCE;
    }

}
