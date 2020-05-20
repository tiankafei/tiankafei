package cn.tiankafei.springbootproject;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootProjectApplicationTests {

    void contextLoads() {
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void test01(){
        System.out.println(dataSource.getClass());
    }

}
