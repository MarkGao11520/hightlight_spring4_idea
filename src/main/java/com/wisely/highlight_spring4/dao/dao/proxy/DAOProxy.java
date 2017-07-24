package com.wisely.highlight_spring4.dao.dao.proxy;

import com.wisely.highlight_spring4.dao.dao.IDao;
import com.wisely.highlight_spring4.dao.dao.impl.DaoImpl;
import com.wisely.highlight_spring4.dao.dbc.DatabaseConnection;
import com.wisely.highlight_spring4.dao.dbc.DatabaseConnectionFactory;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public abstract class DAOProxy<T> implements IDao<T> {
    protected DatabaseConnection dbc = null;
    private IDao<T> dao = null;
    public DAOProxy(T t)throws Exception{
        this.dbc = DatabaseConnectionFactory.getDatabaseConnection();
        DaoImpl<T> daoImpl = new DaoImpl(this.dbc.getConnection(),t);
        this.dao = daoImpl;
    }

    @Override
    public boolean doCreate(T t) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doCreate(t);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<T> findAll() throws Exception {
        List<T> all = null;
        try {
            all = this.dao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return all;
    }
}
