package com.wisely.highlight_spring4.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gaowenfeng on 2017/8/7.
 */
public class ProxyHandler implements InvocationHandler{
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    public void before(String param) throws Throwable{
        if(!param.startsWith("abc"))
            throw new IllegalArgumentException();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before((String) args[0]);
        return method.invoke(target,args);
    }
}
