package com.wisely.highlight_spring4.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/8.
 */
public class AcTestRepositoryService {
    ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
    RepositoryService repositoryService = context.getBean(RepositoryService.class);
    RuntimeService runtimeService = context.getBean(RuntimeService.class);

    /**
     * 流程部署
     */
  //  @Test
    public void  deploymentProcessDefinition(){
        Deployment deployment = repositoryService // 与流程定义和部署对象相关的Service
                .createDeployment() // 创建一个部署对象
                .name("helloworld") // 添加部署的名称
                .addClasspathResource("diagrams/HelloWorld.bpmn") // 从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("diagrams/HelloWorld.png") // 从classpath的资源中加载，一次只能加载一个文件
                .enableDuplicateFiltering()
                .deploy(); // 完成部署
        System.out.println("部署ID:" + deployment.getId());
        System.out.println("部署名称:" + deployment.getName());
    }

    /**
     * 流程启动
     */
  //  @Test
    public void startProcessInstance(){

        String processDefinitionKey = "helloworld";
        ProcessInstance processInstance = runtimeService // 与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey); //// 使用流程定义的key启动流程实例,key对应,helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());
    }
    /**
     * 查询流程定义
     */
   // @Test
    public void findProcessDifinitionList() {
        List<ProcessDefinition> list = repositoryService
                .createProcessDefinitionQuery()
                // 查询条件
                .processDefinitionKey("systemprocess")// 按照流程定义的key
                // .processDefinitionId("helloworld")//按照流程定义的ID
                .orderByProcessDefinitionVersion().desc()// 排序
                // 返回结果
                // .singleResult()//返回惟一结果集
                // .count()//返回结果集数量
                // .listPage(firstResult, maxResults)
                .list();// 多个结果集

        if(list!=null && list.size()>0){
            for(ProcessDefinition pd:list){
                System.out.println("流程定义的ID："+pd.getId());
                System.out.println("流程定义的名称："+pd.getName());
                System.out.println("流程定义的Key："+pd.getKey());
                System.out.println("流程定义的部署ID："+pd.getDeploymentId());
                System.out.println("流程定义的资源名称："+pd.getResourceName());
                System.out.println("流程定义的版本："+pd.getVersion());
                System.out.println("########################################################");
            }
        }

    }

    /**
     * 删除流程定义
     */
    @Test
    public void deleteProcessDifinition(){
        //部署对象ID
        String deploymentId = "160001";
        repositoryService//获取流程定义和部署对象相关的Service
                .deleteDeployment(deploymentId,true);

        System.out.println("删除成功~~~");//使用部署ID删除流程定义,true表示级联删除
    }

    /**
     * 查看流程定义的资源文件
     * @throws IOException
     */
//    @Test
    public void viewPng() throws IOException {
        //部署ID
        String deploymentId = "1";
        //获取的资源名称
        List<String> list =  repositoryService
                .getDeploymentResourceNames(deploymentId);
        //获得资源名称后缀.png
        String resourceName = "";
        if(list != null && list.size()>0){
            for(String name:list){
                if(name.indexOf(".png")>=0){//返回包含该字符串的第一个字母的索引位置
                    resourceName = name;
                }
            }
        }

        //获取输入流，输入流中存放.PNG的文件
        InputStream in = repositoryService
                .getResourceAsStream(deploymentId, resourceName);

        System.out.println(resourceName);
        //将获取到的文件保存到本地
        FileUtils.copyInputStreamToFile(in, new File("/Users/gaowenfeng/Desktop/" + resourceName));

        System.out.println("文件保存成功！");
    }



//		return deployment;

}
