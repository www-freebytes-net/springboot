package cn.qian.observer;

import java.util.Observer;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:01
 */
public interface Noticer {
    void addObserver(Observer jiabing);

    void notifyAllObserver();
}
