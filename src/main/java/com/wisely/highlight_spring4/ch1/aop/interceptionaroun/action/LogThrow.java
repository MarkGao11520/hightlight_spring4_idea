package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class LogThrow implements ThrowsAdvice{
    public void afterThrowing(Method method,Object[] args,Object target,Throwable subclass){
        System.out.println("审核有异常抛出");
    }
}
