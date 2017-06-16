package com.wisely.highlight_spring4.activiti.customconfiguration;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandContextInterceptor;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

/**
 * Created by gaowenfeng on 2017/6/7.
 */
public class TestConfiguration extends ProcessEngineConfigurationImpl {

    @Override
    protected CommandInterceptor createTransactionInterceptor() {
        CommandInterceptor interceptorB = new InterceptorB();
        CommandInterceptor interceptorA = new InterceptorA(interceptorB);
        return interceptorA;
    }

}
