package cn.qian.bridge.t2;

/**
 * Created by 千里明月 on 2019/1/8.
 */
public abstract class Shape {
    protected Color color;

    abstract void draw();

    public void setColor(Color color) {
        this.color = color;
    }
}
