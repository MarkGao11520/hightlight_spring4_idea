package com.wisely.highlight_spring4.activiti.customconfiguration;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.apache.poi.hssf.record.formula.functions.T;

/**
 * Created by gaowenfeng on 2017/6/7.
 */
public class InterceptorA implements CommandInterceptor {
    private CommandInterceptor nextInterceptor;
    private CommandInterceptor nextMyInterceptor;

    InterceptorA(CommandInterceptor myInterceptor){
        this.nextMyInterceptor = myInterceptor;
    }

    InterceptorA(){}

    @Override
    public <T> T execute(CommandConfig commandConfig, Command<T> command) {
        System.out.println("this is interceport A "+command.getClass().getName());
        if(nextMyInterceptor!=null){
            nextMyInterceptor.execute(commandConfig,command);
        }
        if(getNext()!=null) {
            return getNext().execute(commandConfig, command);
        }else {
            return null;
        }
    }

    @Override
    public CommandInterceptor getNext() {
        return nextInterceptor;
    }

    @Override
    public void setNext(CommandInterceptor commandInterceptor) {
        nextInterceptor = commandInterceptor;
    }


}
