package com.wisely.highlight_spring4.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/9.
 */
public class AcParalletGetWay {
    ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
    IdentityService identityService = context.getBean(IdentityService.class);
    TaskService taskService = context.getBean(TaskService.class);
    RuntimeService runtimeService = context.getBean(RuntimeService.class);
    HistoryService historyService = context.getBean(HistoryService.class);
    RepositoryService repositoryService = context.getBean(RepositoryService.class);
    /**部署流程定义+启动流程实例*/
//    @Test
    public void deployementAndStartProcess(){
        //部署流程定义
        Deployment deployment = repositoryService//
                .createDeployment()//创建部署对象
                .addClasspathResource("diagrams/parallelGateWay.bpmn")//部署加载资源文件
                .addClasspathResource("diagrams/parallelGateWay.png")//
                .name("并行网关演示")
                .deploy();
        System.out.println("部署ID："+deployment.getId());
        //启动流程实例
        ProcessInstance pi = runtimeService//
                .startProcessInstanceByKey("parallelGateWay");//使用流程定义的key的最新版本启动流程
        System.out.println("流程实例ID："+pi.getId());
        System.out.println("流程定义的ID："+pi.getProcessDefinitionId());
    }

    /**查询我的个人任务*/
   // @Test
    public void findPersonalTaskList(){
        //任务办理人
        String assignee = "买家";//或商家
        List<Task> list = taskService//
                .createTaskQuery()//
                .taskAssignee(assignee)//个人任务的查询
                .list();
        if(list!=null && list.size()>0){
            for(Task task:list){
                System.out.println("任务ID："+task.getId());
                System.out.println("任务的办理人："+task.getAssignee());
                System.out.println("任务名称："+task.getName());
                System.out.println("任务的创建时间："+task.getCreateTime());
                System.out.println("流程实例ID："+task.getProcessInstanceId());
                System.out.println("#######################################");
            }
        }
    }

    @Test
    public void completeTask(){
        //任务ID
        String taskId = "170002";
        taskService//
                .complete(taskId);
        System.out.println("完成任务："+taskId);
    }
}
