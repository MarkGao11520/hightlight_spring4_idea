package com.wisely.highlight_spring4.ch2;

import com.wisely.highlight_spring4.ch2.el.ElConfig;
import com.wisely.highlight_spring4.ch2.el.ResourceConfig;
import com.wisely.highlight_spring4.ch2.prepost.BeanWayService;
import com.wisely.highlight_spring4.ch2.prepost.JSR250WayService;
import com.wisely.highlight_spring4.ch2.prepost.PrePostCinfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ResourceConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();
        context.close();
    }


}
