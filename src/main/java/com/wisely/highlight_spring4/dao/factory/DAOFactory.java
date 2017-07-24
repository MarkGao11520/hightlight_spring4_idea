package com.wisely.highlight_spring4.dao.factory;

import com.wisely.highlight_spring4.dao.dao.IDao;
import com.wisely.highlight_spring4.dao.dao.IRoleDao;
import com.wisely.highlight_spring4.dao.dao.proxy.RoleDaoProxy;
import com.wisely.highlight_spring4.dao.dao.proxy.UserDaoProxy;
import com.wisely.highlight_spring4.dao.vo.Role;
import com.wisely.highlight_spring4.dao.vo.User;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public class DAOFactory {
    public static IDao getIUserDAOInstance()throws Exception{
        return new UserDaoProxy(new User());
    }

    public static IRoleDao getIRoleDaoInstance()throws Exception{
        return new RoleDaoProxy(new Role());
    }
}
