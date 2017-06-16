package com.wisely.highlight_spring4.activiti;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TaskListenerImpl implements JavaDelegate {

	ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
	TaskService taskService = context.getBean(TaskService.class);


	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		System.out.println("12324asdsfdgdfasdfshk");
	}


}
