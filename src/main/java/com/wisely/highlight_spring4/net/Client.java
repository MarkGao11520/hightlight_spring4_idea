package com.wisely.highlight_spring4.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class Client {
    Socket socket;
    PrintWriter writer;
    public void connect(){
        System.out.println("尝试连接");
        try {
            socket = new Socket("127.0.0.1",8998);//实例化socket对象

            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("完成连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.next();
            System.out.println("str:"+str);
            client.writer.println(str);
        }
    }
}
