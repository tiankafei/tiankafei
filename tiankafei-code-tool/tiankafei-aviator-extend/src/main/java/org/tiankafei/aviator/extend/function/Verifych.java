package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.extend.constant.FunctionConstants;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Verifych extends AbstractFunction {

    @Override
    public String getName() {
        return FunctionConstants.VERIFYCH;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        return this.call(env, Arrays.asList(arg1, arg2, arg3, arg4));
    }

    protected AviatorObject call(Map<String, Object> env, List<AviatorObject> valueList) {
        List<Object> dataList = new ArrayList<>();
        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            dataList.add(aviatorObject.getValue(env));
        }
        Object stringValueObj = dataList.get(0);
        Object stringSizeObj = dataList.get(1);
        Object matchCharObj = dataList.get(2);
        Object allCHObj = dataList.get(3);
        if (stringValueObj == null || stringSizeObj == null || matchCharObj == null || allCHObj == null) {
            return AviatorBoolean.FALSE;
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
                            return AviatorBoolean.FALSE;
                        } else {
                            return AviatorBoolean.TRUE;
                        }
                    } else {
                        return AviatorBoolean.FALSE;
                    }
                } else {
                    if (StringUtils.isNotEmpty(allCH)) {
                        if ("1".equals(allCH)) {
                            return AviatorBoolean.FALSE;
                        } else {
                            return AviatorBoolean.TRUE;
                        }
                    } else {
                        return AviatorBoolean.TRUE;
                    }
                }
            } else {
                return AviatorBoolean.FALSE;
            }
        } else {
            if (size == 0) {
                if (StringUtils.isNotEmpty(matchChar)) {
                    if (matchChar(stringValue, matchChar)) {
                        if (StringUtils.isNotEmpty(allCH)) {
                            return AviatorBoolean.valueOf(isAllChinese(stringValue, allCH));
                        } else {
                            return AviatorBoolean.TRUE;
                        }
                    } else {
                        return AviatorBoolean.FALSE;
                    }
                } else {
                    if (StringUtils.isNotEmpty(allCH)) {
                        return AviatorBoolean.valueOf(isAllChinese(stringValue, allCH));
                    } else {
                        return AviatorBoolean.TRUE;
                    }
                }
            } else {
                if (getChineseCharNum(stringValue) >= size) {
                    if (StringUtils.isNotEmpty(matchChar)) {
                        if (matchChar(stringValue, matchChar)) {
                            if (StringUtils.isNotEmpty(allCH)) {
                                return AviatorBoolean.valueOf(isAllChinese(stringValue, allCH));
                            } else {
                                return AviatorBoolean.TRUE;
                            }
                        } else {
                            return AviatorBoolean.FALSE;
                        }
                    } else {
                        if (StringUtils.isNotEmpty(allCH)) {
                            return AviatorBoolean.valueOf(isAllChinese(stringValue, allCH));
                        } else {
                            return AviatorBoolean.TRUE;
                        }
                    }
                } else {
                    return AviatorBoolean.FALSE;
                }
            }
        }
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
    private boolean isAllChinese(String stringValue, String allCH) {
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
    private int getChineseCharNum(String texts) {
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
    private boolean isChinese(String text) {
        if (StringUtils.isEmpty(text)) {
            return false;
        }
        StringBuffer regex = new StringBuffer("[\u4e00-\u9fa5]{").append(text.length()).append("}");
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
