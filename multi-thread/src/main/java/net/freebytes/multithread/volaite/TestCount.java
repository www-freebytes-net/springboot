package net.freebytes.multithread.volaite;

/**
 * @date: 2020/7/3 20:12
 */
public class TestCount {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new TestC());
            thread.start();
        }
        while (Thread.activeCount() > 1) {
        }
        System.out.println(count);
    }

    String message="freebytes.net";
    public void test() {
        System.out.println(message);                          //语句1
        doSomething();                      //语句2
        message = "www.freebytes.net";     //语句3
    }

    private void doSomething() {
    }
}

class TestC implements Runnable {
    private static String lock = "";

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock) {
                TestCount.count++;
            }
        }
    }
}
