package cn.qian.jvm;

/**
 * Created by 千里明月 on 2019/1/3.
 */
public class Test1 {
    public static void main(String[] args) {
        byte[] b =null;
        for (int i = 0; i < 10; i++) {
            b=new byte[1*1024*1024];
        }
    }
}
