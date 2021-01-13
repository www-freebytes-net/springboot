package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/7 13:39
 */
public class TestSynchronize5 {

    public static void main(String[] args) {
        Service1 service1 = new Service1();
        service1.start();
        Service2 service2 = new Service2();
        service2.start();
    }
}

class Service1 extends Thread {
    @Override
    public void run() {
        //即使两个不同的线程，由于用了同一个锁，也会实现同步的效果
        synchronized (TestSynchronize5.class) {
            System.out.println("线程---"+Thread.currentThread().getName()+"---进入");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程---"+Thread.currentThread().getName()+"---退出");
        }
    }
}

class Service2 extends Thread {
    @Override
    public void run() {
        //即使两个不同的线程，由于用了同一个锁，也会实现同步的效果
        synchronized (TestSynchronize5.class) {
            System.out.println("线程---"+Thread.currentThread().getName()+"---进入");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程---"+Thread.currentThread().getName()+"---退出");
        }
    }
}

