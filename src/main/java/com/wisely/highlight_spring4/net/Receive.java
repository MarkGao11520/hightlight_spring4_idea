package com.wisely.highlight_spring4.net;

import com.wisely.highlight_spring4.dao.Main;

import java.io.IOException;
import java.net.*;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class Receive implements Runnable{
    int port;
    InetAddress group = null;
    DatagramSocket socket = null;
    boolean b =true;

    public Receive(){
        port = 9898;
        try {
            group = InetAddress.getByName("127.0.0.1");
            socket= new DatagramSocket(port);
//            socket.joinGroup(group);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            byte data[] = new byte[1024];
            DatagramPacket packet = null;
            packet = new DatagramPacket(data,data.length);
            try {
                socket.receive(packet);
                String messate = new String(packet.getData(),0,packet.getLength());
                System.out.println("正在接受内容："+messate);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            if(b = true){
//                break;
//            }
        }
    }

    public static void main(String[] args) {
        Receive receive = new Receive();
        Thread thread = new Thread(receive);
        thread.start();
    }
}
