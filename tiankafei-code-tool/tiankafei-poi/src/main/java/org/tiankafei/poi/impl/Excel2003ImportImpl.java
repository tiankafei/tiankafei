package org.tiankafei.poi.impl;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel2003ImportImpl extends BaseExcelImportImpl {

    private static class InnerClass {
        private static BaseExcelImportImpl INSTANCE = new Excel2003ImportImpl();
    }

    private Excel2003ImportImpl(){}

    public static BaseExcelImportImpl getInstance(){
        return InnerClass.INSTANCE;
    }

}
