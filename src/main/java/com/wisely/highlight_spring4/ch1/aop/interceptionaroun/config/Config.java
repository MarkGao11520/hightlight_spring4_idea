package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.config;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.*;
import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.impl.TimeBookInterface;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch1.aop.interceptionaroun")
public class Config {

    @Bean
    LogAround logAround(){
        return new LogAround();
    }

    @Bean
    LogBefore logBefore(){
        return new LogBefore();
    }

    @Bean
    LogAfter logAfter(){
        return new LogAfter();
    }

    @Bean
    LogThrow logThrow(){
        return new LogThrow();
    }

    @Bean
    TimeBook timeBook(){
        return new TimeBook();
    }

    @Bean
    Financeimplements financeimplements(){
        return new Financeimplements();
    }

    @Bean
    DefaultAdvisorAutoProxyCreator autoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

//    @Bean
//    ProxyFactoryBean logAroundProxy() throws ClassNotFoundException {
//        Class<?> clazz = Class.forName("com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.TimeBook");
//        Class<?> intes[] = clazz.getInterfaces();
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setProxyInterfaces(intes);
//        proxyFactoryBean.setTarget(timeBook());
//        proxyFactoryBean.setInterceptorNames("logAround");
//        return proxyFactoryBean;
//    }
//
//    @Bean
//    ProxyFactoryBean logAroundCGLIBProxy() throws ClassNotFoundException {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setProxyTargetClass(true);
//        proxyFactoryBean.setTarget(timeBook());
//        proxyFactoryBean.setInterceptorNames("logAround");
//        return proxyFactoryBean;
//    }
//
//    @Bean
//    ProxyFactoryBean logAroundProxy1() throws ClassNotFoundException {
//        Class<?> clazz = Class.forName("com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.Financeimplements");
//        Class<?> intes[] = clazz.getInterfaces();
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setProxyInterfaces(intes);
//        proxyFactoryBean.setTarget(financeimplements());
//        proxyFactoryBean.setInterceptorNames("logBeforeAdvisor");
//        return proxyFactoryBean;
//    }

    @Bean
    RegexpMethodPointcutAdvisor logBeforeAdvisor(){
        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
        regexpMethodPointcutAdvisor.setAdvice(logBefore());
        regexpMethodPointcutAdvisor.setPatterns(".*do.*");
        return regexpMethodPointcutAdvisor;
    }

//    @Bean
//    ProxyFactoryBean logBeforeProxy() throws ClassNotFoundException {
//        Class<?> clazz = Class.forName("com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.TimeBook");
//        Class<?> intes[] = clazz.getInterfaces();
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setProxyInterfaces(intes);
//        proxyFactoryBean.setTarget(timeBook());
//        proxyFactoryBean.setInterceptorNames("logBeforeAdvisor");
//        return proxyFactoryBean;
//    }

    @Bean
    RegexpMethodPointcutAdvisor logAfterAdvisor(){
        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
        regexpMethodPointcutAdvisor.setAdvice(logAfter());
        regexpMethodPointcutAdvisor.setPatterns(".*do.*");
        return regexpMethodPointcutAdvisor;
    }
//
//    @Bean
//    ProxyFactoryBean logAfterProxy() throws ClassNotFoundException {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        Class<?> clazz = Class.forName("com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.TimeBook");
//        Class<?> intes[] = clazz.getInterfaces();
//        proxyFactoryBean.setProxyInterfaces(intes);
//        proxyFactoryBean.setTarget(timeBook());
//        proxyFactoryBean.setInterceptorNames("logAfterAdvisor");
//        return proxyFactoryBean;
//    }
//
//    @Bean
//    RegexpMethodPointcutAdvisor logThrowAdvisor(){
//        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
//        regexpMethodPointcutAdvisor.setAdvice(logThrow());
//        regexpMethodPointcutAdvisor.setPatterns(".*doAuditing.*");
//        return regexpMethodPointcutAdvisor;
//    }
//
//    @Bean
//    ProxyFactoryBean logThrowProxy() throws ClassNotFoundException {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        Class<?> clazz = Class.forName("com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.TimeBook");
//        Class<?> intes[] = clazz.getInterfaces();
//        proxyFactoryBean.setProxyInterfaces(intes);
//        proxyFactoryBean.setTarget(timeBook());
//        List<String> list = new ArrayList<String>();
//        list.add("logAfterAdvisor");
//        proxyFactoryBean.setInterceptorNames("logThrowAdvisor");
//        return proxyFactoryBean;
//    }


}
