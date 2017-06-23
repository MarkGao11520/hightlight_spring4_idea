package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class Main {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
////        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
////        System.out.println(useFunctionService.SayHello("java config"));
////        System.out.println(useFunctionService.functionService.test);
//        FunctionService functionService = context.getBean(FunctionService.class);
//        functionService.setTest("123");
//        FunctionService functionService1 = context.getBean(FunctionService.class);
//        System.out.println("sdf"+functionService1.getTest());
//        context.close();
//
////        int a =20;
////        System.out.println(Integer.toBinaryString(a));
////        System.out.println(Integer.toBinaryString(a>>3)+ " "+(a>>3));
////
////        System.out.println(Integer.toBinaryString(a>>>3)+ " "+(a>>>3));
////
////        int b =-20;
////        System.out.println(Integer.toBinaryString(b));
////        System.out.println(Integer.toBinaryString(b>>3)+ " "+(b>>3));
////
////        System.out.println(Integer.toBinaryString(b>>>3)+ " "+(b>>>3));
////
////        System.out.println(1<<30);
//
////        String a = "abc";
////        String b= "abc";
////        String c = "ab";
////        String d = "c";
////        String e = c+d;
////
////        System.out.println(a==e);
//
//
//    }

    public static int aMethod(int i)throws Exception
    {
        try{
            return 10 / i;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
            return -1;
        }
    }

    public static void main(String [] args)
    {
        try
        {
            System.out.println(aMethod(1));
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}
