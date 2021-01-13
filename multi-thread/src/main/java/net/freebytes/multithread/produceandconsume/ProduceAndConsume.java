package net.freebytes.multithread.produceandconsume;

/**
 * @date: 2020/7/14 17:37
 * 1个生产者与1个消费者
 */
public class ProduceAndConsume {
    /**
     * 可供消费的产品
     */
    public static volatile String value = "";

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadProduce produce = new ThreadProduce(lock);
        ThreadConsume consume = new ThreadConsume(lock);
        produce.start();
        consume.start();
    }
}

/**
 * 生产者线程
 */
class ThreadProduce extends Thread {
    private Object lock;

    public ThreadProduce(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                if (!ProduceAndConsume.value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long timeMillis = System.currentTimeMillis();
                ProduceAndConsume.value = timeMillis + "";
                System.out.println("生产线程" + Thread.currentThread().getName() + "生产了" + ProduceAndConsume.value);
                lock.notify();
            }
        }
    }
}

/**
 * 消费者线程
 */
class ThreadConsume extends Thread {
    private Object lock;

    public ThreadConsume(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                if (ProduceAndConsume.value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费线程" + Thread.currentThread().getName() + "消费了" + ProduceAndConsume.value);
                ProduceAndConsume.value = "";
                lock.notify();
            }
        }
    }
}

