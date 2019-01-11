package cn.qian.strategy;

/**
 * Created by 千里明月 on 2018/12/18.
 */
public class SwingFlyBehavior implements FlyBehaviorInter {

    @Override
    public void fly() {
        System.out.println("本鸭子会飞！");
        System.out.println("展翅飞翔");
    }
}
