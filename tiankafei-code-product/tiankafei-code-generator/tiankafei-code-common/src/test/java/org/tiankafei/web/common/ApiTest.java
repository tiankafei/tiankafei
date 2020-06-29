package org.tiankafei.web.common;

import com.alibaba.fastjson.JSON;
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

}
