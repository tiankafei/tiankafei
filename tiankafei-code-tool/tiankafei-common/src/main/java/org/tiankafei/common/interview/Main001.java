package org.tiankafei.common.interview;

public class Main001 {

    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMoney();
        }

        public void showMoney() {
            System.out.println("father : i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMoney();
        }

        @Override
        public void showMoney() {
            System.out.println("father : i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("this gay has $" + gay.money);
    }

}
