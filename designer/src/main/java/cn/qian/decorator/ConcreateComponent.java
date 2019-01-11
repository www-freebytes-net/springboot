package cn.qian.decorator;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class ConcreateComponent extends Component {

    @Override
    public void operation() {
        System.out.println("具体操作");
    }

}
