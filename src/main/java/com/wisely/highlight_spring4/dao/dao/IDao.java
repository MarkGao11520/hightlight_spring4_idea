package com.wisely.highlight_spring4.dao.dao;

import com.wisely.highlight_spring4.dao.vo.User;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public interface IDao<T> {
    public boolean doCreate(T model)throws Exception;

    public List<T> findAll() throws Exception;
}
