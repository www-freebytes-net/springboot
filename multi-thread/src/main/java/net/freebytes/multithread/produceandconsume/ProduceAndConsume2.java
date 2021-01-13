package net.freebytes.multithread.produceandconsume;

/**
 * @date: 2020/7/14 17:37
 * 多个生产者与多个消费者
 */
public class ProduceAndConsume2 {
    /**
     * 可供消费的商品
     */
    public static volatile String value = "";

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for (int i = 0; i < 2; i++) {
            ThreadProduce2 produce = new ThreadProduce2(lock);
            produce.setName("生产线程" + i);
            ThreadConsume2 consume = new ThreadConsume2(lock);
            consume.setName("消费线程" + i);
            produce.start();
            consume.start();
        }
    }
}

class ThreadProduce2 extends Thread {
    private Object lock;

    public ThreadProduce2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                while (!ProduceAndConsume.value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long timeMillis = System.currentTimeMillis();
                ProduceAndConsume.value = timeMillis + "";
                System.out.println(Thread.currentThread().getName() + "生产了" + ProduceAndConsume.value);
                lock.notifyAll();
            }
        }

    }
}

class ThreadConsume2 extends Thread {
    private Object lock;

    public ThreadConsume2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                while (ProduceAndConsume.value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "消费了" + ProduceAndConsume.value);
                ProduceAndConsume.value = "";
                lock.notifyAll();
            }
        }

    }
}

