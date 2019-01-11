package cn.qian.adapter;

/**
 * Created by 千里明月 on 2018/12/27.
 * 将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * <p>
 * 3. 模式中的角色
 * <p>
 * 　　3.1 目标接口（Target）：客户所期待的接口。目标可以是具体的或抽象的类，也可以是接口。
 * <p>
 * 　　3.2 需要适配的类（Adaptee）：需要适配的类或适配者类。
 * <p>
 * 　　3.3 适配器（Adapter）：通过包装一个需要适配的对象，把原接口转换成目标接口。
 */
public class App {
    public static void main(String[] args) {
        Eat eat=new EatSome();
        eat.eat();
        Eat adpter = new EatAdpter();
        adpter.eat();
    }
}

interface Eat {
    void eat();
}
class EatSome implements Eat{

    @Override
    public void eat() {
        System.out.println("什么都要吃");
    }
}

class EatPork {
    protected void eatPork() {
        System.out.println("只吃猪肉");
    }

}

class EatAdpter extends EatPork implements Eat{

    @Override
    public void eat() {
        super.eatPork();
    }
}


