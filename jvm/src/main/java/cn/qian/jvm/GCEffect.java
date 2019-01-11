package cn.qian.jvm;

/**
 * Created by 千里明月 on 2019/1/4.
 * 测试gc启动时对程序的影响  结果 测试不到 哎
 */
public class GCEffect {
    public static void main(String[] args) throws InterruptedException {
        System.gc();
        int i=10;
        while (true){
            if (i==0){
                break;
            }
            long timeMillis = System.currentTimeMillis();
            i--;
            byte[] bytes = new byte[10*1024*1024];
            System.out.println(i+"==="+timeMillis);
            Thread.sleep(100);
        }
    }
}
