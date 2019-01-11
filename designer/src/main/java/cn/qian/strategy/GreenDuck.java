package cn.qian.strategy;

/**
 * Created by 千里明月 on 2018/12/18.
 */
public class GreenDuck extends Duck {

    protected void fly() {
        flyBehaviorInter.fly();
    }

}
