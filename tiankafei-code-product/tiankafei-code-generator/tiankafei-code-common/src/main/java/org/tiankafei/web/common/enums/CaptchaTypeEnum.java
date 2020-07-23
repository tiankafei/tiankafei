package org.tiankafei.web.common.enums;

/**
 * 验证码类型枚举类
 *
 * @author tiankafei
 * @since 1.0
 */
public enum CaptchaTypeEnum {

    // 数字、大小写字母随机组合
    DEFAULT("DEFAULT"),

    // 加、减、乘算数运算表达式
    ARITHMETIC("ARITHMETIC"),

    // 中文简体加、减、乘算数运算表达式描述
    ARITHMETIC_ZH("ARITHMETIC_ZH"),

    // 常见汉字（3500个）随机组合
    CHINESE("CHINESE"),

    // 0~9数字随机组合
    NUMBER("NUMBER"),

    // 中文数字（零至九）随机组合
    NUMBER_ZH_CN("NUMBER_ZH_CN"),

    // 中文繁体数字（零至玖）随机组合
    NUMBER_ZH_HK("NUMBER_ZH_HK"),

    // 大小写字母随机组合
    WORD("WORD"),

    // 小写字母随机组合
    WORD_LOWER("WORD_LOWER"),

    // 大写字母随机组合
    WORD_UPPER("WORD_UPPER"),

    // 数字、小写字母随机组合
    WORD_NUMBER_LOWER("WORD_NUMBER_LOWER"),

    // 数字、大写字母随机组合
    WORD_NUMBER_UPPER("WORD_NUMBER_UPPER"),

    ;

    private String captchaType;

    CaptchaTypeEnum(String captchaType) {
        this.captchaType = captchaType;
    }

    public String getCaptchaType() {
        return captchaType;
    }
}
