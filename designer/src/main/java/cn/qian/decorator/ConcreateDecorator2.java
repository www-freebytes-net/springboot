package cn.qian.decorator;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class ConcreateDecorator2 extends Decorator {
    public ConcreateDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("具体操作2..........");
    }
}
