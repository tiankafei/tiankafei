package org.tiankafei.poi.impl;

import org.tiankafei.poi.ExcelReadStyle;

/**
 * @author tiankafei
 */
public class Excel2007ReadStyleImpl extends BaseExcelReadStyleImpl {

    private static class InnerClass {
        private static ExcelReadStyle INSTANCE = new Excel2007ReadStyleImpl();
    }

    private Excel2007ReadStyleImpl(){}

    public static ExcelReadStyle getInstance() {
        return InnerClass.INSTANCE;
    }

}
