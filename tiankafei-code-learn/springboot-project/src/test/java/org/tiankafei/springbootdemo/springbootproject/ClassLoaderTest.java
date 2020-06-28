package org.tiankafei.springbootdemo.springbootproject;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ClassLoaderTest {

    @Test
    public void test01() throws IOException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println("-----------------------------------------------");

        // 获取当前类的包名下面的地址
        URL resource = ClassLoaderTest.class.getResource("");
        System.out.println(resource);
        System.out.println("-----------------------------------------------");

        // 获取classpath中的包路径地址
        String factoriesResourceLocation = SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION;
        Enumeration<URL> resources = ClassLoaderTest.class.getClassLoader().getResources(factoriesResourceLocation);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            UrlResource urlResource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(urlResource);
            System.out.println(url.toString());
            System.out.println(properties);
            System.out.println("-----------------------------------------------");
        }

    }

}
