package cn.qian.delegate;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:23
 */

/**
 * 1. 委托者模式   本质上与观察者模式相同
 * 2. 主要分为三个主体   委托事件  委托者 与  通知者                 将委托事件委托给通知者，通知者在某个时刻触发委托事件
 * 通知者与委托者完全解耦
 */
public class App {
    public static void main(String[] args) {
        Lijiabing lijiabing = new Lijiabing();
        lijiabing.watchTV();
        Event event = new Event(lijiabing, "update");
        Liuyawen liuyawen = new Liuyawen();
        liuyawen.game();
        Event event1 = new Event(liuyawen, "update");

        Noticfier noticfier = new Noticfier();
        noticfier.addEvent(event);
        noticfier.addEvent(event1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("陈老板来了");

        noticfier.notifyAllEventor();

    }
}
