package com.wisely.highlight_spring4.activiti;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AcTest {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:activiti-context.xml");
	RepositoryService repositoryService = context.getBean(RepositoryService.class);
	IdentityService identityService = context.getBean(IdentityService.class);
	TaskService taskService = context.getBean(TaskService.class);
	RuntimeService runtimeService = context.getBean(RuntimeService.class);

	public void createTable(){
		/** 使用配置文件创建工作流需要的23张表 */
		 ProcessEngine  processEngine = ProcessEngineConfiguration //工作流的核心对象，ProcessEngine对象
		 .createProcessEngineConfigurationFromResource(
		 "my-config.xml").buildProcessEngine();
		 System.out.println("processEngine:" + processEngine);
	}

	public void testProcessEngines(){
		// 初始化ProcessEngines的Map,
		// 再加载Activiti默认的配置文件（classpath下的activiti.cfg.xml文件）
		// 如果与Spring整合，则读取classpath下的activiti-context.xml文件
		ProcessEngines.init();
		// 会进行判断，看是否初始化，如果已经初始化好的话，直接从map中取值即可
		ProcessEngine aEngine = ProcessEngines.getDefaultProcessEngine();

		// 得到ProcessEngines的Map
		Map<String, ProcessEngine> engines = ProcessEngines.getProcessEngines();
		System.out.println(engines.size());
		System.out.println(engines.get("default"));
		//调用销毁的方法
		//ProcessEngines.destroy();
		// 从map集合中去除实例化好的ProcessEngine对象
		ProcessEngines.unregister(aEngine);

		System.out.println(engines.size());
		System.out.println(engines.get("default"));
	}

	public void testUserQuery(){
		// 得到身份服务组件实例
		IdentityService identityService = context.getBean(IdentityService.class);
		// 写入5条用户组数据
		createGroup(identityService, "1", "userA", "typeA");
		createGroup(identityService, "2", "userB", "typeB");
		createGroup(identityService, "3", "userC", "typeC");
		createGroup(identityService, "4", "userD", "typeD");
		createGroup(identityService, "5", "userE", "typeE");
		// 调用listPage方法，从索引为2的记录开始，查询3条记录
		List<Group> datas = identityService.createGroupQuery().listPage(2, 3);
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}


		List<Group> datas0 = identityService.createGroupQuery().list();
		for (Group data : datas0) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}

		// 查询名称为userB的记录
		Group groupB = identityService.createGroupQuery().groupName("userB")
				.singleResult();
		System.out.println(groupB.getId() + "---" + groupB.getName());

		System.out.println("asc排序结果");
		List<Group> datas2 = identityService.createGroupQuery()
				.orderByGroupId().asc().list();
		for (Group data : datas2) {
			System.out.print(data.getId() + "---" + data.getName() + " ");
		}
	}

	// 将用户组数据保存到数据库中
	void createGroup(IdentityService identityService, String id,
							String name, String type) {
		// 调用newGroup方法创建Group实例
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}

	//创建用户方法
	static void creatUser(IdentityService identityService, String id, String first, String last, String email, String passwd) {
		// 使用newUser方法创建User实例
		User user = identityService.newUser(id);
		// 设置用户的各个属性
		user.setFirstName(first);
		user.setLastName(last);
		user.setEmail(email);
		user.setPassword(passwd);
		// 使用saveUser方法保存用户
		identityService.saveUser(user);
	}

	@Test
	public void main() {
//		taskService.claim("2504","zhangsan");
//		taskService.setAssignee("2504","lisi");
		System.out.println(taskService.createTaskQuery().list());
	}

	/**
	 * 流程部署定义
	 */
	public void  deploymentProcessDefinition(){
    	Deployment deployment = repositoryService // 与流程定义和部署对象相关的Service
				.createDeployment() // 创建一个部署对象
				.name("gwftest") // 添加部署的名称
				.addClasspathResource("diagrams/process.bpmn20.xml") // 从classpath的资源中加载，一次只能加载一个文件
//				.addClasspathResource("diagrams/HelloWorld.png") // 从classpath的资源中加载，一次只能加载一个文件
				.enableDuplicateFiltering()
				.deploy(); // 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());



//		return deployment;
	}

	public void testUserCandidate(String defid){
		Deployment deployment = null;
		//查询流程定义实体
		ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		// 输出结果为 bpmn/diagram.vacationProcess.png
		System.out.println(def.getDiagramResourceName());
		testUserCandidate(def.getId());
		creatUser(identityService, "zhangsan", "张", "三", "abc@163.com", "123");
		repositoryService.addCandidateStarterUser(defid, "张三");
	}
    
 	/**
		 * 启动流程实例
		 */
	public void startProcessInstance(){
   
		String processDefinitionKey = "process";
		ProcessInstance processInstance = processEngine.getRuntimeService() // 与正在执行的流程实例和执行对象相关的Service
				.startProcessInstanceByKey(processDefinitionKey); //// 使用流程定义的key启动流程实例,key对应,helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:" + processInstance.getId());
		System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());
    }
    
    /**
	 * 查询当前的个人任务
	 */
	public void findMyPersonalTask(){
		String assignee = "zhangsan";
		List<Task> list = processEngine.getTaskService() // 与正在执行的任务管理相关的Service
				.createTaskQuery() // 创建任务查询
				.taskOwner(assignee) // 制定个人任务查询，指定办理人
				.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + task.getCreateTime());
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("##########################");
			}
		}
    }


    /**
	 * 完成当前任务
	 */
    @Test
	public void completeMyPersonalTask(){
		String taskId ="20002";
	 processEngine.getTaskService().complete(taskId);
	 System.out.println("完成任务：任务ID：" + taskId);
    }
}
