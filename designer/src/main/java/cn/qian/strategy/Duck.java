package cn.qian.strategy;

/**
 * Created by 千里明月 on 2018/12/18.
 */
public class Duck {

    protected FlyBehaviorInter flyBehaviorInter;

    public void setFlyBehaviorInter(FlyBehaviorInter flyBehaviorInter) {
        this.flyBehaviorInter = flyBehaviorInter;
    }

    protected void swim() {
        System.out.println("所有鸭子都会游泳啊！！");
    }


}
