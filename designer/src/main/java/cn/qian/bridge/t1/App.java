package cn.qian.bridge.t1;

/**
 * Created by 千里明月 on 2019/1/8.
 */

/**
 * 适合使用桥接模式的需求
 */
public class App {
    public static void main(String[] args) {
        Shape redSquareShape = new RedSquareShape();
        Shape yellowSquareShape = new YellowSquareShape();
        redSquareShape.dopaint();
        yellowSquareShape.dopaint();
    }
}
