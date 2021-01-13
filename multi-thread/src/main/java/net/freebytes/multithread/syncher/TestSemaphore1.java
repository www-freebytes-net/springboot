package net.freebytes.multithread.syncher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @date: 2020/7/24 10:23
 */
public class TestSemaphore1 {
    static ExecutorService pool = Executors.newCachedThreadPool();
    Semaphore semaphore = new Semaphore(5,true);

    public static void main(String[] args) {
        TestSemaphore1 testSemaphore = new TestSemaphore1();
        for (int i = 1; i <= 10; i++) {
            Runnable r = () -> testSemaphore.getMoney();
            pool.execute(r);
        }
        pool.shutdown();
    }

    public void getMoney() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "进入柜台，开始取钱");
            Thread.sleep((long) (Math.random()*10000));
            System.out.println(Thread.currentThread().getName() + "离开柜台");
            semaphore.release();
            System.out.println("------------------------------------------"+semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
