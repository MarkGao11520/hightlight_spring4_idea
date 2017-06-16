package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
//        System.out.println(useFunctionService.SayHello("java config"));
//        System.out.println(useFunctionService.functionService.test);
        FunctionService functionService = context.getBean(FunctionService.class);
        functionService.setTest("123");
        FunctionService functionService1 = context.getBean(FunctionService.class);
        System.out.println("sdf"+functionService1.getTest());
        context.close();

        int a =20;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a>>3)+ " "+(a>>3));

        System.out.println(Integer.toBinaryString(a>>>3)+ " "+(a>>>3));

        int b =-20;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b>>3)+ " "+(b>>3));

        System.out.println(Integer.toBinaryString(b>>>3)+ " "+(b>>>3));

        System.out.println(1<<30);
    }
}
