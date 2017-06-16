package com.wisely.highlight_spring4.mybatis;

import com.alibaba.fastjson.JSON;
import com.wisely.highlight_spring4.mybatis.mapper.UserMapper;
import com.wisely.highlight_spring4.mybatis.pojo.Role;
import com.wisely.highlight_spring4.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/5/17.
 */
public class TestMybatis {
    @Test
    public void testMybatis(){
        String filePath = "../../../../mybatisAnnotationConfig.xml";
        InputStream is = this.getClass().getResourceAsStream(filePath);
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        annotationInsert(sqlSession);
        sqlSession.commit();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        annotationSelectOne(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    public void select(SqlSession sqlSession){
        String statement1 = "roleMapper.findRole";
        List<Role> list = sqlSession.selectList(statement1);
        for(Role role:list){
            System.out.println(JSON.toJSONString(role));
        }
    }

    public void insert(SqlSession sqlSession){
        String statement = "testMapper.testInsert";
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        User user1 = new User();
        user1.setUsername("ccc");
        user1.setPassword("ddd");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        System.out.println(sqlSession.insert(statement,list));
        System.out.println(JSON.toJSONString(list));
    }

    public void annotationSelect(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Role> list = userMapper.findRole();
        for(Role role:list){
            System.out.println(JSON.toJSONString(role));
        }
    }

    public void annotationSelectOne(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Long id = Long.parseLong("34");
        User list = userMapper.findUserOne(id);
        System.out.println(JSON.toJSONString(list));
    }

    public void annotationDelete(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.deleteUserById(13);
        if(result==1){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }

    public void annotationUpdate(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("gzf");
        user.setId(12);
        int result = userMapper.updateUserById(user);
        if(result==1){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }

    public void annotationInsert(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("cty");
        user.setPassword("cty");
        user.setRoleid(2);
        int result = userMapper.insertUser(user);
        if(result==1){
            System.out.println("ok");
            System.out.println(JSON.toJSONString(user));
        }else{
            System.out.println("error");
        }
    }


    public void annotationInsertBatch(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        User user1 = new User();
        user1.setUsername("ccc");
        user1.setPassword("ddd");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        int result = userMapper.insertUserBatch(list);
        if(result>0){
            System.out.println("ok");
            System.out.println(JSON.toJSONString(list));
        }else{
            System.out.println("error");
        }
    }


    public void callInsert(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.testCall(2));
    }



}
