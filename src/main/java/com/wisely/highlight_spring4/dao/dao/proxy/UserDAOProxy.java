package com.wisely.highlight_spring4.dao.dao.proxy;


import com.wisely.highlight_spring4.dao.dao.IUserDao;
import com.wisely.highlight_spring4.dao.dao.impl.UserDaoImpl;
import com.wisely.highlight_spring4.dao.vo.User;

/**
 * Created by gaowenfeng on 2017/7/8.
 */
public class UserDaoProxy extends DAOProxy<User> implements IUserDao{
    private IUserDao iUserDao;
    public UserDaoProxy(User u) throws Exception {
        super(u);
        UserDaoImpl userDaoImpl = new UserDaoImpl(super.dbc.getConnection(),u);
        this.iUserDao = userDaoImpl;
    }
}
