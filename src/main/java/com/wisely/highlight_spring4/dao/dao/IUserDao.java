package com.wisely.highlight_spring4.dao.dao;

import com.wisely.highlight_spring4.dao.vo.User;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public interface IUserDao {
    public boolean doCreate(User user)throws Exception;

    public List<User> findAll() throws Exception;
}
