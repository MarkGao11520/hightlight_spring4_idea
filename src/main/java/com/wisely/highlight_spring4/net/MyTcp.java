package com.wisely.highlight_spring4.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class MyTcp {
    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;

    void getServer() {
        try {
            server = new ServerSocket(8998);  //实例化Socket对象
            System.out.println("服务器端套机子已经创建成功");
            while (true) {                        //如果套接字是链接状态
                System.out.println("等待客户机的链接");
                socket = server.accept();         //实例化Socket对象
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));   //实例化BufferedReader对象
                getClientMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getClientMessage() {
        try {
            while (true) {  //如果套接字是连接状态
                System.out.println("客户机：" + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(reader != null)
                reader.close();  //关闭流
            if(socket != null)
                socket.close();  //关闭套接字
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTcp tcp = new MyTcp();
        tcp.getServer();
    }
}
