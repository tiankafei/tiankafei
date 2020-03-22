package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * VERIFYCH函数
 * 描述：能检测的功能有：
 * (1)用于检查字符串中的中文个数
 * (2)是否出现特定的字符
 * (3)是否必须全为汉字
 * 语法：VERIFYCH(单元格/行/列,最少汉字个数,关键词,是否全为中文)。
 * 例如：VERIFYCH([3|2],"2","北京","1")
 * VERIFYCH([3|2],"0","","0")
 * VERIFYCH([3|2],"2","公司","0")
 * ....
 * 参数说明：有四个参数
 * (1)待检验的[单元格/行/列]
 * (2)[单元格/行/列] 中汉字最少必须有多少个
 * (3)指明要判断是否在[单元格/行/列] 中出现的特定字符
 * (4)[单元格/行/列] 是否必须全是汉字 "1" 表示全为汉字 "0" 表示不全为汉字
 *
 * @author tiankafei
 */
public class VerifychOperation extends BaseMoreOperation {

    private VerifychOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new VerifychOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        int number4 = 4;
        if (length == number4) {
            Object stringValueObj = dataList.get(0);
            Object stringSizeObj = dataList.get(1);
            Object matchCharObj = dataList.get(2);
            Object allCHObj = dataList.get(3);
            if (stringValueObj == null || stringSizeObj == null || matchCharObj == null || allCHObj == null) {
                return Boolean.FALSE;
            }

            //待校验字符串
            String stringValue = stringValueObj.toString();
            //要匹配的字符个数
            String stringSize = stringSizeObj.toString();
            //是否需要匹配字符
            String matchChar = matchCharObj.toString();
            //是否必须全为汉字
            String allCH = allCHObj.toString();

            //指定汉字的个数
            int size = 0;
            if (StringUtils.isNotEmpty(stringSize)) {
                size = Integer.parseInt(stringSize);
            }
            if (StringUtils.isEmpty(stringValue)) {
                if (size == 0) {
                    if (StringUtils.isNotEmpty(matchChar)) {
                        if (StringUtils.isNotEmpty(allCH)) {
                            if ("1".equals(allCH)) {
                                return Boolean.FALSE;
                            } else {
                                return Boolean.TRUE;
                            }
                        } else {
                            return Boolean.FALSE;
                        }
                    } else {
                        if (StringUtils.isNotEmpty(allCH)) {
                            if ("1".equals(allCH)) {
                                return Boolean.FALSE;
                            } else {
                                return Boolean.TRUE;
                            }
                        } else {
                            return Boolean.TRUE;
                        }
                    }
                } else {
                    return Boolean.FALSE;
                }
            } else {
                if (size == 0) {
                    if (StringUtils.isNotEmpty(matchChar)) {
                        if (matchChar(stringValue, matchChar)) {
                            if (StringUtils.isNotEmpty(allCH)) {
                                return isAllChinese(stringValue, allCH);
                            } else {
                                return Boolean.TRUE;
                            }
                        } else {
                            return Boolean.FALSE;
                        }
                    } else {
                        if (StringUtils.isNotEmpty(allCH)) {
                            return isAllChinese(stringValue, allCH);
                        } else {
                            return Boolean.TRUE;
                        }
                    }
                } else {
                    if (getChineseCharNum(stringValue) >= size) {
                        if (StringUtils.isNotEmpty(matchChar)) {
                            if (matchChar(stringValue, matchChar)) {
                                if (StringUtils.isNotEmpty(allCH)) {
                                    return isAllChinese(stringValue, allCH);
                                } else {
                                    return Boolean.TRUE;
                                }
                            } else {
                                return Boolean.FALSE;
                            }
                        } else {
                            if (StringUtils.isNotEmpty(allCH)) {
                                return isAllChinese(stringValue, allCH);
                            } else {
                                return Boolean.TRUE;
                            }
                        }
                    } else {
                        return Boolean.FALSE;
                    }
                }
            }
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    /**
     * 检验字符串中是否出现特定的字符
     *
     * @param stringValue
     * @param matchChar
     * @return
     */
    private boolean matchChar(String stringValue, String matchChar) {
        return Boolean.valueOf(stringValue.indexOf(matchChar) >= 0);
    }

    /**
     * 判断是否全是汉字
     *
     * @param stringValue
     * @param allCH
     * @return
     */
    private static boolean isAllChinese(String stringValue, String allCH) {
        if ("1".equals(allCH)) {
            //必须全是汉字
            String regex = "[\u4e00-\u9fa5]{" + stringValue.length() + "}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(stringValue);
            return Boolean.valueOf(matcher.matches());
        }
        return Boolean.valueOf(true);
    }

    /**
     * 获得中文字符的个数
     *
     * @param texts
     * @return
     */
    private static int getChineseCharNum(String texts) {
        if (texts == null) {
            return 0;
        }
        if ("".equals(texts)) {
            return 0;
        }
        int count = 0;
        char[] ch = texts.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String tmp = String.valueOf(ch[i]);
            if (isChinese(tmp)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断是否是中文
     *
     * @param text
     * @return
     */
    private static boolean isChinese(String text) {
        if (StringUtils.isEmpty(text)) {
            return false;
        }
        StringBuffer regex = new StringBuffer("[\u4e00-\u9fa5]{").append(text.length()).append("}");
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

}
