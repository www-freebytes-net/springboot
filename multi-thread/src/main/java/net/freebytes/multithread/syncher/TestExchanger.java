package net.freebytes.multithread.syncher;

import java.util.concurrent.Exchanger;

/**
 * @date: 2020/7/23 18:08
 */
public class TestExchanger {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();
        Thread businessman = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String product="游戏机卡带";
                    System.out.println("商人出售"+product);
                    String exchange = exchanger.exchange(product);
                    System.out.println("商人获得"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String price="100元";
                    System.out.println("消费者付给商人"+price+"-----------------");
                    Thread.sleep(2000);
                    String exchange = exchanger.exchange(price);
                    System.out.println("消费者获得"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        businessman.start();
        consumer.start();
    }
}
