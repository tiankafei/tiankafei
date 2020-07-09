package org.tiankafei.poi.impl;

import org.tiankafei.poi.ExcelReadStyle;

/**
 * @author tiankafei
 */
public class Excel9999ReadStyleImpl extends BaseExcelReadStyleImpl {

    private static class InnerClass {
        private static ExcelReadStyle INSTANCE = new Excel9999ReadStyleImpl();
    }

    private Excel9999ReadStyleImpl(){}

    public static ExcelReadStyle getInstance(){
        return InnerClass.INSTANCE;
    }

}
