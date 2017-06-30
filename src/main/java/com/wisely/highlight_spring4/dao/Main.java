package com.wisely.highlight_spring4.dao;

import com.alibaba.fastjson.JSON;
import com.wisely.highlight_spring4.dao.factory.DAOFactory;
import com.wisely.highlight_spring4.dao.vo.User;

/**
 * Created by gaowenfeng on 2017/6/3.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        User user = new User();
//        user.setUname("zsx");
//        user.setPassword("zsx");
//        DAOFactory.getIUserDAOInstance().doCreate(user);
        Main main = new Main();
        int a = main.add(1,2);
        int b = main.test(a);
        int c = b++;
        System.out.println(c);
     //   System.out.println(JSON.toJSONString(DAOFactory.getIUserDAOInstance().findAll()));
    }

    Main(){
        System.out.println("1334");
    }

    public  int add(int a,int b){
        b = b--;
        return a+b;
    }

    public  int test(int a){
        return ++a;
    }

}


