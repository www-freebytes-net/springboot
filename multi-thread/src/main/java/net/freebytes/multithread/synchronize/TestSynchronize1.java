package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/7 13:39
 */
public class TestSynchronize1 {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread1 thread = new Thread1();
            thread.start();
        }
        while (Thread.activeCount() > 1) {
        }
        System.out.println(count);
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
//        synchronized (Object.class) {
        synchronized (TestSynchronize1.class) {
            //锁住一个class类，理论上任何class都可以
            for (int i = 0; i < 1000; i++) {
                TestSynchronize1.count++;
            }
        }
    }
}


