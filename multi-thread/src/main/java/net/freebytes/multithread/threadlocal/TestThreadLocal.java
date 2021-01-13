package net.freebytes.multithread.threadlocal;

/**
 * @date: 2020/7/15 17:35
 */
public class TestThreadLocal {
    public static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) {
        ThreadLocal1 local1 = new ThreadLocal1();
        ThreadLocal2 local2 = new ThreadLocal2();
        local1.start();
        local2.start();
    }
}

class ThreadLocal1 extends Thread {
    @Override
    public void run() {
        TestThreadLocal.local.set(Thread.currentThread().getName());
        System.out.println(TestThreadLocal.local);
        System.out.println(TestThreadLocal.local.get());
    }
}

class ThreadLocal2 extends Thread {
    @Override
    public void run() {
        TestThreadLocal.local.set(Thread.currentThread().getName());
        System.out.println(TestThreadLocal.local);
        System.out.println(TestThreadLocal.local.get());
    }
}
