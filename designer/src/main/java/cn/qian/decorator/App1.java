package cn.qian.decorator;

/**
 * @date: 2020/7/1 20:21
 */
public class App1 {
    public static void main(String[] args) {
        new Component1().operation();
        new Decorator1(new Component1()).operation();
        new Decorator1(new Component1()).eat();
    }
}
