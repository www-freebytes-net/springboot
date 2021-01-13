package net.freebytes.multithread.volaite;

/**
 * @date: 2020/7/3 16:22
 */
public class TestVolatie1 {

    public static  boolean remark = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestA());
        thread.start();
        Thread.sleep(1000);
        remark = true;
    }
}

class TestA implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (TestVolatie1.remark) {
                System.out.println("触发方法");
            }
        }
    }
}
