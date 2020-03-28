package cn.tiankafei.bigdata.scala;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TestJavaMain {

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        System.out.println(outer1.name);
        outer1.testMessage();
    }

    static class Outer1 {
        private String name = "123";

        public Outer1() {
        }

        private void testMessage(){

        }
    }

}
