package cn.qian.command;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class App {
    public static void main(String[] args) {
        Receiver receiver = new StartUpReceiver();
        Command command = new StartUpCommand(receiver);
        Command command1 = new ShutdownComand(new ShutdownReceiver());
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.setCommand(command1);
        invoker.order();
    }
}
