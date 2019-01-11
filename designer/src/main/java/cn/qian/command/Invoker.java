package cn.qian.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 千里明月 on 2018/12/25.
 */
public class Invoker {

    private List<Command> commands =new ArrayList<>(16);
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
        commands.add(command);
    }

    public void order() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
