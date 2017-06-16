package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.*;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAction {
    String name();
}
