package com.wisely.highlight_spring4.dao.dao.proxy;

import com.wisely.highlight_spring4.dao.dao.IUserDao;
import com.wisely.highlight_spring4.dao.dao.impl.UserDaoImpl;
import com.wisely.highlight_spring4.dao.dbc.DatabaseConnection;
import com.wisely.highlight_spring4.dao.dbc.DatabaseConnectionFactory;
import com.wisely.highlight_spring4.dao.vo.User;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public class UserDAOProxy implements IUserDao{
    private DatabaseConnection dbc = null;
    private IUserDao dao = null;
    public UserDAOProxy()throws Exception{
        this.dbc = DatabaseConnectionFactory.getDatabaseConnection();
        this.dao = new UserDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean doCreate(User user) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doCreate(user);
        }catch (Exception e){
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> all = null;
        try {
            all = this.dao.findAll();
        }catch (Exception e){
            this.dbc.close();
        }
        return all;
    }
}
