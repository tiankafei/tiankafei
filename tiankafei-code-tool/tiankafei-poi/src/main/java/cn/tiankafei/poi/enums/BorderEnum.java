package cn.tiankafei.poi.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum BorderEnum {

    NONE("NONE"),
    THIN("THIN"),
    MEDIUM("MEDIUM"),
    DASHED("DASHED"),
    DOTTED("DOTTED"),
    THICK("THICK"),
    DOUBLE("DOUBLE"),
    HAIR("HAIR"),
    MEDIUM_DASHED("MEDIUM_DASHED"),
    DASH_DOT("DASH_DOT"),
    MEDIUM_DASH_DOT("MEDIUM_DASH_DOT"),
    DASH_DOT_DOT("DASH_DOT_DOT"),
    MEDIUM_DASH_DOT_DOT("MEDIUM_DASH_DOT_DOT"),
    SLANTED_DASH_DOT("SLANTED_DASH_DOT"),
    ;

    private String code;

    BorderEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
