package cn.qian.delegate;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 执行者
 */
public class Noticfier {
    private List<Event> events = new ArrayList<>(16);

    public void addEvent(Event event) {
        events.add(event);
    }

    public void notifyAllEventor() {

        for (Event event : events) {
            event.invoke();
        }
    }

}
