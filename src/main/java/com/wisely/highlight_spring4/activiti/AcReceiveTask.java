package com.wisely.highlight_spring4.activiti;


import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class AcReceiveTask {

    //流程引擎对象
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义+启动流程实例
     */
    @Test
    public void deployementAndStartProcess() {
        InputStream inputStreamBpmn = this.getClass().getResourceAsStream("diagrams/receiveTask.bpmn");
        InputStream inputStreamPng = this.getClass().getResourceAsStream("diagrams/receiveTask.png");

        //1.部署流程定义
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()//创建部署对象
                .addClasspathResource("diagrams/receiveTask.bpmn")
                .addClasspathResource("diagrams/receiveTask.png")
                .deploy();
        System.out.println("部署ID：" + deployment.getId());

        //2.启动流程实例
        ProcessInstance pi = processEngine.getRuntimeService()
                .startProcessInstanceByKey("receiveTask");//使用流程定义的key的最新版本启动流程
        System.out.println("流程实例ID:" + pi.getId());
        System.out.println("流程定义ID：" + pi.getProcessDefinitionId());

        //3.查询执行对象表,使用流程实例ID和当前活动的名称（receivetask1）
        String processInstanceId = pi.getId();//得到流程实例ID
        Execution execution1 = processEngine.getRuntimeService()
                .createExecutionQuery()
                .processInstanceId(processInstanceId)//流程实例ID
                .activityId("receivetask1-rece")//当前活动的名称
                .singleResult();

        //4.使用流程变量设置当日的销售额
        processEngine.getRuntimeService().setVariable(execution1.getId(), "当日销售额", 20000);

        try {
            System.out.println("111");
            Thread.sleep(60000);
            System.out.println("222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5.向后执行一步
        processEngine.getRuntimeService()
                .signal(execution1.getId());

        try {
            System.out.println("333");
            Thread.sleep(60000);
            System.out.println("444");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //6.查询执行对象表,使用流程实例ID和当前活动的名称（receivetask2）
        Execution execution2 = processEngine.getRuntimeService()
                .createExecutionQuery()
                .processInstanceId(processInstanceId)
                .activityId("receivetask2-rece")
                .singleResult();

        //7.获取流程变量,给老板发送短信
        Integer value = (Integer) processEngine.getRuntimeService()
                .getVariable(execution2.getId(), "当日销售额");
        System.out.println("给老板发送短信：内容，当日销售额：" + value);

        try {
            System.out.println("555");
            Thread.sleep(60000);
            System.out.println("666");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //8.向后执行一步
        processEngine.getRuntimeService()
                .signal(execution2.getId());

        try {
            System.out.println("777");
            Thread.sleep(60000);
            System.out.println("888");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //9.判断流程是否结束
        ProcessInstance nowPi = processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processInstanceId(pi.getId())
                .singleResult();
        if (nowPi == null) {
            System.out.println("流程结束");
        }
    }


}

