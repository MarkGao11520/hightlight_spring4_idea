package com.wisely.highlight_spring4.dao.factory;

import com.wisely.highlight_spring4.dao.dao.IUserDao;
import com.wisely.highlight_spring4.dao.dao.proxy.UserDAOProxy;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public class DAOFactory {
    public static IUserDao getIUserDAOInstance()throws Exception{
        return new UserDAOProxy();
    }
}
