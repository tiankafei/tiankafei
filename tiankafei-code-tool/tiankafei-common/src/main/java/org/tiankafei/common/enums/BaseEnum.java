package org.tiankafei.common.enums;

/**
 * 基础常量配置类
 *
 * @author tiankafei
 * @since 1.0
 **/
public enum BaseEnum {

    /**
     * 默认项目名称
     */
    DEFAULT_PROJECT_NAME("甜咖啡工作室基础项目库"),

    /**
     * 代码表默认版本
     */
    CODE_TABLE_DEFAULT_VERSION("00000000"),

    /**
     * 服务器名称
     */
    SERVER_NAME("NAME"),

    /**
     * 横杠
     */
    BAR("-"),

    /**
     * 空格
     */
    BLANK(" "),

    /**
     * 本地ip
     */
    LOCAL_IP_DEFAULT("127.0.0.1"),

    /**
     * txt文件后缀
     */
    FILE_SUFFIX_TXT(".txt"),

    /**
     * csv文件后缀
     */
    FILE_SUFFIX_CSV(".csv"),

    /**
     * gif文件后缀
     */
    FILE_SUFFIX_GIF(".gif"),

    /**
     * true
     */
    TRUE("true"),

    /**
     * false
     */
    FALSE("false"),
    ;

    private String value;

    BaseEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
