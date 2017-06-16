package com.wisely.highlight_spring4.activiti;

import com.wisely.highlight_spring4.activiti.pojo.Person;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/8.
 */
public class AcTestProcessInstanceService {
    ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
    IdentityService identityService = context.getBean(IdentityService.class);
    TaskService taskService = context.getBean(TaskService.class);
    RuntimeService runtimeService = context.getBean(RuntimeService.class);
    HistoryService historyService = context.getBean(HistoryService.class);

    /**设置流程变量
     * 基本类型*/
   // @Test
    public void setProcessVariables(){
        String processInstanceId = "152501";//流程实例ID
        String assignee = "张三";//任务办理人

        //查询当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)//使用流程实例ID
                .taskAssignee(assignee)//任务办理人
                .singleResult();

        //设置流程变量【基本类型】
        taskService.setVariable(task.getId(), "请假人", assignee);
        taskService.setVariableLocal(task.getId(), "请假天数",3);
        taskService.setVariable(task.getId(), "请假日期", new Date());
    }


    /**设置流程变量？去哪个表里查
     * javabean类型
     * 数据库对应表：act_ru_variable，细心的你可以看到，通过JavaBean设置的流程变量，在act_ru_variable中存储的类型为serializable，
     * 变量真正存储的地方在act_ge_bytearray中。*/
 //   @Test
    public void setProcessVariablesByJavaBean(){
        String processInstanceId = "152501";//流程实例ID
        String assignee = "张三";//任务办理人

        //查询当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)//使用流程实例ID
                .taskAssignee(assignee)//任务办理人
                .singleResult();

        //设置流程变量【javabean类型】
        Person p = new Person();
        p.setId(1);
        p.setName("周江霄");
        taskService.setVariable(task.getId(), "人员信息", p);
        System.out.println("流程变量设置成功~~");
    }

    /**获取流程变量
     * 基本类型
     * */
 //   @Test
    public void getProcessVariables(){
        String processInstanceId = "152501";//流程实例ID
        String assignee = "张三";//任务办理人
        //获取当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(assignee)
                .singleResult();

        //获取流程变量【基本类型】
        String person = (String) taskService.getVariable(task.getId(), "请假人");
        Integer day = (Integer) taskService.getVariableLocal(task.getId(), "请假天数");
        Date date = (Date) taskService.getVariable(task.getId(), "请假日期");
        System.out.println(person+"  "+day+"   "+date);

    }

    /**获取流程变量
     * JavaBean类型*/
   // @Test
    public void getProcessVariablesJavaBean(){
        String processInstanceId = "152501";//流程实例ID
        String assignee = "张三";//任务办理人
        //获取当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(assignee)
                .singleResult();

        //获取流程变量【javaBean类型】
        Person p = (Person) taskService.getVariable(task.getId(), "人员信息");
        System.out.println(p.getId()+"  "+p.getName());
        System.out.println("获取成功~~");
    }

    /**查询历史的流程变量
     * act_hi_varinst*/
  //  @Test
    public void getHistoryProcessVariables(){
        List<HistoricVariableInstance> list = historyService
                .createHistoricVariableInstanceQuery()//创建一个历史的流程变量查询
                .variableName("请假人")
                .list();

        if(list != null && list.size()>0){
            for(HistoricVariableInstance hiv : list){
                System.out.println(hiv.getTaskId()+"  "+hiv.getVariableName()+"     "+hiv.getValue()+"      "+hiv.getVariableTypeName());
            }
        }
    }

    /**查询历史流程实例
     * act_hi_procinst
     * */
  //  @Test
    public void findHisProcessInstance(){
        List<HistoricProcessInstance> list = historyService
                .createHistoricProcessInstanceQuery()
                .processDefinitionId("systemprocess:3:107504")//流程定义ID
                .list();

        if(list != null && list.size()>0){
            for(HistoricProcessInstance hi:list){
                System.out.println(hi.getId()+"   "+hi.getStartTime()+"   "+hi.getEndTime());
            }
        }
    }

    /**查询历史任务
     * 问题：HistoricTaskInstance对应哪个表
     * act_hi_taskinst*/
    @Test
    public void findHisTaskList(){
        String processInstanceId = "137505";
        List<HistoricTaskInstance> list = historyService
                .createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();
        if(list!=null && list.size()>0){
            for(HistoricTaskInstance hti:list){
                System.out.println(hti.getId()+"    "+hti.getName()+"   "+hti.getClaimTime());
            }
        }
    }

    /**查询历史活动
     * 问题：HistoricActivityInstance对应哪个表  act_hi_actinst
     * 问题：HistoricActivityInstance和HistoricTaskInstance有什么区别*
     *        HistoricActivityInstances记录所有的历史活动，包括网关，事件等非任务的活动，HistoricTaskInstance记录的只是所有的任务
     * */
   // @Test
    public void findHisActivitiList(){
        String processInstanceId = "137505";
        List<HistoricActivityInstance> list = historyService
                .createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();
        if(list != null && list.size()>0){
            for(HistoricActivityInstance hai : list){
                System.out.println(hai.getId()+"  "+hai.getActivityName());
            }
        }
    }
}
