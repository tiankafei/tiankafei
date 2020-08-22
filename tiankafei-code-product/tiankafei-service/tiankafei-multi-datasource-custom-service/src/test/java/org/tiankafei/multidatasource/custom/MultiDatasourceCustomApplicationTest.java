package org.tiankafei.multidatasource.custom;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tiankafei
 * @since 1.0w
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceCustomApplication.class)
@Slf4j
public class MultiDatasourceCustomApplicationTest {

    @Test
    public void test() throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();

        System.out.println(resultMap);
    }

}
