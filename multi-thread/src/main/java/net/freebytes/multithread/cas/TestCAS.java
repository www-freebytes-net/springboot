package net.freebytes.multithread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date: 2020/8/1 15:52
 */
public class TestCAS {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            TestCASThread thread = new TestCASThread();
            thread.start();
        }
        while (Thread.activeCount()>1){
        }
        System.out.println(count.get());
    }
}

class TestCASThread extends Thread {
    @Override
    public void run() {
        TestCAS.count.incrementAndGet();
    }
}
