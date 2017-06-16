package com.wisely.highlight_spring4.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gaowenfeng on 2017/4/30.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ClassRoom classRoom = context.getBean(ClassRoom.class);
        System.out.println(classRoom.getClassroomlist());
    }
}
