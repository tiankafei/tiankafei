package org.tiankafei.ui.control.util;

import java.sql.Timestamp;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.datetime.DateTimeUtil;
import org.tiankafei.common.enums.DateTimeEnum;
import org.tiankafei.common.util.ValidatorUtil;

/**
 * 公共校验处理类
 *
 * @author tiankafei
 */
public class CommonCheckUtil {

    private CommonCheckUtil() {

    }

    /**
     * 验证特殊字符
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkSpecialStringValidationOne(String value) {
        value = StringUtils.trim(value);
        return checkSpecialStringValidationThreeAll(value, false, 0);
    }

    /**
     * 验证特殊字符
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkSpecialStringValidationTwoEmpty(String value, boolean emptyFlag) {
        value = StringUtils.trim(value);
        return checkSpecialStringValidationThreeAll(value, emptyFlag, 0);
    }

    /**
     * 验证特殊字符
     *
     * @param value  需要校验的字符
     * @param length 长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkSpecialStringValidationTwoLength(String value, int length) {
        value = StringUtils.trim(value);
        return checkSpecialStringValidationThreeAll(value, false, length);
    }

    /**
     * 验证特殊字符
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @param length    长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkSpecialStringValidationThreeAll(String value, boolean emptyFlag, int length) {
        value = StringUtils.trim(value);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(value)) {
            if (length == 0) {
                bf.append(checkSpecialStringRegEx(value));
            } else {
                if (value.length() > length) {
                    bf.append("输入长度不合法，不能超过" + length + ", 请重新输入!");
                } else {
                    bf.append(checkSpecialStringRegEx(value));
                }
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 验证特殊字符
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    private static String checkSpecialStringRegEx(String value) {
        String message = "";
        if (!ValidatorUtil.checkSpecialStringRegEx(value)) {
            message = "输入不合法(含有特殊字符), 请重新输入!";
        }
        return message;
    }

    /**
     * 全部为中文的验证
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkAllChineseValidationOne(String value) {
        value = StringUtils.trim(value);
        return checkAllChineseValidationThreeAll(value, false, 0);
    }

    /**
     * 全部为中文的验证
     *
     * @param value  需要校验的字符
     * @param length 长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkAllChineseValidationTwoLength(String value, int length) {
        value = StringUtils.trim(value);
        return checkAllChineseValidationThreeAll(value, false, length);
    }

    /**
     * 全部为中文的验证
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkAllChineseValidationTwoEmpty(String value, boolean emptyFlag) {
        value = StringUtils.trim(value);
        return checkAllChineseValidationThreeAll(value, emptyFlag, 0);
    }

    /**
     * 全部为中文的验证
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @param length    长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkAllChineseValidationThreeAll(String value, boolean emptyFlag, int length) {
        value = StringUtils.trim(value);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(value)) {
            if (length == 0) {
                bf.append(checkAllChineseRegEx(value));
            } else {
                if (value.length() > length) {
                    bf.append("输入长度不合法，不能超过" + length + ", 请重新输入!");
                } else {
                    bf.append(checkAllChineseRegEx(value));
                }
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 全部为中文的验证
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    private static String checkAllChineseRegEx(String value) {
        String message = "";
        if (!ValidatorUtil.checkAllChineseRegEx(value)) {
            message = "输入不合法(字符中有不是中文的), 请重新输入!";
        }
        return message;
    }

    /**
     * 部分中文的校验
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkPartChineseValidationOne(String value) {
        value = StringUtils.trim(value);
        return checkPartChineseValidationThreeAll(value, false, 0);
    }

    /**
     * 部分中文的校验
     *
     * @param value  需要校验的字符
     * @param length 长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkPartChineseValidationTwoLength(String value, int length) {
        value = StringUtils.trim(value);
        return checkPartChineseValidationThreeAll(value, false, length);
    }

    /**
     * 部分中文的校验
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkPartChineseValidationTwoEmpty(String value, boolean emptyFlag) {
        value = StringUtils.trim(value);
        return checkPartChineseValidationThreeAll(value, emptyFlag, 0);
    }

    /**
     * 部分中文的校验
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @param length    长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkPartChineseValidationThreeAll(String value, boolean emptyFlag, int length) {
        value = StringUtils.trim(value);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(value)) {
            if (length == 0) {
                bf.append(checkPartChineseRegEx(value));
            } else {
                if (value.length() > length) {
                    bf.append("输入长度不合法，不能超过" + length + ", 请重新输入!");
                } else {
                    bf.append(checkPartChineseRegEx(value));
                }
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 部分中文的验证
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    private static String checkPartChineseRegEx(String value) {
        String message = "";
        if (!ValidatorUtil.checkPartChineseRegEx(value)) {
            message = "输入不合法(字符中没有包含中文), 请重新输入!";
        }
        return message;
    }

    /**
     * 全部为数字的验证
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkAllNumberValidationOne(String value) {
        value = StringUtils.trim(value);
        return checkAllNumberValidationThreeAll(value, false, 0);
    }

    /**
     * 全部为数字的验证
     *
     * @param value  需要校验的字符
     * @param length 长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkAllNumberValidationTwoLength(String value, int length) {
        value = StringUtils.trim(value);
        return checkAllNumberValidationThreeAll(value, false, length);
    }

    /**
     * 全部为数字的验证
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkAllNumberValidationTwoEmpty(String value, boolean emptyFlag) {
        value = StringUtils.trim(value);
        return checkAllNumberValidationThreeAll(value, emptyFlag, 0);
    }

    /**
     * 全部为数字的验证
     *
     * @param value     需要校验的字符
     * @param emptyFlag 是否需要为空校验
     * @param length    长度校验如果为0则不校验，否则则进行校验
     * @return 返回验证信息
     */
    public static String checkAllNumberValidationThreeAll(String value, boolean emptyFlag, int length) {
        value = StringUtils.trim(value);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(value)) {
            if (length == 0) {
                bf.append(checkAllNumberRegEx(value));
            } else {
                if (value.length() > length) {
                    bf.append("长度不合法，不能超过" + length + ", 请重新输入!");
                } else {
                    bf.append(checkAllNumberRegEx(value));
                }
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 全部为数字的校验
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    private static String checkAllNumberRegEx(String value) {
        String message = "";
        if (!ValidatorUtil.checkAllNumberRegEx(value)) {
            message = "输入不合法(应全部为数字), 请重新输入!";
        }
        return message;
    }

    /**
     * 为空校验
     *
     * @param value 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkEmptyValidation(String value) {
        value = StringUtils.trim(value);
        StringBuffer message = new StringBuffer();
        if (StringUtils.isEmpty(value)) {
            message.append("不能为空, 请重新输入!");
        }
        return message.toString();
    }

    /**
     * 验证手机号码是否合法
     *
     * @param mobilePhone 需要校验的字符
     * @return 返回验证信息
     */
    public static String checkMobilePhoneValidationOne(String mobilePhone) {
        mobilePhone = StringUtils.trim(mobilePhone);
        return checkMobilePhoneValidationTwo(mobilePhone, false);
    }

    /**
     * 验证手机号码是否合法
     *
     * @param mobilePhone 需要校验的手机号
     * @param emptyFlag   是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkMobilePhoneValidationTwo(String mobilePhone, boolean emptyFlag) {
        mobilePhone = StringUtils.trim(mobilePhone);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(mobilePhone)) {
            if (!ValidatorUtil.checkMobilePhoneRegEx(mobilePhone)) {
                bf.append("输入不合法, 请重新输入!");
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 验证固定电话是否合法
     *
     * @param telephone 需要校验的电话号码
     * @return 返回验证信息
     */
    public static String checkTelephoneValidationOne(String telephone) {
        telephone = StringUtils.trim(telephone);
        return checkTelephoneValidationTwo(telephone, false);
    }

    /**
     * 验证固定电话是否合法
     *
     * @param telephone 需要校验的电话号码
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkTelephoneValidationTwo(String telephone, boolean emptyFlag) {
        telephone = StringUtils.trim(telephone);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(telephone)) {
            if (!ValidatorUtil.checkTelephoneRegEx(telephone)) {
                bf.append("输入不合法(必须输入区号(3-4位), 且区号和号码(5-10位)必须用-连接), 请重新输入!");
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 验证电子邮件是否合法
     *
     * @param email 需要校验的电子邮件
     * @return 返回验证信息
     */
    public static String checkEmailValidationOne(String email) {
        email = StringUtils.trim(email);
        return checkEmailValidationTwo(email, false);
    }

    /**
     * 验证电子邮件是否合法
     *
     * @param email     需要校验的电子邮件
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkEmailValidationTwo(String email, boolean emptyFlag) {
        email = StringUtils.trim(email);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(email)) {
            if (!ValidatorUtil.checkEmailRegEx(email)) {
                bf.append("输入不合法(5-100), 请重新输入!");
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 验证QQ是否合法
     *
     * @param qq 需要校验的qq
     * @return 返回验证信息
     */
    public static String checkQqValidationOne(String qq) {
        qq = StringUtils.trim(qq);
        return checkQqValidationTwo(qq, false);
    }

    /**
     * 验证QQ是否合法
     *
     * @param qq        需要校验的qq
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkQqValidationTwo(String qq, boolean emptyFlag) {
        qq = StringUtils.trim(qq);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(qq)) {
            if (!ValidatorUtil.checkQqRegEx(qq)) {
                bf.append("输入不合法(5-12数字，第一位不能是0), 请重新输入!");
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 验证微信是否合法
     *
     * @param wechat 需要校验的微信
     * @return 返回验证信息
     */
    public static String checkWechatValidationOne(String wechat) {
        wechat = StringUtils.trim(wechat);
        return checkWechatValidationTwo(wechat, false);
    }

    /**
     * 验证微信是否合法
     *
     * @param wechat    需要校验的微信
     * @param emptyFlag 是否需要为空校验
     * @return 返回验证信息
     */
    public static String checkWechatValidationTwo(String wechat, boolean emptyFlag) {
        wechat = StringUtils.trim(wechat);
        StringBuffer bf = new StringBuffer();
        if (StringUtils.isNotEmpty(wechat)) {
            if (!ValidatorUtil.checkWechatRegEx(wechat)) {
                bf.append("输入不合法(6—20个字母、数字、下划线和减号, 必须以字母开头), 请重新输入!");
            }
        } else {
            if (emptyFlag) {
                bf.append("不能为空, 请重新输入!");
            }
        }
        return bf.toString();
    }

    /**
     * 是否不相等校验
     *
     * @param value1    第一个值
     * @param value2    第二个值
     * @param viewTitle 用户返回消息
     * @param flag      是否区别大小写比较true区别，false不区分
     * @return 返回验证信息
     */
    public static String checkNotEqualsValidation(String value1, String value2, String viewTitle, boolean flag) {
        value1 = StringUtils.trim(value1);
        value2 = StringUtils.trim(value2);
        StringBuffer message = new StringBuffer();

        if (StringUtils.isNotEmpty(value1) && StringUtils.isNotEmpty(value2)) {
            if (flag) {
                if (value1.equals(value2)) {
                    message.append(viewTitle).append("相等，请重新输入！");
                }
            } else {
                if (value1.toLowerCase().equals(value2.toLowerCase())) {
                    message.append(viewTitle).append("相等，请重新输入！");
                }
            }
        } else {
            message.append(viewTitle).append("中有空值，请检查！");
        }

        return message.toString();
    }

    /**
     * 是否相等校验
     *
     * @param value1    第一个值
     * @param value2    第二个值
     * @param viewTitle 用户返回消息
     * @param flag      是否区别大小写比较true区别，false不区分
     * @return 返回验证信息
     */
    public static String checkEqualsValidation(String value1, String value2, String viewTitle, boolean flag) {
        value1 = StringUtils.trim(value1);
        value2 = StringUtils.trim(value2);
        StringBuffer message = new StringBuffer();

        if (StringUtils.isNotEmpty(value1) && StringUtils.isNotEmpty(value2)) {
            if (flag) {
                if (!value1.equals(value2)) {
                    message.append(viewTitle).append("不符，请重新输入！");
                }
            } else {
                if (!value1.toLowerCase().equals(value2.toLowerCase())) {
                    message.append(viewTitle).append("不符，请重新输入！");
                }
            }
        } else {
            message.append(viewTitle).append("中有空值，请检查！");
        }

        return message.toString();
    }

    /**
     * 验证日期大小比较
     *
     * @param firstValue  第一个值
     * @param secondValue 第二个值
     * @param flag        为true校验的是大于等于，为false校验是大于
     * @param viewTitle   错误显示头部信息
     * @return 返回验证信息
     */
    public static String checkDateTimeBig(String firstValue, String secondValue, boolean flag, String viewTitle) {
        firstValue = StringUtils.trim(firstValue);
        secondValue = StringUtils.trim(secondValue);
        StringBuffer message = new StringBuffer();

        if (StringUtils.isNotEmpty(firstValue) && StringUtils.isNotEmpty(secondValue)) {
            long firstTime = DateTimeUtil.stringToLong(firstValue, DateTimeEnum.YYYY_MM_DD.getCode());
            long secondTime = DateTimeUtil.stringToLong(secondValue, DateTimeEnum.YYYY_MM_DD.getCode());
            if (flag) {
                if (firstTime >= secondTime) {
                    String first = viewTitle.split("@")[0];
                    String second = viewTitle.split("@")[1];
                    message.append(first).append("不能比").append(second).append("大!");
                }
            } else {
                if (firstTime > secondTime) {
                    String first = viewTitle.split("@")[0];
                    String second = viewTitle.split("@")[1];
                    message.append(first).append("不能比").append(second).append("大!");
                }
            }
        }

        return message.toString();
    }

    /**
     * 验证日期大小比较
     *
     * @param firstValue  第一个值
     * @param secondValue 第二个值
     * @param flag        为true校验的是小于等于，为false校验是小于
     * @param viewTitle   错误显示头部信息
     * @return 返回验证信息
     */
    public static String checkDateTimeSmall(String firstValue, String secondValue, boolean flag, String viewTitle) {
        firstValue = StringUtils.trim(firstValue);
        secondValue = StringUtils.trim(secondValue);
        StringBuffer message = new StringBuffer();

        if (StringUtils.isNotEmpty(firstValue) && StringUtils.isNotEmpty(secondValue)) {
            long firstTime = DateTimeUtil.stringToLong(firstValue, DateTimeEnum.YYYY_MM_DD.getCode());
            long secondTime = DateTimeUtil.stringToLong(secondValue, DateTimeEnum.YYYY_MM_DD.getCode());
            if (flag) {
                if (firstTime <= secondTime) {
                    String first = viewTitle.split("@")[0];
                    String second = viewTitle.split("@")[1];
                    message.append(first).append("不能比").append(second).append("大!");
                }
            } else {
                if (firstTime < secondTime) {
                    String first = viewTitle.split("@")[0];
                    String second = viewTitle.split("@")[1];
                    message.append(first).append("不能比").append(second).append("大!");
                }
            }
        }

        return message.toString();
    }

    /**
     * 验证大于当前时间
     *
     * @param timestamp     当前时间
     * @param dateTimeValue 传入的时间
     * @param viewTitle     错误显示头部信息
     * @return 返回验证信息
     */
    public static String checkBigCurrentTime(Timestamp timestamp, String dateTimeValue, String viewTitle) {
        dateTimeValue = StringUtils.trim(dateTimeValue);
        StringBuffer message = new StringBuffer();

        long dateTime = DateTimeUtil.stringToLong(dateTimeValue, DateTimeEnum.YYYY_MM_DD.getCode());
        if (dateTime > timestamp.getTime()) {
            String first = viewTitle.split("@")[0];
            String second = viewTitle.split("@")[1];
            message.append(first).append("不能大于").append(second).append(", 请重新输入!");
        }

        return message.toString();
    }

    /**
     * 验证小于当前时间
     *
     * @param timestamp     当前时间
     * @param dateTimeValue 传入的时间
     * @param viewTitle     错误显示头部信息
     * @return 返回验证信息
     */
    public static String checkSmallCurrentTime(Timestamp timestamp, String dateTimeValue, String viewTitle) {
        dateTimeValue = StringUtils.trim(dateTimeValue);
        StringBuffer message = new StringBuffer();

        long dateTime = DateTimeUtil.stringToLong(dateTimeValue, DateTimeEnum.YYYY_MM_DD.getCode());
        if (dateTime < timestamp.getTime()) {
            String first = viewTitle.split("@")[0];
            String second = viewTitle.split("@")[1];
            message.append(first).append("不能小于").append(second).append(", 请重新输入!");
        }

        return message.toString();
    }

    /**
     * 验证字符串是否含有中文
     *
     * @param value 被验证的字符串
     * @return 如果有中文，则返回true，否则返回false
     */
    public static boolean checkChineseString(String value) {
        boolean chineseFlag = false;
        String message = CommonCheckUtil.checkPartChineseValidationThreeAll(value, false, 0);
        if (StringUtils.isEmpty(message)) {
            //为空说明有中文
            chineseFlag = true;
        }
        return chineseFlag;
    }

}
