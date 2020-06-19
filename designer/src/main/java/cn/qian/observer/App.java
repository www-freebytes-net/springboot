package cn.qian.observer;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 10:43
 */

/**
 * 观察者模式
 * 1.观察者模式 主要分为两个主体  观察者 和  通知者  ，在某些行为触发时，通知者将会通知观察者。
 * 2. 观察者需要将自己的对象交给通知者，以便通知者能够调用观察者的方法，进行通知行为。
 * 3.  观察者和通知者是多对一的关系。
 * 4. 这种模式的缺点在于  当其中一个观察者的方法执行阻塞 ，会影响后通知者对后续观察者的通知
 *    而且 观察者的被通知行为只能统一，即类似Lijiabing和Liuyawen他们的被通知行为只能写在update方法中，也只有这个方法能被通知者调用。
 *    但是如果要保证通知方法的多样性，要怎么做呢？这就要考虑到对通知方法的解耦了  （委托事件模式）
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        //构建两个观察者  嘉冰和亚文  实现Observer
        Lijiabing jiabing = new Lijiabing();
        Liuyawen yawen = new Liuyawen();

        jiabing.watchTV();
        yawen.game();

        //构建一个通知者 小莹
        Noticer bixiaoying = new Bixiaoying();

        bixiaoying.addObserver(jiabing);
        bixiaoying.addObserver(yawen);

        Thread.sleep(1000);

        //构建一个触发行为
        System.out.println("陈老板来了");
        bixiaoying.notifyAllObserver();
    }
}
