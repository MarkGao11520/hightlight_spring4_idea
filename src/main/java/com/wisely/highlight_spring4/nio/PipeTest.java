package com.wisely.highlight_spring4.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class PipeTest{
    static Pipe pipe;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
                try {
                    Pipe.SinkChannel sinkChannel = pipe.sink();
                    String msg = "from A";
                    ByteBuffer buffer = ByteBuffer.allocate(48);
                    buffer.clear();
                    buffer.put(msg.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining())
                        sinkChannel.write(buffer);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                    Pipe.SourceChannel sourceChannel = pipe.source();

                    ByteBuffer buffer = ByteBuffer.allocate(48);
                    int bytesRead = sourceChannel.read(buffer);
                    System.out.println("读取字节数：" + bytesRead);
                    buffer.flip();
                    while (buffer.hasRemaining())
                        System.out.print((char) buffer.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            pipe = Pipe.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }


}
