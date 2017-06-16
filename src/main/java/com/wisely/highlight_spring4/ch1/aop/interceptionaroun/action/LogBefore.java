package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class LogBefore implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(objects[0]+"开始审核数据....");
    }
}
