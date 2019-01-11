package cn.qian.strategy;

/**
 * Created by 千里明月 on 2018/12/18.
 */

/**
 * 策略模式
 *
 * 在软件开发中常常遇到这种情况，实现某一个功能有多种算法或者策略，
 * 我们可以根据环境或者条件的不同选择不同的算法或者策略来完成该功能。
 * 如查找、排序等，一种常用的方法是硬编码(Hard Coding)在一个类中，
 * 如需要提供多种查找算法，可以将这些算法写到一个类中，在该类中提供多个方法，
 * 每一个方法对应一个具体的查找算法；当然也可以将这些查找算法封装在一个统一的方法中，
 * 通过if…else…或者case等条件判断语句来进行选择。这两种实现方法我们都可以称之为硬编码，
 * 如果需要增加一种新的查找算法，需要修改封装算法类的源代码；更换查找算法，
 * 也需要修改客户端调用代码。在这个算法类中封装了大量查找算法，该类代码将较复杂，维护较为困难。
 * 如果我们将这些策略包含在客户端，这种做法更不可取，将导致客户端程序庞大而且难以维护，
 * 如果存在大量可供选择的算法时问题将变得更加严重。
 */
public class App {
    public static void main(String[] args) {
        GreenDuck greenDuck = new GreenDuck();
        greenDuck.swim();
        greenDuck.setFlyBehaviorInter(new JumpFlyBehavior());
        greenDuck.fly();

        System.out.println("--------------------");

        greenDuck.swim();
        greenDuck.setFlyBehaviorInter(new SwingFlyBehavior());
        greenDuck.fly();

    }
}
