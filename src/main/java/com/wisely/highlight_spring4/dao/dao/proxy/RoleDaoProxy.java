package com.wisely.highlight_spring4.dao.dao.proxy;

import com.wisely.highlight_spring4.dao.dao.IRoleDao;
import com.wisely.highlight_spring4.dao.dao.impl.RoleDaoImpl;
import com.wisely.highlight_spring4.dao.vo.Role;

/**
 * Created by gaowenfeng on 2017/7/8.
 */
public class RoleDaoProxy extends DAOProxy<Role> implements IRoleDao {
    IRoleDao iRoleDao;
    public RoleDaoProxy(Role role) throws Exception {
        super(role);
        RoleDaoImpl roleDaoImpl = new RoleDaoImpl(super.dbc.getConnection(),role);
        this.iRoleDao = roleDaoImpl;
    }
}
