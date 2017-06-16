package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class LogAfter implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(objects[0]+"审核数据完成");
    }
}
