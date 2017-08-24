package com.wisely.highlight_spring4.ch1.aop;

import com.alibaba.fastjson.JSON;
import com.wisely.highlight_spring4.cache.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.MyAction)")
    public void annotationPointCut(){}

    @AfterReturning(pointcut = "annotationPointCut()",returning = "returnStr")
    public void afterReturning(JoinPoint joinPoint,String returnStr){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAction myAction = method.getAnnotation(MyAction.class);
        System.out.println("returnStr:"+returnStr);
        System.out.println("注解式拦截 afterReturning "+myAction.name());
    }

    @After(value = "annotationPointCut()")
    public void after(JoinPoint joinPoint){
//        System.out.println(joinPoint.getTarget().getClass().getName());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAction myAction = method.getAnnotation(MyAction.class);
        System.out.println("注解式拦截 after "+myAction.name());
    }


    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法式拦截 before "+method.getName());
    }

//    @Around("annotationPointCut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("123");
//        joinPoint.proceed();
//        System.out.println("456");
//    }

    @AfterThrowing(pointcut = "annotationPointCut()",throwing = "e")
    public void throwing(RuntimeException e){
        System.out.println("出现异常");
        System.out.println(e.getMessage());

    }

}
