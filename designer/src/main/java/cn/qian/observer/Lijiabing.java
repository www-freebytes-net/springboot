package cn.qian.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:01
 */
public class Lijiabing implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("嘉冰关掉直播");
    }
    void watchTV(){
        System.out.println("嘉冰看直播");
    }
}
