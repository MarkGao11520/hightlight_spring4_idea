package com.wisely.highlight_spring4.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/6/8.
 */
public class TestInterfaceSystem {

    ProcessEngine config = ProcessEngines.getDefaultProcessEngine();

    /*
     * 部署流程
     */
 //   @Test
    public void Test1() {

        RepositoryService repositoryService = config.getRepositoryService();

        DeploymentBuilder deploymentBuilder = repositoryService
                .createDeployment();
        deploymentBuilder.addClasspathResource("diagrams/system.bpmn");
        Deployment deployment = deploymentBuilder.deploy();
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    /*
     * 通过流程实例的id，来启动实例
     */
   // @Test
    public void test2() {

        RuntimeService runtimeService = config.getRuntimeService();

        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("systemprocess");
         System.out.println(processInstance.getActivityId());

    }

    /*
     * 創建接口的任務操作
     */
    //  @Test
    public void test3() {

        TaskService taskService = config.getTaskService();
        Task task = taskService.createTaskQuery().taskId("117504").singleResult();

        task.setOwner("李四");
        taskService.saveTask(task);
        System.out.println("--------------------");
    }

    /*
     * 组员完成任务，需要把接口信息提交给组长，李四提交任务
     */
  //  @Test
    public void test4() {


        Map<String , Object> map=new HashMap<String , Object>();
        map.put("InterfaceName", "Student");
        map.put("canshu", "参数有id，并且是int类型，有name，并且是String类型"); map.put("fanhuizhi", "返回信息");


        String taskid="137508"; TaskService taskService=config.getTaskService();
        taskService.complete(taskid,map); System.out.println("组员提交任务");


        // -----------------------------------------------李四查看自己已经提交的信息

    /*  HistoryService historyService = config.getHistoryService();

        HistoricTaskInstance historicTaskInstance = historyService
                .createHistoricTaskInstanceQuery().taskId("8").singleResult();

        System.out.println(historicTaskInstance.getExecutionId());
        System.out.println(historicTaskInstance.getProcessInstanceId());

        Map<String, Object> map = config.getRuntimeService().getVariables(
                historicTaskInstance.getExecutionId());

        for (String key : map.keySet()) {
            System.out.print("key=" + key);
            System.out.println("value=" + map.get(key));
        }
*/
        System.out.println();
    }

    /*
     * 组长获取组员传递过来的接口信息，进行查看后，进行判断开始下一步
     */
    @Test
    public void test5() {

        //设置组长的任务中的name名称
        TaskService taskService = config.getTaskService();
        Task task = taskService.createTaskQuery().taskId("142505").singleResult();

        task.setOwner("组长一123");
        taskService.saveTask(task);
        System.out.println("--------------------");



//        //组长先查看接口的参数信息
//        // -----------------------------------------------李四查看自己已经提交的信息
//
//        HistoryService historyService = config.getHistoryService();
//
//        //根据名称来查看当前的任务信息，因为id在流程中是不确定的
//        HistoricTaskInstance historicTaskInstance2 = historyService
//                .createHistoricTaskInstanceQuery().taskId("92506").singleResult();
//
//        HistoricTaskInstance historicTaskInstance=historyService.createHistoricTaskInstanceQuery().taskOwner("组长一123").singleResult();
//        System.out.println(historicTaskInstance.getExecutionId());
//        System.out.println(historicTaskInstance.getProcessInstanceId());
//
//        Map<String, Object> map = config.getRuntimeService().getVariables(
//                historicTaskInstance.getExecutionId());
//
//        for (String key : map.keySet()) {
//            System.out.print("key=" + key);
//            System.out.println("value=" + map.get(key));
//        }
//
//        System.out.println();



        //开始审批接口信息

        //组长一首先拒绝，把信息再次打回去，需要添加拒绝的理由
        Map<String, Object>  canshu=new HashMap<String, Object>();
        canshu.put("check", false);


        String taskid="142505";

        taskService.complete(taskid,canshu);
        System.out.println("组长拒绝任务提交");





    }

 //   @Test
    public void test6(){

        //把拒绝的信息给组员来看

        //设置组长的任务中的name名称
        TaskService taskService = config.getTaskService();
        Task task = taskService.createTaskQuery().taskId("65005").singleResult();

        task.setOwner("张三");
        taskService.saveTask(task);
        System.out.println("--------------------");


        //根据任务的name属性，来进行判断，是系统提醒，还是需要开发的任务，并且也可以判断是拒绝的信息，还是接口完成后提醒的信息


    }

 //   @Test
    public void test7(){

        //组员只看一下拒绝的信息，然后直接点击关闭按钮，则此流程进行结束


        String taskid="112504";
        TaskService taskService=config.getTaskService();
        taskService.complete(taskid);
        System.out.println("组员查看拒绝系统消息后，结束此流程");


    }




    //组长二开始审批，可以查看接口任务信息，查看完后，进行拒绝 或者向下分配，拒绝就不多说了，参考上一个组长
    //向下分配任务方法

 //   @Test
    public void test8(){

        //首先根据名称来查询需要的处理的任务
        //组长同意申请

        TaskService taskService=config.getTaskService();
        Map<String, Object>  canshu=new HashMap<String, Object>();
        canshu.put("days", 1);
        String taskid="62506";

        taskService.complete(taskid,canshu);
        System.out.println("组长二同意后，进行分配任务");

        //每一个任务，都需需要为任务添加人员名称（在此代码省略……………………）
    }


    //组员开发任务
//    @Test
    public void test9(){
        //组员开发接口，最后提交任务，此时把组员开发完的信息，添加到自己设计的库中，并且此时变量为局部变量
        Map<String, Object>  kaifa=new HashMap<String, Object>();


        kaifa.put("canshuyi", "canshuyi");
        kaifa.put("canshuer", "canshuer");


        TaskService taskService=config.getTaskService();

        taskService.setVariablesLocal("503",kaifa);
        taskService.complete("503");
        System.out.println("组员开发完任务后，把接口的详情，写入到系统参数中区");
    }


    //组员查看别人已经写好的接口信息，这时查看的时候，去变量表中查看，
//    @Test
    public void test10(){
        //组员开发接口，最后提交任务，此时把组员开发完的信息，添加到自己设计的库中，并且此时变量为局部变量
        Map<String, Object>  kaifa=new HashMap<String, Object>();


        kaifa.put("canshuyi", "canshuyi");
        kaifa.put("canshuer", "canshuer");


        TaskService taskService=config.getTaskService();

        taskService.setVariablesLocal("604",kaifa);
//      taskService.complete("503");
        System.out.println("组员开发完任务后，把接口的详情，写入到系统参数中区");
    }
}
