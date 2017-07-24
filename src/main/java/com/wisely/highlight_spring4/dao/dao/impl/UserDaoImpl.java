package com.wisely.highlight_spring4.dao.dao.impl;

import com.wisely.highlight_spring4.dao.dao.IDao;
import com.wisely.highlight_spring4.dao.dao.IUserDao;
import com.wisely.highlight_spring4.dao.vo.User;

import java.sql.Connection;

/**
 * Created by gaowenfeng on 2017/7/8.
 */
public class UserDaoImpl extends DaoImpl<User> implements IUserDao{

    public UserDaoImpl(Connection connection, User user) {
        super(connection, user);
    }
}
