package cn.qian.decorator;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class Decorator extends Component {

    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
