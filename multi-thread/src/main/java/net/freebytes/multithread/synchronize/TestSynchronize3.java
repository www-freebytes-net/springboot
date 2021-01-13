package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/7 13:39
 */
public class TestSynchronize3 {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread3 thread = new Thread3();
            thread.start();
        }
        while (Thread.activeCount() > 1) {
        }
        System.out.println(count);
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            //锁住了一个对象，等同于锁住了Thread3的对象本身
            for (int i = 0; i < 1000; i++) {
                TestSynchronize3.count++;
            }
        }
    }
}


