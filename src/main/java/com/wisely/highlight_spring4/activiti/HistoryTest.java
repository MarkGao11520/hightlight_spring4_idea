package com.wisely.highlight_spring4.activiti;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by gaowenfeng on 2017/6/30.
 */
public class HistoryTest {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
    HistoryService historyService = context.getBean(HistoryService.class);


}
