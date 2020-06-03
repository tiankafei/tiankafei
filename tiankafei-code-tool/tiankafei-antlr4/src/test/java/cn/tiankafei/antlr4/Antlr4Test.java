package cn.tiankafei.antlr4;

import org.junit.Test;

/**
 * @Author 魏双双
 * @Date 2020/5/9
 * @Version V1.0
 **/
public class Antlr4Test {

    @Test
    public void test01() {
        int type = 4;

        switch (type) {
            case 0:
                System.out.println(type);
                break;
            case 1:
                System.out.println(type);
                break;
            case 2:
                System.out.println(type);
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(type);
                break;
            default:
                break;
        }

    }

}
