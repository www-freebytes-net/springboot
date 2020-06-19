package cn.qian.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:01
 */
public class Liuyawen implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("亚文关掉游戏");
    }
    void game(){
        System.out.println("亚文打游戏");
    }
}
