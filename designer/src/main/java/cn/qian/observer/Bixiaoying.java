package cn.qian.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:01
 */
public class Bixiaoying implements Noticer {
    List<Observer> observers = new ArrayList<>(10);

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObserver() {
        observers.forEach(new MyConsumer());
    }

    private class MyConsumer implements Consumer<Observer> {
        @Override
        public void accept(Observer observer) {
            observer.update(null, null);
        }
    }
}
