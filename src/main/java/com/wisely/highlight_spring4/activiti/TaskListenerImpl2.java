package com.wisely.highlight_spring4.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerImpl2 implements TaskListener{

	@Override
	public void notify(DelegateTask arg0) {
		// TODO Auto-generated method stub
		arg0.setAssignee("高振芳");
	}

}
