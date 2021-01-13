package net.freebytes.multithread.syncher;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @date: 2020/7/23 16:02
 */
public class TestCountDown1 {
    //声明计数量为5的同步器
    private static CountDownLatch latch = new CountDownLatch(5);
    //声明一个线程池，数量多少并不影响
    private static ExecutorService exec = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-----------第9981界人民代表大会准备开始，有情诸位国家领导人入场-----------");
        for (int i = 1; i <= 5; i++) {
            exec.submit(() -> {
                //五个线程同时执行各自的任务，并将计数量-1
                System.out.println("领导人" + Thread.currentThread().getName() + "入场");
                latch.countDown();
            });
        }
        //同步器等待5个线程执行完毕
        latch.await();
        System.out.println("此时计数量="+latch.getCount());
        System.out.println("-----------人民代表大会正式开始-----------");
        exec.shutdown();
    }
}
