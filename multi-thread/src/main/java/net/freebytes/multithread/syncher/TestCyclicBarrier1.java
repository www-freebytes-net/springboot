package net.freebytes.multithread.syncher;

import java.util.concurrent.CyclicBarrier;

/**
 * @date: 2020/7/23 17:22
 */
public class TestCyclicBarrier1 {
    public static void main(String[] args) {
        int count =10;
        CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("最后一个线程到达完毕");
            }
        });
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"---------到达第1个屏障");
                        barrier.await();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"---------到达第2个屏障");
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
