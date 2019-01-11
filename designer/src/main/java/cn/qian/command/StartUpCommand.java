package cn.qian.command;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class StartUpCommand implements Command {

    private Receiver receiver;

    public StartUpCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
