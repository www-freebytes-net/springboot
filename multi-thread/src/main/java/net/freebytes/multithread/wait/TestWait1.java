package net.freebytes.multithread.wait;

/**
 * @date: 2020/7/13 17:43
 */
public class TestWait1 {

    public static void main(String[] args) {
        Object lock = new Object();
        new TestThread1(lock).start();
        new TestThread11(lock).start();
    }
}

class TestThread1 extends Thread {
    private Object lock;

    public TestThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("wait方法开始执行...");
            try {
                lock.wait();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait方法结束执行...");
        }
    }
}

class TestThread11 extends Thread {
    private Object lock;

    public TestThread11(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("notify方法开始执行...");
            lock.notify();
            System.out.println("notify方法结束执行...");
        }
    }
}
