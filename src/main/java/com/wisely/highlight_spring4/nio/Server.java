package com.wisely.highlight_spring4.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class Server {
    public static String sayHello(String name) {
        return "hello " + name;
    }

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            System.out.println("绑定成功。。。");
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int i = 0;
            String name = "";
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    System.out.println("客户端连接成功！");
                    socketChannel.configureBlocking(false);
                    int read;

                    while (true) {
                        if(((read = socketChannel.read(buffer))>0)) {
                            System.out.println("读取数：" + read);
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                byte b = buffer.get();
                                name += (char) b;
                            }
                            break;
                        }else {
                            System.out.println("等待客户端发送数据。。。。");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    System.out.println("读取完成！正在处理数据。。。");

                    System.out.println("处理完成！返回值：" + sayHello(name)+",开始发送。。。");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    buffer.clear();
                    buffer.put(sayHello(name).getBytes());
                    buffer.flip();

                    while (buffer.hasRemaining())
                        socketChannel.write(buffer);
                    buffer.clear();

                    System.out.println("发送完成！");

                    name = "";
                    socketChannel.close();
                } else {
                    System.out.println("等待连接。。。。");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("连接关闭！");
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
