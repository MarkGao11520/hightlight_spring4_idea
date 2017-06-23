package com.wisely.highlight_spring4.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class Address {
    public static void main(String[] args) {
        InetAddress ip;

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("本机名："+ip.getHostName());
            System.out.println("本机IP地址："+ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * Created by gaowenfeng on 2017/6/22.
     */
    public static class Client {
    }
}
