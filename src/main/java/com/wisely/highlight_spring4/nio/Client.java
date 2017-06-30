package com.wisely.highlight_spring4.nio;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class Client {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));

            while (!socketChannel.finishConnect()) {
                System.out.println("正在连接。。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("连接成功！开始发送数据。。。");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = "高文峰";

            buffer.clear();
            buffer.put(name.getBytes());

            buffer.flip();
            while (buffer.hasRemaining())
                socketChannel.write(buffer);
            buffer.clear();

            System.out.println("发送数据成功！");

            int read;

            while (true) {
                if((read=socketChannel.read(buffer))>0) {
                    System.out.println("read:" + read);
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.print((char) buffer.get());
                    }
                    System.out.println();
                    break;
                }else {
                    System.out.println("等待服务器端返回数据。。。。");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("接收返回数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("连接关闭！");
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
