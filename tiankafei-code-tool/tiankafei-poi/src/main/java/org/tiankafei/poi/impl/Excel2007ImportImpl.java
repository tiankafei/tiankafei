package org.tiankafei.poi.impl;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel2007ImportImpl extends BaseExcelImportImpl {

    private static class InnerClass {
        private static BaseExcelImportImpl INSTANCE = new Excel2007ImportImpl();
    }

    private Excel2007ImportImpl(){}

    public static BaseExcelImportImpl getInstance(){
        return InnerClass.INSTANCE;
    }

}
