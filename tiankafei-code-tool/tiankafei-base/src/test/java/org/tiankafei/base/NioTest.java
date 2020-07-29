package org.tiankafei.base;

import java.nio.ByteBuffer;
import org.junit.Test;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class NioTest {

    @Test
    public void test01(){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byteBuffer.put("123465798".getBytes());
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());
        System.out.println("执行了mark方法之后：" + byteBuffer);
        byteBuffer.flip();
        System.out.println("执行了翻转之后：" + byteBuffer);
        for (int index = 0; index < byteBuffer.limit(); index++) {
            if(index == 2){
                byteBuffer.mark();
            }
            byte x = byteBuffer.get();
            System.out.println(x);
        }
        byteBuffer.reset();
        System.out.println("执行了重置之后：" + byteBuffer);
        byteBuffer.clear();
        System.out.println("执行了清空之后：" + byteBuffer);
    }

}
