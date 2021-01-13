package net.freebytes.multithread.synchronize;

/**
 * @date: 2020/7/10 19:02
 */
public class TestSynchronize6 {
    public static void main(String[] args) {
        TestSynchronize6 test = new TestSynchronize6();
        Thread6 thread6 = new Thread6(test);
        thread6.start();
        Thread66 thread66 = new Thread66(test);
        thread66.start();
    }

    synchronized void test1() throws InterruptedException {
        System.out.println("线程进入test1----");
        Thread.sleep(100);
        System.out.println("线程退出test1----");
    }

     void test2() throws InterruptedException {
        synchronized (TestSynchronize6.class) {
            System.out.println("线程进入test2----");
            Thread.sleep(100);
            System.out.println("线程退出test2----");
        }
    }
}

class Thread6 extends Thread {
    TestSynchronize6 test;

    public Thread6(TestSynchronize6 test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Thread66 extends Thread {
    TestSynchronize6 test;

    public Thread66(TestSynchronize6 test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

