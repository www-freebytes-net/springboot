package net.freebytes.multithread.join;

/**
 * @date: 2020/7/15 16:40
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.start();
        threadJoin.join(1000);
        System.out.println("main结束----------");
    }
}

class ThreadJoin extends Thread {
//    @Override
//    public  void run() {
//        System.out.println("线程开始-------");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("线程结束-------");
//    }

    @Override
    public synchronized void run() {
        System.out.println("线程开始-------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束-------");
    }
}
