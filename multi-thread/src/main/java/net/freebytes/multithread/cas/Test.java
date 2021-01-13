package net.freebytes.multithread.cas;

public class Test {

    static int count = 0;

    public static void main(String[] argv) {
        for (int i = 0; i < 10000; i++) {
            TestThread thread = new TestThread();
            thread.start();
        }
        while (Thread.activeCount()>1){
        }
        System.out.println(count);
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        Test.count++;
    }
}
