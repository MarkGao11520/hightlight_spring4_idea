package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class FunctionService {
    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String sayHello(String word){
        return "Hello "+ word +" !!!";
    }
}
