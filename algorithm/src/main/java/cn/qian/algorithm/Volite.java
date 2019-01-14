package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/14.
 */
public class Volite {
    private volatile static int value=0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
//            Thread.sleep(3);
            Thread thread = new Thread(new Vole());
            thread.start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(value);
    }

    protected static class Vole implements Runnable{

        @Override
        public void run() {
            synchronized (this){
                value++;
            }
        }
    }
}
