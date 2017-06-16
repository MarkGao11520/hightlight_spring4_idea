package com.wisely.highlight_spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Service
public class UseFunctionService {
    @Autowired
    FunctionService functionService1;

    public String SayHello(String word){
        return functionService1.sayHello(word);
    }
}
