package com.wisely.highlight_spring4.net;

import java.io.IOException;
import java.net.*;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class Weather extends  Thread{
    String weather = "aaaa";
    int port = 9898;
    InetAddress inetAddress = null;
    DatagramSocket socket = null;
    Weather(){
        try {
            inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new DatagramSocket();
//            socket.setTimeToLive(1);
//            socket.joinGroup(inetAddress);  //加入广播组
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            DatagramPacket packet = null;  //声明DatagramPacket对象
            byte data[] = weather.getBytes();
            packet = new DatagramPacket(data,data.length,inetAddress,port);
            System.out.println(new String(data));
            try {
                socket.send(packet);
                sleep(3000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Weather w = new Weather();
        w.start();
    }
}
