package com.wisely.highlight_spring4.proxy.jdkproxy;

import com.wisely.highlight_spring4.proxy.RealSubject;
import com.wisely.highlight_spring4.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by gaowenfeng on 2017/8/7.
 */
public class Main {
    public static void main(String[] args) {
        Subject target = new RealSubject();
        Subject proxy = (Subject) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                               target.getClass().getInterfaces(),
                                               new ProxyHandler(target));
        proxy.request("abcd");
        proxy.request("bcd");
    }
}
