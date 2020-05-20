package cn.tiankafei.springbootproject;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootProjectApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test01(){
        System.out.println(dataSource.getClass());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getInitialSize());
        System.out.println(druidDataSource.getMaxActive());
    }

}
