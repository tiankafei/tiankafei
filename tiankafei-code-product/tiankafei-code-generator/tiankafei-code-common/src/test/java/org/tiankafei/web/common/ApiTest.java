package org.tiankafei.web.common;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.tiankafei.base.util.FileUtil;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.service.impl.CommonCaptchaUtil;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ApiTest {

    @Test
    public void test01() {
        ApiResult ok = ApiResult.ok("错误消息");
        System.out.println(JSON.toJSONString(ok));
        ApiResult ok1 = ApiResult.ok();
        System.out.println(JSON.toJSONString(ok1));
    }

    @Test
    public void test02() {
        String filePath = "D:\\test\\x-spreadsheet功能清单.xlsx";
        ExcelReader reader = ExcelUtil.getReader(ResourceUtil.getStream(filePath));
        List<List<Object>> read = reader.read();
        read.stream().forEachOrdered(dataList -> {
            dataList.stream().forEachOrdered(data -> {
                System.out.print(data + ",");
            });
            System.out.println();
        });
    }

    @Test
    public void test03() {
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.DEFAULT));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.ARITHMETIC));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.ARITHMETIC_ZH));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER_ZH_CN));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER_ZH_HK));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_UPPER));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_LOWER));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_NUMBER_UPPER));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_NUMBER_LOWER));
        System.out.println(CommonCaptchaUtil.getCaptcha(CaptchaTypeEnum.CHINESE));
    }

    @Test
    public void test04() {
        Color color = CommonCaptchaUtil.getColor();
        System.out.println(color.getColorSpace().toString());
    }

    @Test
    public void test05(){
        FileUtil.updateFileName("D:\\downloads\\琅琊榜之风起长林", "[琅Y榜之风QC林]第", "琅琊榜之风起长林");
        FileUtil.updateFileName("D:\\downloads\\琅琊榜之风起长林", "集_bd", "");

    }

    @Test
    public void test06(){
        double initAmount = 14000;

        double amount = 0;
        for (int index = 1; index <= 40; index++) {
            if (index == 1) {
                amount = initAmount * (1 + 0.05);
            } else if (index == 2) {
                amount = (amount + 3000) * (1 + 0.05);
            } else if (index <= 5) {
                amount = (amount + 3800) * (1 + 0.05);
            } else if (index == 6) {
                amount = (amount + 4500) * (1 + 0.05);
            } else {
                amount = (amount + 4500) * (1 + 0.05);
            }

            BigDecimal bigDecimal = new BigDecimal(amount);
            double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            System.out.println("第" + index + "年：" + result);
        }
    }


}
