package net.freebytes.multithread.produceandconsume;

import java.io.*;

/**
 * @date: 2020/7/15 11:13
 * 通过管道进行线程间通信
 */
public class TestPipe {
    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        inputStream.connect(outputStream);
        ThreadOut threadOut = new ThreadOut(outputStream);
        ThreadRead threadRead = new ThreadRead(inputStream);
        threadOut.start();
        threadRead.start();
    }
}

class ThreadOut extends Thread {
    PipedOutputStream out;

    public ThreadOut(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        System.out.println("write:");
        try {
            String message = "hello world! You will be destoryed";
            out.write(message.getBytes());
            System.out.println("写入数据------" + message);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadRead extends Thread {
    PipedInputStream input;

    public ThreadRead(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("read:");
        try {
            byte[] buffer = new byte[10];
            int i = -1;
            while ((i=(input.read(buffer))) != -1) {
                System.out.println("读取数据----"+new String(buffer,0,i));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}