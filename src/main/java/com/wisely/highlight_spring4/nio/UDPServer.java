package com.wisely.highlight_spring4.nio;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class UDPServer {
    public static void main(String[] args) {
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open();
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(9999));

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            while (true){
                SocketAddress address ;
                if ((address = channel.receive(buffer))!=null){
                    System.out.println(JSON.toJSONString(address));
                    buffer.flip();
                    while (buffer.hasRemaining())
                        System.out.print((char) buffer.get());
                    System.out.println();
                }else {
                    try {
                        Thread.sleep(1000);
                        System.out.println("等待接收中。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
