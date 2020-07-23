package org.tiankafei.web.common;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import java.awt.Color;
import org.junit.Test;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.utils.CaptchaUtil;

import java.util.List;

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
    public void test03(){
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.DEFAULT));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.ARITHMETIC));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.ARITHMETIC_ZH));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER_ZH_CN));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.NUMBER_ZH_HK));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_UPPER));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_LOWER));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_NUMBER_UPPER));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.WORD_NUMBER_LOWER));
        System.out.println(CaptchaUtil.getCaptcha(CaptchaTypeEnum.CHINESE));
    }

    @Test
    public void test04(){
        Color color = CaptchaUtil.getColor();
        System.out.println(color.getColorSpace().toString());
    }

}
