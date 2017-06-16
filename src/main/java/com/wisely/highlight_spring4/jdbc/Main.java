package com.wisely.highlight_spring4.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/4/5.
 */
public class Main {
//    @Autowired
   JdbcTemplate jdbcTemplate;


    public void testJDBC() throws  Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "select * from sys_user";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> maps : list){
            System.out.println(maps.get("username")+","+maps.get("password"));
            System.out.println("------");
        }
    }

    @Test
    public void insertDB() throws  Exception{
        testJDBC();
        String sql = "insert into sys_user(username,password) values(?,?)";
        int i = jdbcTemplate.update(sql,new Object[]{"cty","cty"});
        if(i>0){
            System.out.println("添加数据成功");
        }else{
            System.out.println("添加数据失败");
        }
    }


}
