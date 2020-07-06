package net.freebytes.multithread;

/**
 * @date: 2020/7/4 19:25
 */
public class TestVolatile2 {
    static volatile boolean remark = false;

    public static void main(String[] args) {
        new Thread(new TestThread()).start();
        new TestVolatile2().doSomeThing();
        remark = true;
    }

    private void doSomeThing() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestThread implements Runnable{
    @Override
    public void run() {
        while (!TestVolatile2.remark){
            System.out.println("正在上班.....");
        }
        System.out.println("下班了！！！");
    }
}
