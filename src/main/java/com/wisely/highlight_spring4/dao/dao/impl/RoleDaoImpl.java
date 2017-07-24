package com.wisely.highlight_spring4.dao.dao.impl;

import com.wisely.highlight_spring4.dao.dao.IRoleDao;
import com.wisely.highlight_spring4.dao.vo.Role;

import java.sql.Connection;

/**
 * Created by gaowenfeng on 2017/7/8.
 */
public class RoleDaoImpl extends DaoImpl<Role> implements IRoleDao{
    public RoleDaoImpl(Connection connection, Role role) {
        super(connection, role);
    }
}
