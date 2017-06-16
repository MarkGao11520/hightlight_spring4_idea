package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Service
public class DemoAnnotationService {
    @MyAction(name = "注解式拦截的add操作")
    public String abotationAdd(String name){
        System.out.println("正在添加");
//           int i =1/0;
        return "abc";
    }
}
