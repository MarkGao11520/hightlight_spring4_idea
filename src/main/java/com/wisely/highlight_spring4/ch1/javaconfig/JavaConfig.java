package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.Bean;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
public class JavaConfig {
    @Bean
    public FunctionService functionService(){
        FunctionService functionService = new FunctionService();
//        functionService.setTest("gwf!!!");
        return functionService;
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }
}
