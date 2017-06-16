package com.wisely.highlight_spring4.print;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gaowenfeng on 2017/3/23.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Printer printer = context.getBean(Printer.class);
        printer.print("122qwhjkashfjkfhdsjkfssdjkdgjfhdfjkagsjsf");
    }
}
