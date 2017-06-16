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
        System.out.println(JSON.toJSONString(DAOFactory.getIUserDAOInstance().findAll()));
    }
}
