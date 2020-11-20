package org.tiankafei.poi.impl;

import org.tiankafei.poi.enums.ExcelSuffixEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Word2007ExportImpl extends BaseWordExportImpl {
    @Override
    public String getFileSuffix() {
        return ExcelSuffixEnum.WORD_2007_SUFFIX.getCode();
    }
}
