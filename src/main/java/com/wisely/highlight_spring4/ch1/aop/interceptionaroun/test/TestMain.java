package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.test;

import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action.TimeBook;
import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.config.Config;
import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.impl.FinanceInterface;
import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.impl.TimeBookInterface;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
     //   TimeBookInterface timeBookInterface = (TimeBookInterface)context.getBean("logAroundProxy");
//        FinanceInterface financeInterface = (FinanceInterface)context.getBean("logAroundProxy1");
          TimeBookInterface timeBookInterface = (TimeBookInterface)context.getBean("timeBook");
        timeBookInterface.doAuditing("李四");
//        timeBookInterface.doCheck("张三");
//        financeInterface.doCheck("李四");
        context.close();
    }
}
