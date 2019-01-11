package cn.qian.command;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class ShutdownComand implements Command{
    private Receiver receiver;

    public ShutdownComand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
