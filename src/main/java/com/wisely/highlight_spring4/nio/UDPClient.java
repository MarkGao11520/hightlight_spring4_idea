package com.wisely.highlight_spring4.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class UDPClient {
    public static void main(String[] args) {
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open();
//            channel.socket().bind(new InetSocketAddress(9998));


            String newData = "New String to write to file... "+System.currentTimeMillis();

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put(newData.getBytes());
            buffer.flip();

            int bytesSent = channel.send(buffer,new InetSocketAddress("127.0.0.1",9999));
            System.out.println("发送字节数："+bytesSent);
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
