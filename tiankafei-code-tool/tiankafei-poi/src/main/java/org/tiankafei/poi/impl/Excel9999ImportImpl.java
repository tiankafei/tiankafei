package org.tiankafei.poi.impl;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel9999ImportImpl extends BaseExcelImportImpl {

    private static class InnerClass {
        private static BaseExcelImportImpl INSTANCE = new Excel9999ImportImpl();
    }

    private Excel9999ImportImpl(){}

    public static BaseExcelImportImpl getInstance(){
        return InnerClass.INSTANCE;
    }

}
