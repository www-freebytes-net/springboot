package cn.qian.decorator;

/**
 * Created by 千里明月 on 2018/12/25.
 */

/**
 * 装饰模式（Decorator Pattern）是一种比较常见的模式，动态地给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活
 */
public class App {
    public static void main(String[] args) {
        Decorator concreateDecorator = new ConcreateDecorator1(new ConcreateComponent());
        concreateDecorator = new ConcreateDecorator2(concreateDecorator);
        concreateDecorator.operation();
    }
}
