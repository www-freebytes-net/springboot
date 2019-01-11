package cn.qian.bridge.t2;

/**
 * Created by 千里明月 on 2019/1/8.
 */

/**
 * 桥接设计模式   对t1包的设计进行维度分离，将形状和颜色分离
 */
public class App {
    public static void main(String[] args) {
        Yellow yellow = new Yellow();
        Square square = new Square();
        square.setColor(yellow);
        square.draw();
    }
}
