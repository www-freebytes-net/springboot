package cn.qian.decorator;

/**
 * @date: 2020/7/1 20:22
 */
public class Decorator1 extends Component1{
    private Component1 component1;

    public Decorator1(Component1 component1) {
        this.component1 = component1;
    }

    @Override
    public void operation(){
        System.out.println("我是装饰者-----");
    }

    public void eat(){
        System.out.println("-------我是装饰者,我要吃遍麦当劳-----");
    }

}
