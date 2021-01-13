package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/7 13:39
 */
public class TestSynchronize4 {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread4 thread = new Thread4();
            thread.start();
        }
        while (Thread.activeCount() > 1) {
        }
        System.out.println(count);
    }
}

class Thread4 extends Thread {
    @Override
    public synchronized void run() {
        //看起来是锁住了一个方法，但其实等同于synchronized (this)，锁住了当前对象
        //如果该方法是静态的，那么等同于synchronized (Thread4.class)，锁住当前类的class类
        for (int i = 0; i < 1000; i++) {
            TestSynchronize4.count++;
        }
    }
}


