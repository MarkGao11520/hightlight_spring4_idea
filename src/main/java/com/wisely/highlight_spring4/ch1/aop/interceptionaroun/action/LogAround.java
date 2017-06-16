package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class LogAround implements MethodInterceptor{
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getArguments()[0]+"  开始审核数据。。。。。");
        logger.log(Level.INFO,methodInvocation.getArguments()[0]+"  开始审核数据。。。。。");
        try{
           Object result = methodInvocation.proceed();
           return result;
        }
        finally {
            System.out.println(methodInvocation.getArguments()[0]+"  审核数据结束。。。。。");
            logger.log(Level.INFO,methodInvocation.getArguments()[0]+"  审核数据结束。。。。。");
        }
    }
}
