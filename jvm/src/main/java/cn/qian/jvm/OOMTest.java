package cn.qian.jvm;

import java.util.Vector;

/**
 * Created by 千里明月 on 2019/1/3.
 */
public class OOMTest {
    public static void main(String[] args) {
        Vector vector = new Vector<>();
        for (int i = 0; i < 25; i++) {
            vector.add(new byte[1 * 1024 * 1024]);
        }
    }
}
