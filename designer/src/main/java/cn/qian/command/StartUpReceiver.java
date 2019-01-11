package cn.qian.command;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class StartUpReceiver implements Receiver {

    @Override
    public void action() {
        System.out.println("执行开机命令。。。。。。");
    }
}
