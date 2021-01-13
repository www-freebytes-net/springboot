package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/7 13:39
 */
public class TestSynchronize2 {
    public static int count = 0;
    public static TestSynchronize2 test=new TestSynchronize2();
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread2 thread = new Thread2();
            thread.start();
        }
        while (Thread.activeCount() > 1) {
        }
        System.out.println(count);
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        synchronized (TestSynchronize2.test) {
            //锁住了一个对象，理论上任何对象都可以
            for (int i = 0; i < 1000; i++) {
                TestSynchronize2.count++;
            }
        }
    }
}


