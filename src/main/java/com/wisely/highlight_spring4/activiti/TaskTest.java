package com.wisely.highlight_spring4.activiti;

/**
 * Created by gaowenfeng on 2017/6/9.
 */

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class TaskTest {

    //流程引擎对象
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义+启动流程实例
     */
  //  @Test
    public void deployementAndStartProcess() {
        //部署流程定义
        Deployment deployment = processEngine.getRepositoryService()//
                .createDeployment()//创建部署对象
                .addClasspathResource("diagrams/group.bpmn")//部署加载资源文件
                .addClasspathResource("diagrams/group.png")//
                .deploy();
        System.out.println("部署ID：" + deployment.getId());
        //启动流程实例
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("userIDS", "大大,中中,小小");
        variables.put("groupIDS", "AA");
        ProcessInstance pi = processEngine.getRuntimeService()//
                .startProcessInstanceByKey("groupProcess",variables);//使用流程定义的key的最新版本启动流程
        System.out.println("流程实例ID：" + pi.getId());
        System.out.println("流程定义的ID：" + pi.getProcessDefinitionId());
    }

    /**
     * 查询我的个人任务
     */
  //  @Test
    public void findPersonalTaskList() {
        //任务办理人
        String assignee = "高振芳";
        List<Task> list = processEngine.getTaskService()//
                .createTaskQuery()//
                .taskAssignee(assignee)//个人任务的查询
                .list();
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                System.out.println("任务ID：" + task.getId());
                System.out.println("任务的办理人：" + task.getAssignee());
                System.out.println("任务名称：" + task.getName());
                System.out.println("任务的创建时间：" + task.getCreateTime());
                System.out.println("流程实例ID：" + task.getProcessInstanceId());
                System.out.println("#######################################");
            }
        }
    }

    /**查询组任务*/
  //  @Test
    public void findGroupTaskList(){
        //任务办理人
        String candidateUser = "大大";
        List<Task> list = processEngine.getTaskService()//
                .createTaskQuery()//
                .taskCandidateUser(candidateUser)//参与者，组任务查询
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

    /**查询正在执行的组任务列表*/
  //  @Test
    public void findGroupCandidate(){
        //任务ID
        String taskId = "202510";
        List<IdentityLink> list = processEngine.getTaskService()//
                .getIdentityLinksForTask(taskId);

        if(list!=null && list.size()>0){
            for(IdentityLink identityLink:list){
                System.out.println("任务ID："+identityLink.getTaskId());
                System.out.println("流程实例ID："+identityLink.getProcessInstanceId());
                System.out.println("用户ID："+identityLink.getUserId());
                System.out.println("工作流角色ID："+identityLink.getGroupId());
                System.out.println("#########################################");
            }
        }
    }

    /**
     * 完成任务
     */
  //  @Test
    public void completeTask() {
        //任务ID
        String taskId = "202510";
        processEngine.getTaskService().complete(taskId);
        System.out.println("完成任务：" + taskId);
    }



    /**将组任务指定个人任务(拾取任务)*/
   // @Test
    public void claim(){
        //任务ID
        String taskId = "6308";
        //个人任务的办理人
        String userId = "唐僧";
        processEngine.getTaskService()//
                .claim(taskId, userId);
    }

    /**将个人任务再回退到组任务（前提：之前这个任务是组任务）
     * 将个人任务从一个人分配给另一个人
     */
   // @Test
    public void setAssignee(){
        //任务ID
        String taskId = "6308";
        processEngine.getTaskService()//
                .setAssignee(taskId, null);
    }

    /**向组任务中添加成员*/
 //   @Test
    public void addGroupUser(){
        //任务ID
        String taskId = "6308";
        //新增组任务的成员
        String userId = "如来";
        processEngine.getTaskService()//
                .addCandidateUser(taskId, userId);
    }

    /**向组任务中删除成员*/
 //   @Test
    public void deleteGroupUser(){
        //任务ID
        String taskId = "6308";
        //新增组任务的成员
        String userId = "猪八戒";
        processEngine.getTaskService()//
                .deleteCandidateUser(taskId, userId);
    }

}

