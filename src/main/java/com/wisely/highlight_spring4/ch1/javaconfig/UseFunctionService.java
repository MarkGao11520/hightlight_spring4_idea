package com.wisely.highlight_spring4.ch1.javaconfig;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class UseFunctionService {
    FunctionService functionService ;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}
