package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Month extends MoreParamFunction {

    public static Map<String, String> DCPLDYGX_Map = new HashMap<String, String>();

    public static List<String> pdPrefixList = new ArrayList<>();
    public static List<String> pdSuffixList = new ArrayList<>();

    static {
        DCPLDYGX_Map.put("TD_01TD", "01");
        DCPLDYGX_Map.put("TD_02TD", "01");
        DCPLDYGX_Map.put("TD_03TD", "01");
        DCPLDYGX_Map.put("TD_04TD", "02");
        DCPLDYGX_Map.put("TD_05TD", "02");
        DCPLDYGX_Map.put("TD_06TD", "02");
        DCPLDYGX_Map.put("TD_07TD", "03");
        DCPLDYGX_Map.put("TD_08TD", "03");
        DCPLDYGX_Map.put("TD_09TD", "03");
        DCPLDYGX_Map.put("TD_10TD", "04");
        DCPLDYGX_Map.put("TD_11TD", "04");
        DCPLDYGX_Map.put("TD_12TD", "04");
        DCPLDYGX_Map.put("TD_13TD", "05");
        DCPLDYGX_Map.put("TD_14TD", "05");
        DCPLDYGX_Map.put("TD_15TD", "05");
        DCPLDYGX_Map.put("TD_16TD", "06");
        DCPLDYGX_Map.put("TD_17TD", "06");
        DCPLDYGX_Map.put("TD_18TD", "06");
        DCPLDYGX_Map.put("TD_19TD", "07");
        DCPLDYGX_Map.put("TD_20TD", "07");
        DCPLDYGX_Map.put("TD_21TD", "07");
        DCPLDYGX_Map.put("TD_22TD", "08");
        DCPLDYGX_Map.put("TD_23TD", "08");
        DCPLDYGX_Map.put("TD_24TD", "08");
        DCPLDYGX_Map.put("TD_25TD", "09");
        DCPLDYGX_Map.put("TD_26TD", "09");
        DCPLDYGX_Map.put("TD_27TD", "09");
        DCPLDYGX_Map.put("TD_28TD", "10");
        DCPLDYGX_Map.put("TD_29TD", "10");
        DCPLDYGX_Map.put("TD_30TD", "10");
        DCPLDYGX_Map.put("TD_31TD", "11");
        DCPLDYGX_Map.put("TD_32TD", "11");
        DCPLDYGX_Map.put("TD_33TD", "11");
        DCPLDYGX_Map.put("TD_34TD", "12");
        DCPLDYGX_Map.put("TD_35TD", "12");
        DCPLDYGX_Map.put("TD_36TD", "12");
        DCPLDYGX_Map.put("YY_01YY", "12");
        DCPLDYGX_Map.put("HY_01HY", "06");
        DCPLDYGX_Map.put("HY_02HY", "12");
        DCPLDYGX_Map.put("SS_01SS", "03");
        DCPLDYGX_Map.put("SS_02SS", "06");
        DCPLDYGX_Map.put("SS_03SS", "09");
        DCPLDYGX_Map.put("SS_04SS", "12");
        DCPLDYGX_Map.put("SA_01SA", "02");
        DCPLDYGX_Map.put("SA_02SA", "05");
        DCPLDYGX_Map.put("SA_03SA", "08");
        DCPLDYGX_Map.put("SB_04SA", "11");
        DCPLDYGX_Map.put("SB_01SB", "02");
        DCPLDYGX_Map.put("SB_02SB", "05");
        DCPLDYGX_Map.put("SB_03SB", "08");
        DCPLDYGX_Map.put("SB_04SB", "12");
        DCPLDYGX_Map.put("MM_01MM", "01");
        DCPLDYGX_Map.put("MM_02MM", "02");
        DCPLDYGX_Map.put("MM_03MM", "03");
        DCPLDYGX_Map.put("MM_04MM", "04");
        DCPLDYGX_Map.put("MM_05MM", "05");
        DCPLDYGX_Map.put("MM_06MM", "06");
        DCPLDYGX_Map.put("MM_07MM", "07");
        DCPLDYGX_Map.put("MM_08MM", "08");
        DCPLDYGX_Map.put("MM_09MM", "09");
        DCPLDYGX_Map.put("MM_10MM", "10");
        DCPLDYGX_Map.put("MM_11MM", "11");
        DCPLDYGX_Map.put("MM_12MM", "12");

        for (String str : DCPLDYGX_Map.keySet()) {
            String[] array = str.split("_");
            String pdPrefix = array[0];
            if (!pdPrefixList.contains(pdPrefix)) {
                pdPrefixList.add(pdPrefix);
            }
            String pdSuffix = array[1];
            if (!pdSuffixList.contains(pdSuffix)) {
                pdSuffixList.add(pdSuffix);
            }
        }
    }

    @Override
    public String getName() {
        return FunctionConstants.MONTH;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return super.call(env, arg1, arg2, arg3);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        int number3 = 3;
        if (length == number3) {
            Object monthObj = dataList.get(0);
            Object currentBgqObj = dataList.get(1);
            Object tagObj = dataList.get(2);
            boolean flag = monthObj != null && StringUtils.isNotBlank(monthObj.toString())
                    && currentBgqObj != null && StringUtils.isNotBlank(currentBgqObj.toString())
                    && tagObj != null && StringUtils.isNotBlank(tagObj.toString());
            if (!flag) {
                return AviatorBoolean.FALSE;
            }

            String monthStr = monthObj.toString();
            if (!FunctionUtils.isNumerics(monthStr)) {
                return AviatorBoolean.valueOf(false);
            }
            int month = Integer.valueOf(monthStr);

            String currentBgq = currentBgqObj.toString();
            String endTag = tagObj.toString();

            String currentMonth = getCurrentMonth(currentBgq);
            if ("0".equals(endTag)) {
                return AviatorBoolean.valueOf((month - 1 >= 0) && (Integer.valueOf(currentMonth) - month >= 0));
            } else if ("1".equals(endTag)) {
                return AviatorBoolean.valueOf((month - 1 >= 0) && (12 - month >= 0));
            } else if ("2".equals(endTag)) {
                return AviatorBoolean.valueOf(month - Integer.valueOf(currentMonth) >= 0 && 12 - month >= 0);
            } else {
                throw new AviatorException(getName() + "函数的截止月份参数不正确!");
            }
        }
        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
    }

    /**
     * 根据报告期的频度换算成采集月来获得当前报告期的采集月
     *
     * @param currentBgq
     * @return
     */
    private String getCurrentMonth(String currentBgq) throws AviatorException {
        if (currentBgq.length() >= 8) {
            String bgqXH = currentBgq.substring(4);
            String pddm = currentBgq.substring(currentBgq.length() - 2);
            if (pdSuffixList.contains(bgqXH) && pdPrefixList.contains(pddm)) {
                String key = pddm + "_" + bgqXH;
                return DCPLDYGX_Map.get(key);
            }
        }
        throw new AviatorException(getName() + "传入的报告期不是标准频度代码，请确认！");
    }
}
