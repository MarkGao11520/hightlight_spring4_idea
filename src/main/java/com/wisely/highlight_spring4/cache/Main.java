package com.wisely.highlight_spring4.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gaowenfeng on 2017/4/30.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CacheConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user1 = userService.getUser(1);
        System.out.println(user1);
        User user2 = userService.getUser(2);
        System.out.println(user2);
//        userService.putUser(new User(3,"gzf"));
//        User user3 = userService.getUser(3);
//        System.out.println(user3);
//        userService.removeUser(3);
//        User user4 = userService.getUser(3);
//        System.out.println(user4);
    }
}
