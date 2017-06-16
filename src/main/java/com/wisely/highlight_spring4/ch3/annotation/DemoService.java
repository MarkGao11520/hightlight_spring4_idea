package com.wisely.highlight_spring4.ch3.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/3.
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样活得的bean");
    }
}
