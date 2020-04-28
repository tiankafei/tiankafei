package cn.tiankafei.spring;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest13 {

    /**
     * 配置bean对象初始化方法的前后处理方法
     */
    @Test
    public void test01() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc12.xml");
        DataSource dataSource = (DataSource) context.getBean("druidDataSource");
        System.out.println(dataSource.getConnection());

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test02() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc12.xml");
        DataSource dataSource = (DataSource) context.getBean("c3p0DataSource");
        System.out.println(dataSource.getConnection());

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }


}
