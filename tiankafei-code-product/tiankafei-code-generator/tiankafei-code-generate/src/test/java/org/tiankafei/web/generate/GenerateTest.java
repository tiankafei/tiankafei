package org.tiankafei.web.generate;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class GenerateTest {

    @Test
    public void test01() {
        // 测试mybatis plus提供的自定义ID生成器自3.3.0开始,默认使用雪花算法+UUID(不含中划线)
        DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();
        System.out.println(defaultIdentifierGenerator.nextId(null));
        System.out.println(defaultIdentifierGenerator.nextId(null));
        System.out.println(defaultIdentifierGenerator.nextId(null));
        System.out.println(defaultIdentifierGenerator.nextId(null));
    }

}
