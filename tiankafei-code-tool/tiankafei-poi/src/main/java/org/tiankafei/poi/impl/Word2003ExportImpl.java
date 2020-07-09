package org.tiankafei.poi.impl;

import org.tiankafei.poi.enums.PoiEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Word2003ExportImpl extends BaseWordExportImpl {
    @Override
    public String getFileSuffix() {
        return PoiEnum.WORD_2003_SUFFIX.getCode();
    }
}
