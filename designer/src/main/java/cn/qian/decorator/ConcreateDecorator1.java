package cn.qian.decorator;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class ConcreateDecorator1 extends Decorator {

    public ConcreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰操作1........");
        super.operation();
    }

}
