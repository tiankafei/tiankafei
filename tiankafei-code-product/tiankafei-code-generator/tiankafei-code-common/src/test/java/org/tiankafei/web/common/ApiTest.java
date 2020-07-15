package org.tiankafei.web.common;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import java.util.List;
import org.junit.Test;
import org.tiankafei.web.common.api.ApiResult;

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
    public void test02(){
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

}
